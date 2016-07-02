package se.ju14.scrumboard.service;

import java.net.URI;
import java.util.List;
import java.util.function.Function;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import se.ju14.scrumboard.model.JpaEntity;
import se.ju14.scrumboard.repository.InMemoryRepository;
import se.ju14.scrumboard.repository.JpaIssueRepository;
import se.ju14.scrumboard.repository.JpaMemberRepository;
import se.ju14.scrumboard.repository.JpaTeamRepository;
import se.ju14.scrumboard.repository.JpaWorkItemRepository;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ScrumService<T extends JpaEntity, R extends InMemoryRepository<T>> {

	@Context
	protected UriInfo uriInfo;

	protected JpaMemberRepository memberRepository = new JpaMemberRepository();
	protected JpaTeamRepository teamRepository = new JpaTeamRepository();
	protected JpaWorkItemRepository itemRepository = new JpaWorkItemRepository();
	protected JpaIssueRepository issueRepository = new JpaIssueRepository();

	@SuppressWarnings("unchecked")
	protected Response get(Object toDisplay) {
		if (toDisplay != null && toDisplay instanceof List) {
			List<T> listToDisplay = (List<T>) toDisplay;
			if (!listToDisplay.isEmpty()) {
				GenericEntity<List<T>> entity = new GenericEntity<List<T>>(listToDisplay) {
				};
				return Response.ok(entity).build();
			}
		} else if (toDisplay instanceof JpaEntity) {
			if (toDisplay != null) {
				return Response.ok(toDisplay).build();
			}
		}
		return Response.noContent().type("text/plain").entity("Nothing found").build();
	}

	protected Response putOrDelete(boolean isPut, boolean condition, R r, Function<R, String> operation,
			String resultMessage, String failMessage) {
		if (condition) {
			String path = operation.apply(r);
			URI location = uriInfo.getAbsolutePathBuilder().path(path).build();
			return (isPut) ? Response.accepted(location).type("text/plain").entity(resultMessage + location).build()
					: Response.ok().type("text/plain").entity(resultMessage + location).build();
		}
		return noContent(failMessage);
	}

	protected Response post(String path, String resultMessage) {
		URI location = uriInfo.getAbsolutePathBuilder().path(path).build();
		return Response.created(location).type("text/plain").entity(resultMessage + location).build();

	}

	protected Response noContent(String message) {
		return Response.noContent().type("text/plain").entity(message).build();
	}

}
