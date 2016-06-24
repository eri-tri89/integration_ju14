package se.ju14.scrumboard.service;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.ItemStatus;

/**
 * This class manages the workitem functions and service
 * 
 * @author Erik Pérez
 **/
@Path("/workitem")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class WorkItemService extends ScrumService {

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
	@Path("/assigntouser/{memberId}")
	public Response createWorkItem(@PathParam("memberId") String memberId, WorkItem workItem) {		
		WorkItem workItemToUpdate = null;//itemRepository.saveAndAssignToMember(memberRepository.getById(memberId), workItem);
		URI location = uriInfo.getAbsolutePathBuilder().path(workItemToUpdate.getItemID().toString()).build();
		return Response.created(location).entity(workItemToUpdate).build();
	}

	/**
	 * Update the info of a work item object
	 * 
	 * @param itemID
	 *            the id of the item to be modified
	 */
	@PUT
	public Response updateWorkItem(WorkItem workItem,@QueryParam("itemstatus")String itemStatus) {
		WorkItem workItemToUpdate = itemRepository.changeStatus(workItem,Enum.valueOf(ItemStatus.class, itemStatus));
		URI location = uriInfo.getAbsolutePathBuilder().path(workItemToUpdate.getItemID().toString()).build();
		return Response.created(location).entity(workItemToUpdate).build();
	}

	/**
	 * Changes the status of the item to DELETED
	 * 
	 * @param itemID
	 *            the id of the item to be modified
	 */
	@DELETE
	public Response deleteWorkItem(WorkItem workItem) {
		WorkItem workItemToDelete = itemRepository.delete(workItem);
		URI location = uriInfo.getAbsolutePathBuilder().path(workItemToDelete.getItemID().toString()).build();
		return Response.created(location).entity(workItemToDelete).build();
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
	public Response getWorkItemsByStatus(@QueryParam("itemstatus")String itemstatus) {
		List<WorkItem> workItemsByStatus = itemRepository.getByStatus(Enum.valueOf(ItemStatus.class, itemstatus));
		GenericEntity<Collection<WorkItem>> result = 
				new GenericEntity<Collection<WorkItem>>(workItemsByStatus){};	
		return Response.ok(result).build();
	}

	/**
	 * get items by team
	 * */
	@GET
	@Path("/byteam/{name}")
	public Response getWorkItemsByTeam(@PathParam("name")String name) {
		List<WorkItem> workItemsByTeam = itemRepository.getByTeam(teamRepository.getTeamByName(name));
		GenericEntity<Collection<WorkItem>> result = 
				new GenericEntity<Collection<WorkItem>>(workItemsByTeam){};	
		return Response.ok(result).build();
	}

	/**
	 * get items by user
	 * */
	@GET
	@Path("/byuser/{memberId}")
	public Response getWorkItemsByMember(@PathParam("memberId")String memberId) {
		List<WorkItem> workItemsByMember = itemRepository.getByMember(memberRepository.getByMemberId(memberId));
		GenericEntity<Collection<WorkItem>> result = 
				new GenericEntity<Collection<WorkItem>>(workItemsByMember){};	
		return Response.ok(result).build();
	}

	/**
	 * get items that has a common word in it
	 * */
	@GET
	@Path("/byword")
	public Response getWorkItemsByWord(@QueryParam("filter")String word) {
		List<WorkItem> workItemsByWord = itemRepository.getByWordFilter(word);
		GenericEntity<Collection<WorkItem>> result = 
				new GenericEntity<Collection<WorkItem>>(workItemsByWord){};	
		return Response.ok(result).build();
	}

	/**
	 * get items that has issues
	 * */
	@GET
	@Path("/withissues")
	public Response getWorkItemsWithIssues() {
		List<WorkItem> workItemsWithIssues = itemRepository.getWorkItemsWithIssues();
		GenericEntity<Collection<WorkItem>> result = 
				new GenericEntity<Collection<WorkItem>>(workItemsWithIssues){};	
		return Response.ok(result).build();
	}

	/**
	 * 
	 * */
	

}
