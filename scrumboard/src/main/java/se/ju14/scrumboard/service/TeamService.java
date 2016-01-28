package se.ju14.scrumboard.service;



import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.repository.JpaTeamRepository;
/**
 * This class manages the team functions and service
 * @author Erik Pérez,Pierre Vanderpol
 **/
@Path("/team")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamService  {
	
	static final JpaTeamRepository jpaTeamRepo = new JpaTeamRepository(); 
	
	@Context
	private UriInfo uriInfo;

	
	/**
	 *Creates a team 
	 *@param team the team to be consumed as a JSON object
	 *@return a 200 response if it creates successfully, 404 otherwise
	 **/
	@POST
	public Response createTeam(Team team){
			Team team2 = jpaTeamRepo.create(team);
		
			URI location = uriInfo.getAbsolutePathBuilder().path(team2.getId().toString()).build();
			return Response.created(location).build();	
	}
	
	/**
	 * Updates a team's information
	 * @param teamID the id of the team to be updated
	 * */
	@PUT
	@Path("{name}")
	public Response updateTeamInfo(@PathParam("name")String teamName){

		/*
		List<Team> listTeam = jpaTeamRepo.getTeamByName(teamName).get(0);
		
		if(teamName == null){
			return Response.status(Status.BAD_REQUEST).build();
		}else{
			Team teamToUpdate = jpaTeamRepo.getTeamByName(teamName).get(0);
			jpaTeamRepo.update(teamToUpdate);
			return Response.ok(teamName, "Team updated").build();
		}
		*/
		return null;
	}
	
	
	/**
	 * Adds a new member to a team
	 * @param teamID the id of the team to be updated
	 * */
	@POST
	@Path("{name}")
	public Response addMembertoTeam(@PathParam("name")String teamName,@QueryParam("userID")String userId){
		List<Team> listTeam = jpaTeamRepo.getAll();
		
		if(teamName == null || userId == null){
			return Response.status(Status.BAD_REQUEST).build();
		}else{
			Team teamToUpdate = jpaTeamRepo.getTeamByName(teamName).get(0);
			jpaTeamRepo.update(teamToUpdate);
			return Response.ok(teamName, "Member added").build();
		}
	}
	
	/**
	 * updates a team status to DELETED
	 * @param teamID the id of the team to be deleted
	 **/
	@DELETE
	@Path("{teamName}")
	public Response deleteTeam(@PathParam("teamName")String teamName){
		List<Team> listTeam = jpaTeamRepo.getAll();
		
		if(teamName == null){
			return Response.status(Status.BAD_REQUEST).build();
		}else{
			Team teamToUpdate = jpaTeamRepo.getTeamByName(teamName).get(0);
			jpaTeamRepo.delete(teamToUpdate);
			return Response.ok(teamName, "Team updated").build();
		}
	}
	
	/**
	 * Get all the registered teams in DB
	 * @param teamID the id of the team to be deleted
	 **/
	@GET
	public Response getAllTeams(){
		
		List<Team> listTeam = jpaTeamRepo.getAll();
		
		if (listTeam == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(listTeam).build();
		
	}
	
	/**
	 * Get the members of a specific team
	 * @param teamID the id of the team
	 * @return a collection of users that are part of the team and a 200 response
	 **/
	@GET
	@Path("{id}")
	public Response getAllTeamMembers(@PathParam("id")String teamID){
		return null;
	}

}
