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
	public Issue saveOrUpdate(Issue entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Issue remove(Issue entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Issue assignIssueToWorkItem(String WorkItemId, String IssueID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkItem> getAllaWorkItemWithIssue() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
