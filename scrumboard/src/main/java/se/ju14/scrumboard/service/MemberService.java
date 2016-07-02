package se.ju14.scrumboard.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.repository.JpaMemberRepository;

/**
 * This class manages the Member functions and service
 * 
 * @author Erik Pérez Jesper Wendler
 */
@Path("/member")
public class MemberService extends ScrumService<Member, JpaMemberRepository> {

	@GET
	public Response getMembers(@DefaultValue("-") @QueryParam("by") String by,
			@DefaultValue("-") @QueryParam("filter") String filter) {

		Object result = (List<Member>) memberRepository.getAll();
		if (filter.equals("-")) {
			switch (by) {
			case "firstname":
				result = (List<Member>) memberRepository.getByFirstName(filter);
				break;
			case "lastname":
				result = (List<Member>) memberRepository.getByLastName(filter);
				break;
			case "username":
				result = (Member) memberRepository.getByUserName(filter);
				break;
			}
		}
		return super.get(result);
	}

	@Path("{id}")
	@GET
	public Response getMemberById(@PathParam("id") String id) {
		return super.get(memberRepository.getByMemberId(id));
	}

	@POST
	public Response saveMember(Member member) {
		Member savedMember = memberRepository.save(member);
		return super.post(savedMember.getMemberId(), "Member created successfully! ");
	}

	@PUT
	public Response updateMember(final Member member) {
		Member memberToUpdate = memberRepository.getByMemberId(member.getMemberId());
		return super.putOrDelete(true, (memberToUpdate != null), memberRepository, m -> m.update(member).getMemberId(),
				"Member Updated ", "Member not found");
	}

	@Path("{id}")
	@DELETE
	public Response deleteMember(@PathParam("id") String id) {
		Member memberFound = memberRepository.getByMemberId(id);
		return super.putOrDelete(false, (memberFound != null), memberRepository,
				m -> m.delete(memberFound).getMemberId(), "Member successfully deleted ", "Member not found");
	}

	@Path("{id}/workitem")
	@GET
	public Response getTeamMembers(@PathParam("id") String id) {
		Member memberFound = memberRepository.getByMemberId(id);
		if (memberFound != null) {
			return get(itemRepository.getByMember(memberFound));
		}
		return super.noContent("Member not found");
	}

	@Path("{id}/workitem/{itemId}")
	@PUT
	public Response assignWorkItemToMember(@PathParam("id") String id, @PathParam("itemId") String itemId) {
		WorkItem wiFound = itemRepository.getByItemId(itemId);
		Member memberFound = memberRepository.getByMemberId(id);
		return super.putOrDelete(true, wiFound != null && memberFound != null, memberRepository,
				m -> m.addWorkItemToMember(memberFound, wiFound).getMemberId(), "WorkItem Added to Member ",
				"Member or workItem not found");
	}

}