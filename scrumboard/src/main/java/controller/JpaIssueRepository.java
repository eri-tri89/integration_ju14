package controller;

import java.util.Collection;

import model.Issue;
import model.WorkItem;

/**
 * Implements Crud operations and database transactions for Issues.
 * @author Pierre Vanderpol
 *
 */
public class JpaIssueRepository implements IssueRepository {

	@Override
	public Issue create(Issue entity) {
		Issue issue = new Issue(entity.getDescription(),entity.getWorkItemId());
		return issue;
	}

	@Override
	public Issue update(Issue entity) {
		
		return null;
	}

	@Override
	public Issue delete(Issue entity) {
		
		return null;
	}

	@Override
	public Collection<WorkItem> getAllaWorkItemWithIssue() {
		
		return null;
	}

	@Override
	public WorkItem addIssueToWorkItem(WorkItem WorkItem, Issue IssueID) {
		
		return null;
	}

	

	
}
