package se.ju14.scrumboard.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Users;
/**
 * This class manages the user functions and service
 * @author Erik Pérez
 * */
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserService {
	/**
	 * Creates a new user 
	 * @param user the JSON object to be converted to a user object
	 * @return a response 200 if it creates successfully, 404 otherwise
	 * */	
	@POST
	public Response createUser(Users user){
		return null;
	}
	
	/**
	 * Updates the user's data
	 * @param userId the id of the User
	 * @param user the JSON object to be converted to a user object
	 * @return the modified user object produced as an JSON object
	 * */
	@PUT
	@Path("{id}")
	public Users updateUser(@PathParam("id")String userId,Users user){
		//User object as a param or QueryParam? only some data will be changed here.
		return null;
	}
	
	/**
	 * Changes the status of the user to DELETED
	 * @param userId the id of the user to be deleted
	 * @return a response 200 if it deletes successfully, 404 otherwise
	 * */
	@DELETE
	@Path("{id}")
	public Response deleteUser(@PathParam("id")String userId){
		return null;
	}
	
	/**
	 * Get an user by its userID
	 * @param userId The id of the user to be found
	 * @return The User object found by its id 
	 * */
	@GET
	@Path("{id}")
	public Users getUserById(@PathParam("id")String userId){
		return null;
	}
	
	/**
	 * Get User by its teamID
	 * @param teamID the id of the team that the user is being part of
	 * @return The User object to be found by its team id
	 * */
	@GET
	public Users getUserByTeamId(@QueryParam("teamID")@DefaultValue("no_team") String teamId){
		return null;
	}
}
