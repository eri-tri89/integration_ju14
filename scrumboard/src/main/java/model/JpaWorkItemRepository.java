package model;

import java.util.Collection;

/**
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaWorkItemRepository implements WorkItemRepository {

	
	/**
	 * TO DO
	 * 
	 * */
	
	@Override
	public WorkItem create(WorkItem entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkItem update(WorkItem entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkItem delete(WorkItem entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkItem asignWorkItemToUser(Users user, String WorkItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkItem> getWorkItemsByStatus(IssueStatus issueStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkItem> getWorkItemsByTeam(Team team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkItem> getWorkItemsByUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkItem> getWorkItemsByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkItem> getWorkItemsWithIssues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkItem addIssueToWorkItem(WorkItem workItem, Issue issue) {
		// TODO Auto-generated method stub
		return null;
	}

}
