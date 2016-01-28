package se.ju14.scrumboard.service;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.WorkItem;

/**
 * This class manages the Issue functions and service
 * @author Erik Pérez
 * */
@Path("/issue")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class IssueService extends ScrumService {
	
	/**
	 * Creates an Issue and adds to the object that has the following workItemID
	 * @param issue the Issue Object to be added to the work item object
	 * @param workItemID the id to the work item to be modified
	 * @return a 200 response if everything works as it must, 404 otherwise
	 */
	@POST
	@Path("/addIssue/{itemID}")
	public Response addIssueToWorkItem(@PathParam("itemID")String itemID,Issue issue) {
		WorkItem workItemToUpdate = issueRepository.addIssueToWorkItem(itemRepository.getById(itemID), issue);
		URI location = uriInfo.getAbsolutePathBuilder().path(workItemToUpdate.getItemID().toString()).build();
		return Response.created(location).entity(workItemToUpdate).build();
	}
	
	/**
	 * Updates an Issue from work item object
	 * @param workItemID the id of the workItem that has the issue to be updated
	 * @return The updated issue
	 **/
	@PUT
	@Path("{issueID}")
	public Response updateIssue(@PathParam("issueID")String issueID){
		Issue issueToUpdate = issueRepository.update(issueRepository.getByID(issueID));
		URI location = uriInfo.getAbsolutePathBuilder().path(issueToUpdate.getIssueID().toString()).build();
		return Response.created(location).entity(issueToUpdate).build();
	}
	
	
}
