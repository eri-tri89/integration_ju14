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

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

	@POST
	public Response createUser(){
		return null;
	}
	
	@PUT
	public Response updateUser(){
		return null;
	}
	
	@DELETE
	public Response deleteUser(){
		return null;
	}
	
	@GET
	public Response getUserById(){
		return null;
	}
	
	@GET
	public Response getUserByTeamId(){
		return null;
	}
}
