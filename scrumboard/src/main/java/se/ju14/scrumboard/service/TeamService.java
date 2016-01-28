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
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;

/**
 * This class manages the team functions and service
 * 
 * @author Erik Pérez
 **/
@Path("/team")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class TeamService extends ScrumService {

	/**
	 * Creates a team
	 * 
	 * @param team
	 *            the team to be consumed as a JSON object
	 * @return a 200 response if it creates successfully, 404 otherwise
	 **/
	@POST
	public Response createTeam(Team team) {
		Team teamToSave = teamRepository.save(team);
		URI location = uriInfo.getAbsolutePathBuilder().path(teamToSave.getName()).build();
		return Response.created(location).entity(teamToSave).build();
	}

	/**
	 * Updates a team's information
	 * 
	 * @param teamID
	 *            the id of the team to be updated
	 */
	@PUT
	@Path("{name}")
	public Response updateTeamInfo(@PathParam("name") String name) {
		Team teamToSave = teamRepository.update(teamRepository.getTeamByName(name));
		URI location = uriInfo.getAbsolutePathBuilder().path(teamToSave.getName()).build();
		return Response.created(location).entity(teamToSave).build();
	}

	/**
	 * Adds a new member to a team
	 * 
	 * @param teamID
	 *            the id of the team to be updated
	 */
	@POST
	@Path("{name}")
	public Response addMembertoTeam(@PathParam("name") String name, Member member) {
		Team team = teamRepository.getTeamByName(name);
		teamRepository.addMemberToTeam(member, team);
		URI location = uriInfo.getAbsolutePathBuilder().path(team.getName()).build();
		return Response.created(location).entity(team).build();
	}

	/**
	 * updates a team status to DELETED
	 * 
	 * @param teamID
	 *            the id of the team to be deleted
	 **/
	@DELETE
	@Path("{name}")
	public Response deleteTeam(@PathParam("name") String name) {
		Team team = teamRepository.getTeamByName(name);
		teamRepository.delete(team);
		URI location = uriInfo.getAbsolutePathBuilder().path(team.getName()).build();
		return Response.created(location).entity(team).build();
	}

	/**
	 * Get all the registered teams in DB
	 * 
	 * @param teamID
	 *            the id of the team to be deleted
	 **/
	@GET
	public Response getAllTeams() {
		List<Team> teamList = teamRepository.getAll();
		Collection<Team> teams = new HashSet<Team>(teamList);
		GenericEntity<Collection<Team>> result = 
				new GenericEntity<Collection<Team>>(teams){};	
		return Response.ok(result).build();
	}

	/**
	 * Get the members of a specific team
	 * 
	 * @param teamID
	 *            the id of the team
	 * @return a collection of users that are part of the team and a 200
	 *         response
	 **/
	@GET
	@Path("{name}")
	public Response getAllTeamMembers(@PathParam("name") String name){
		List<Member> teamMembers = memberRepository.getTeamMembers(teamRepository.getTeamByName(name));
		GenericEntity<Collection<Member>> result = 
				new GenericEntity<Collection<Member>>(teamMembers){};	
		return Response.ok(result).build();
	}

}
