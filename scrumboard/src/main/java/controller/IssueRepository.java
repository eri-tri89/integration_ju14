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

	// Get all Workitems with an issue 
	Collection<WorkItem> getAllaWorkItemWithIssue();

	// Adds a new Issue to a WorkItem and returns the updated WorkItem
	WorkItem addIssueToWorkItem(WorkItem WorkItem, Issue IssueID);
	
	
	
}
