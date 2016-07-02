package se.ju14.scrumboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.ItemStatus;
import se.ju14.scrumboard.repository.JpaWorkItemRepository;

/**
 * This class manages the workitem functions and service
 * 
 * @author Erik Pérez
 **/
@Path("/workitem")
public class WorkItemService extends ScrumService<WorkItem, JpaWorkItemRepository> {

	@GET
	public Response getWorkItems(@DefaultValue("") @QueryParam("status") String status,
			@DefaultValue("") @QueryParam("filter") String filter) {
		List<WorkItem> result = itemRepository.getAll();
		ItemStatus itemStatus = ItemStatus.parse(status);
		if (itemStatus != null) {
			result = itemRepository.getByStatus(itemStatus);
			if (!filter.isEmpty()) {
				List<WorkItem> tmp = new ArrayList<WorkItem>();
				result.forEach(w -> {
					if (w.getDescription().contains(filter)) {
						tmp.add(w);
					}
				});
				result = tmp;
			}
		} else {
			result = itemRepository.getByWordFilter(filter);
		}

		return get(result);
	}

	@Path("{id}")
	@GET
	public Response getWorkItemById(@PathParam("id") String id) {
		return super.get(itemRepository.getByItemId(id));
	}

	@POST
	public Response createWorkItem(WorkItem workItem) {
		WorkItem savedWi = itemRepository.save(workItem);
		return super.post(savedWi.getItemID(), "workItem saved ");
	}

	@PUT
	public Response updateWorkItem(WorkItem workItem) {
		WorkItem foundWi = itemRepository.getByItemId(workItem.getItemID());
		return super.putOrDelete(true, (foundWi != null), itemRepository,
				i -> itemRepository.update(workItem).getItemID(), "WorkItem succesfully updated! ",
				"WorkItem not found");
	}

	@Path("{id}/{status}")
	@PUT
	public Response updateStatusOnWorkItem(@PathParam("id") String id, @PathParam("status") String status) {
		WorkItem workItemToUpdate = itemRepository.getByItemId(id);
		ItemStatus itemStatus = ItemStatus.parse(status);
		return super.putOrDelete(true, (workItemToUpdate != null && itemStatus != null), itemRepository,
				i -> i.changeStatus(workItemToUpdate, itemStatus).getItemID(), "WorkItem Status updated ",
				"WorkItem not found or itemStatus not valid");
	}

	@Path("{id}")
	@DELETE
	public Response deleteWorkItem(@PathParam("id") String id) {
		WorkItem foundWi = itemRepository.getByItemId(id);
		return super.putOrDelete(false, (foundWi != null), itemRepository,
				i -> itemRepository.delete(foundWi).getItemID(), "WorkItem deleted successfully ",
				"WorkItem not found");
	}

	@Path("{id}/issue/{issueId}")
	@PUT
	public Response addIssueToWorkItem(@PathParam("id") String id, @PathParam("issueId") String issueId) {
		WorkItem foundWi = itemRepository.getByItemId(id);
		Issue issueFound = issueRepository.getByID(issueId);
		return super.putOrDelete(true, (foundWi != null && issueFound != null), itemRepository,
				i -> i.addIssue(foundWi, issueFound).getItemID(), "Added Issue To WorkItem ", "WorkItem or Issue not found");

	}
	
	@Path("issue")
	@GET
	public Response getWorkItemsWithIssues(){
		return super.get(itemRepository.getWorkItemsWithIssues());
	}
}
