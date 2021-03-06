package se.ju14.scrumboard.service;

import java.net.URI;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import se.ju14.scrumboard.model.Member;

/**
 * This class manages the Member functions and service
 * 
 * @author Erik Pérez Jesper Wendler
 */
@Path("/member")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class MemberService extends ScrumService {

	
	

	/**
	 * Creates a new Member
	 * 
	 * @param Member
	 *            the JSON object to be converted to a Member object
	 * @return a response 200 if it creates successfully, 404 otherwise
	 */
	@POST
	public Response createMember(Member Member) {

		memberRepository.save(Member);

		URI location = uriInfo.getAbsolutePathBuilder().path(Member.getMemberId().toString()).build();

		return Response.created(location).entity(Member).build();
	}

	/**
	 * Updates the Member's data
	 * 
	 * @param memberId
	 *            the id of the Member
	 * @param member
	 *            the JSON object to be converted to a Member object
	 * @return the modified Member object produced as an JSON object
	 */
	@PUT
	@Path("{id}")
	public Response updateMember(@PathParam("id") String memberId,Member member) {
		Member memberToUpdate = memberRepository.update(member);
		URI location = uriInfo.getAbsolutePathBuilder().path(memberToUpdate.getMemberId().toString()).build();
		return Response.created(location).entity(memberToUpdate).build();

	}

	/**
	 * Changes the status of the Member to DELETED
	 * 
	 * @param MemberId
	 *            the id of the Member to be deleted
	 * @return a response 200 if it deletes successfully, 404 otherwise
	 */
	@DELETE
	@Path("{id}")
	public Response deleteMember(@PathParam("id") String MemberId) {
		Member member = memberRepository.getByMemberId(MemberId);
		memberRepository.delete(member);
		return Response.ok(member).build();
	}

	/**
	 * Get an Member by its MemberID
	 * 
	 * @param MemberId
	 *            The id of the Member to be found
	 * @return The Member object found by its id
	 */
	@GET
	@Path("{id}")
	public Response getMemberById(@PathParam("id") String MemberId) {
		Member member = memberRepository.getByMemberId(MemberId);
		return Response.ok(member).build();
	}
	
	/**
	 * Get an Members by its firstname
	 * 
	 * @param firstname
	 *            The firstname of the Member to be found
	 * @return The Member object found by its firstname
	 */
	@GET
	@Path("/getbyfirstname")
	public Response getMemberByFirstName(@QueryParam("firstname") String firstname) {
		List<Member> members = memberRepository.getByFirstName(firstname);
		GenericEntity<Collection<Member>> result = 
				new GenericEntity<Collection<Member>>(members){};	
		return Response.ok(result).build();
	}
	
	/**
	 * Get an Member by its lastname
	 * 
	 * @param lastname
	 *            The lastname of the Member to be found
	 * @return The Member object found by its lastname
	 */
	@GET
	@Path("/getbylastname")
	public Response getMemberByLastName(@QueryParam("lastname") String lastname) {
		List<Member> members = memberRepository.getByLastName(lastname);
		GenericEntity<Collection<Member>> result = 
				new GenericEntity<Collection<Member>>(members){};	
		return Response.ok(result).build();
	}
	
	/**
	 * Get an Member by its username
	 * 
	 * @param username
	 *            The username the Member to be found
	 * @return The Member object found by its username
	 */
	@GET
	@Path("/getbyusername")
	public Response getMemberByUserName(@QueryParam("username") String username) {
		Member member = memberRepository.getByUserName(username);
		return Response.ok(member).build();
	}

	/**
	 * Get Member(s) by its teamID
	 * 
	 * @param teamID
	 *            the id of the team that the Member is being part of
	 * @return The Member object to be found by its team id
	 */
	@GET
	@Path("/getbyteam")
	public Response getMembersByTeam(@QueryParam("teamname") String teamName) {
		List<Member> membersByTeam = memberRepository.getTeamMembers(teamRepository.getTeamByName(teamName));
		Collection<Member> members = new HashSet<Member>(membersByTeam);
		GenericEntity<Collection<Member>> result = 
				new GenericEntity<Collection<Member>>(members){};	
		return Response.ok(result).build();

	}
}