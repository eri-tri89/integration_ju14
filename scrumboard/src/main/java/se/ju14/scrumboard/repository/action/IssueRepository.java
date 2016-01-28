package se.ju14.scrumboard.repository.action;


import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.WorkItem;

/**
 * Crud operations specific to Issues.
 * @author Pierre Vanderpol
 *
 */
public interface IssueRepository{

	/**
	 * Adds an issue to a workItem
	 * @param workItem the workItem that will add the issue
	 * @param issue the issue to be added
	 * @return the workItem with the issue list filled with the issue in the param
	 * */
	WorkItem addIssueToWorkItem(WorkItem workItem,Issue issue);
	
	/**
	 * Updates an issue
	 * @param issue the issue to be added
	 * @return the issue updated
	 * */
	Issue update(Issue issue);
	
	/**
	 * Updates the Issue object to DELETED
	 * @param issue the issue to be DELETED
	 * @return the issue DELETED
	 * */
	Issue delete(Issue issue);
	
}
