package controller;

import java.util.Collection;

import model.Issue;
import model.WorkItem;

/**
 * Crud operations specific to Issues.
 * @author Pierre Vanderpol
 *
 */

public interface IssueRepository extends CrudRepository<Issue> {

	// Lägga till en Issue till en work item 
	Issue assignIssueToWorkItem(String WorkItemId, String IssueID);
	
	// Get all workitems with an issue 
	Collection<WorkItem> getAllaWorkItemWithIssue();
	
}
