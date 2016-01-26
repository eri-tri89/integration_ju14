package se.ju14.scrumboard.repository.action;

import java.util.List;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.WorkItem;

/**
 * Crud operations specific to Issues.
 * @author Pierre Vanderpol
 *
 */

public interface IssueRepository extends CrudRepository<Issue> {

	// Get all Workitems with an issue 
	List<WorkItem> getAllaWorkItemWithIssue();

	// Adds a new Issue to a WorkItem and returns the updated WorkItem
	WorkItem addIssueToWorkItem(WorkItem WorkItem, Issue IssueID);
	
	
	
}
