package se.ju14.scrumboard.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/team")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamService {
	
	@POST
	public Response createTeam(){
		return null;
	}
	
	@PUT
	public Response updateTeam(){
		return null;
	}
	
	@DELETE
	public Response deleteTeam(){
		return null;
	}
	
	@GET
	public Response getAllTeams(){
		return null;
	}
	
	@GET
	public Response getAllTeamMembers(){
		return null;
	}

}
