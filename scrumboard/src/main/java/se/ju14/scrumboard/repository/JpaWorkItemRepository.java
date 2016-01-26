package se.ju14.scrumboard.repository;

import java.util.List;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.IssueStatus;
import se.ju14.scrumboard.repository.action.WorkItemRepository;

/**
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaWorkItemRepository  extends InMemoryRepository<WorkItem> implements WorkItemRepository {

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
	public List<WorkItem> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkItem asignWorkItemToUser(Member user, String WorkItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkItem> getWorkItemsByStatus(IssueStatus issueStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkItem> getWorkItemsByTeam(Team team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkItem> getWorkItemsByUser(Member user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkItem> getWorkItemsByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkItem> getWorkItemsWithIssues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkItem addIssueToWorkItem(WorkItem workItem, Issue issue) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
