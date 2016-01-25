package se.ju14.scrumboard.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.ju14.scrumboard.model.Issue;

/**
 * This class manages the Issue functions and service
 * @author Erik Pérez
 * */
@Path("/issue")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IssueService {
	
	/**
	 * Creates an Issue and adds to the object that has the following workItemID
	 * @param issue the Issue Object to be added to the work item object
	 * @param workItemID the id to the work item to be modified
	 * @return a 200 response if everything works as it must, 404 otherwise
	 */
	public Response createIssue(Issue issue, @PathParam("id") String workItemID){
		return null;
	}
	
	/**
	 * Updates an Issue from work item object
	 * @param workItemID the id of the workItem that has the issue to be updated
	 * @return The updated issue
	 **/
	public Issue updateIssue(@PathParam("id") String workItemID){
		return null;
	}
	
	
}
