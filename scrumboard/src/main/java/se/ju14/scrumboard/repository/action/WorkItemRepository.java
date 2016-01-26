package se.ju14.scrumboard.repository.action;

import java.util.Collection;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.IssueStatus;
import se.ju14.scrumboard.repository.CrudRepository;
/**
 * 
 * @author Pierre Vanderpol
 *
 */
public interface WorkItemRepository extends CrudRepository<WorkItem> {

	WorkItem asignWorkItemToUser(Member user, String WorkItemId);
	
	Collection<WorkItem> getWorkItemsByStatus(IssueStatus issueStatus);

	Collection<WorkItem> getWorkItemsByTeam(Team team);
	
	Collection<WorkItem> getWorkItemsByUser(Member user);
	
	Collection<WorkItem> getWorkItemsByWord(String word);
	
	Collection<WorkItem> getWorkItemsWithIssues();

	WorkItem addIssueToWorkItem(WorkItem workItem,Issue issue);
	
}
