package se.ju14.scrumboard.model;

import java.util.Collection;

import se.ju14.scrumboard.controller.CrudRepository;
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
