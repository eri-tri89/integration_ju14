package model;

import java.util.Collection;

import controller.CrudRepository;
/**
 * 
 * @author Pierre Vanderpol
 *
 */
public interface WorkItemRepository extends CrudRepository<WorkItem> {

	WorkItem asignWorkItemToUser(Users user, String WorkItemId);
	
	Collection<WorkItem> getWorkItemsByStatus(IssueStatus issueStatus);

	Collection<WorkItem> getWorkItemsByTeam(Team team);
	
	Collection<WorkItem> getWorkItemsByUser(Users user);
	
	Collection<WorkItem> getWorkItemsByWord(String word);
	
	Collection<WorkItem> getWorkItemsWithIssues();

	WorkItem addIssueToWorkItem(WorkItem workItem,Issue issue);
	
}
