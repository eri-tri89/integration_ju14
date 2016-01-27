package se.ju14.scrumboard.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.ju14.scrumboard.model.WorkItem;

/**
 * This class manages the workitem functions and service
 * 
 * @author Erik Pérez
 **/
@Path("/workitem")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorkItemService {

	/**
	 * Creates a workItem adds it to an user
	 * 
	 * @param userID
	 *            the id of the user that will have the workItem object
	 * @param workItem
	 *            the work Item object to be created and eventually to be
	 *            assigned to the user
	 * @return a 200 response it creates and assigns properly, 404 otherwise
	 **/
	@POST
	@Path("/assigntouser/{userID}")
	public Response createWorkItem(@PathParam("userID") String userID, WorkItem workItem) {
		return null;
	}

	/**
	 * Update the info of a work item object
	 * 
	 * @param itemID
	 *            the id of the item to be modified
	 */
	@PUT
	@Path("{itemID}")
	public Response updateWorkItem(@PathParam("itemID") String itemID) {
		return null;
	}

	/**
	 * Changes the status of the item to DELETED
	 * 
	 * @param itemID
	 *            the id of the item to be modified
	 */
	@DELETE
	@Path("{itemID}")
	public Response deleteWorkItem() {
		return null;
	}

//	/**
//	 * 
//	 **/
//	@PUT
//	public Response assignWorkItemToUser() {
//		return null;//don't know if this method will be useful, discuss it!
//	}

	/**
	 * get item by status
	 * */
	@GET
	public Response getWorkItemsByStatus(@QueryParam("status")String status) {
		return null;
	}

	/**
	 * get items by team
	 * */
	@GET
	@Path("/byteam")
	public Response getWorkItemsByTeam() {
		return null;
	}

	/**
	 * get items by user
	 * */
	@GET
	@Path("/byuser")
	public Response getWorkItemsByUser() {
		return null;
	}

	/**
	 * get items that has a common word in it
	 * */
	@GET
	@Path("/byword")
	public Response getWorkItemsByWord(@QueryParam("filter")String word) {
		return null;
	}

	/**
	 * get items that has issues
	 * */
	@GET
	@Path("/withissues")
	public Response getWorkItemsWithIssues(@QueryParam("issues")boolean hasIssues) {
		return null;
	}

	/**
	 * 
	 * */
	@PUT
	@Path("/addIssue/{itemID}")
	public Response addIssueToWorkItem(@PathParam("itemID")String itemID) {
		return null;
	}

}
