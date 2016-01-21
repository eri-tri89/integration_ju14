package se.ju14.scrumboard.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/issue")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IssueService {
	
	public Response createIssue(){
		return null;
	}
	
	public Response updateIssue(){
		return null;
	}
	
	public Response addIssueToWorkItem(){
		return null;
	}
	
}
