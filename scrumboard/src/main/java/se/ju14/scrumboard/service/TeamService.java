package se.ju14.scrumboard.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.repository.JpaTeamRepository;

/**
 * This class manages the team functions and service
 * 
 * @author Erik Pérez
 **/
@Path("/team")
public class TeamService extends ScrumService<Team, JpaTeamRepository> {

	@GET
	public Response getAllTeams() {
		return get(teamRepository.getAll());
	}

	@Path("{teamName}")
	@GET
	public Response getTeamByName(@PathParam("teamName") String teamName) {
		return get(teamRepository.getTeamByName(teamName));
	}

	@POST
	public Response createTeam(Team team) {
		Team savedTeam = teamRepository.save(team);
		return super.post(savedTeam.getName(), "Team created successfully! ");
	}

	@PUT
	public Response updateTeam(Team team) {
		Team teamToUpdate = teamRepository.getTeamByName(team.getName());
		return super.putOrDelete(true, (teamToUpdate != null), teamRepository,
				t -> teamRepository.update(team).getName(), "Team Updated ", "Team not found");
	}

	@Path("{teamName}")
	@DELETE
	public Response deleteTeam(@PathParam("teamName") String teamName) {
		Team teamToDelete = teamRepository.getTeamByName(teamName);
		return super.putOrDelete(false, (teamToDelete != null), teamRepository,
				t -> teamRepository.delete(teamToDelete).getName(), "Team  deleted successfully!", "Team not found");
	}

	@Path("{teamName}/{memberId}")
	@PUT
	public Response addMemberToTeam(@PathParam("teamName") String teamName, @PathParam("memberId") String memberId) {
		Member memberToAdd = memberRepository.getByMemberId(memberId);
		Team team = teamRepository.getTeamByName(teamName);
		return super.putOrDelete(true, (memberToAdd != null && team != null), teamRepository,
				t -> teamRepository.addMemberToTeam(memberToAdd, team).getName(),
				"Member added to team \"" + teamName + "\" updated", "Team or member not found");
	}

	@Path("{teamName}/tmember")
	@GET
	public Response getTeamMembers(@PathParam("teamName") String teamName) {
		Team teamFound = teamRepository.getTeamByName(teamName);
		if (teamFound != null) {
			return get(memberRepository.getTeamMembers(teamFound));
		}
		return super.noContent("Team not found");
	}

	@Path("{teamName}/workitem")
	@GET
	public Response getWorkItemsByTeam(@PathParam("teamName") String teamName) {
		Team teamFound = teamRepository.getTeamByName(teamName);
		if (teamFound != null) {
			return get(this.itemRepository.getByTeam(teamFound));
		}
		return super.noContent("Team not found");
	}

}
