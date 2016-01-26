package se.ju14.scrumboard.repository.action;

import java.util.List;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.IssueStatus;
/**
 * 
 * @author Pierre Vanderpol
 *
 */
public interface WorkItemRepository extends CrudRepository<WorkItem> {

	WorkItem asignWorkItemToUser(Member user, String WorkItemId);
	
	List<WorkItem> getWorkItemsByStatus(IssueStatus issueStatus);

	List<WorkItem> getWorkItemsByTeam(Team team);
	
	List<WorkItem> getWorkItemsByUser(Member user);
	
	List<WorkItem> getWorkItemsByWord(String word);
	
	List<WorkItem> getWorkItemsWithIssues();

	WorkItem addIssueToWorkItem(WorkItem workItem,Issue issue);
	
}
