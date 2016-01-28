package se.ju14.scrumboard.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import se.ju14.scrumboard.repository.JpaIssueRepository;
import se.ju14.scrumboard.repository.JpaMemberRepository;
import se.ju14.scrumboard.repository.JpaTeamRepository;
import se.ju14.scrumboard.repository.JpaWorkItemRepository;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ScrumService {


	@Context
	protected UriInfo uriInfo;
	
	protected JpaMemberRepository memberRepository = new JpaMemberRepository();
	protected JpaTeamRepository teamRepository = new JpaTeamRepository();
	protected JpaWorkItemRepository itemRepository = new JpaWorkItemRepository();
	protected JpaIssueRepository issueRepository = new JpaIssueRepository();
}
