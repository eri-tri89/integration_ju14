package se.ju14.scrumboard.repository.action;

import java.util.List;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.ItemStatus;
/**
 * 
 * @author Pierre Vanderpol
 *
 */
public interface WorkItemRepository{

	/**
	 * Saves and Assigns a workitem to a member
	 * @param member the member that will obtain the workItem
	 * @param workItem the workItem to be added in the member's workItem's list
	 * @return The saved workItem
	 * */
	WorkItem saveAndAssignToMember(Member member, WorkItem workItem);
	
	/**
	 * Updates the status of a workitem
	 * @param workItem the workItem to be updated
	 * @param itemStatus the new ItemStatus
	 * @return The saved workItem
	 * */
	WorkItem changeStatus(WorkItem workItem,ItemStatus itemStatus);
	
	/**
	 * Updates the status of a workitem
	 * @param workItem the workItem to be updated
	 * @param itemStatus the new ItemStatus
	 * @return The saved workItem
	 * */
	WorkItem delete(WorkItem workItem);

	/**
	 * Gets a list of workItems from a team
	 * @param team the team that has the workItems
	 * @return a list of workItem within the team
	 * */
	List<WorkItem> getByTeam(Team team);
	
	/**
	 * Gets a work item object by id
	 * @param itemId the id that belongs to the workItem
	 * @return a work Item object
	 * */
	WorkItem getById(String itemId);
	
	/**
	 * Gets a list of workItems by its status
	 * @param itemStatus the status in common within the workItem List
	 * @return a list of workItems with the same status
	 * */
	List<WorkItem> getByStatus(ItemStatus itemStatus);
	
	/**
	 * Gets a list of workItems by member
	 * @param member the member that has the workItems
	 * @return a list of the member's workItems 
	 * */
	List<WorkItem> getByMember(Member member);
	
	/**
	 * Gets a list of workItems that contains a word in its subject or in its description
	 * @param word the word to be searched in the workItems subjects or in its description
	 * @return a list of workItems that contains that word in common in its subject or in its description 
	 * */
	List<WorkItem> getByWordFilter(String word);
	
	/**
	 * Gets all the workItems that has issues in them
	 * @return a list of workItems with Issues
	 * */
	List<WorkItem> getWorkItemsWithIssues();
	
	
}
