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

@Path("/workitem")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorkItemService {

	@POST
	public Response createWorkItem(){
		return null;
	}
	
	@PUT
	public Response updateWorkItem(){
		return null;
	}
	
	@DELETE
	public Response deleteWorkItem(){
		return null;
	}
	
	@PUT
	public Response asignWorkItemToUser(){
		return null;
	}
	
	@GET
	public Response getWorkItemsByStatus(){
		return null;
	}
	
	@GET
	public Response getWorkItemsByTeam(){
		return null;
	}
	
	@GET
	public Response getWorkItemsByUser(){
		return null;		
	}
	
	@GET
	public Response getWorkItemsByWord(){
		return null;		
	}
	
	@GET
	public Response getWorkItemsWithIssues(){
		return null;		
	}
	
}
