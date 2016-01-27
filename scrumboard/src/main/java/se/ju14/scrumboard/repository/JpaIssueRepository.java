package se.ju14.scrumboard.repository;

import java.util.List;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.repository.action.IssueRepository;

/**
 * Implements CRUD operations and database transactions for "Issues" objects.
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaIssueRepository extends InMemoryRepository<Issue> implements IssueRepository {

	
	/**
	 * Creates a new Issue object in the database and gives it an ID
	 * 
	 * @parameter Issue : a valid Issue parameter is needed
	 * @return returns a newly created Issue object
	 */
	@Override
	public Issue create(Issue entity) {
		return entity;
	}

	/**
	 * Updates an existingIssue object in the database
	 * 
	 * @parameter Issue : a valid Issue parameter is needed
	 * @return returns the updated Issue object
	 */
	@Override
	public Issue update(Issue entity) {
		return entity;
	}

	/**
	 * Deletes an existingIssue object in the database. Objects are never
	 * deleted but their status is changed.
	 * 
	 * @parameter Issue : a valid Issue parameter is needed
	 * @return returns the updated Issue object
	 */
	@Override
	public Issue delete(Issue entity) {
		return null;
	}

	@Override
	public List<Issue> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkItem> getAllaWorkItemWithIssue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkItem addIssueToWorkItem(WorkItem WorkItem, Issue IssueID) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
