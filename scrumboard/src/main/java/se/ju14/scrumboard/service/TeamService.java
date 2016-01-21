package se.ju14.scrumboard.service;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Team;
/**
 * This class manages the team functions and service
 * @author Erik Pérez
 **/
@Path("/team")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamService {
	
	/**
	 *Creates a team 
	 *@param team the team to be consumed as a JSON object
	 *@return a 200 response if it creates successfully, 404 otherwise
	 **/
	@POST
	public Response createTeam(Team team){
		return null;
	}
	
	/**
	 * Updates a team
	 * @param teamID the id of the team to be updated
	 * */
	@PUT
	@Path("{id}")
	public Response updateTeam(@PathParam("id")String teamID){
		return null;
	}
	
	/**
	 * updates a team status to DELETED
	 * @param teamID the id of the team to be deleted
	 **/
	@DELETE
	@Path("{id}")
	public Response deleteTeam(@PathParam("id")String teamID){
		return null;
	}
	
	/**
	 * Get all the registered teams in DB
	 * @param teamID the id of the team to be deleted
	 **/
	@GET
	public Response getAllTeams(){
		return null;
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
