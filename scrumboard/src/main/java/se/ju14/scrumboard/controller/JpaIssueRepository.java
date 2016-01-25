package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import model.Issue;
import model.IssueStatus;
import model.WorkItem;

/**
 * Implements CRUD operations and database transactions for "Issues" objects.
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaIssueRepository implements IssueRepository {

	// JUST FOR TEST REMOVE IT LATER
	private final Map<String, Issue> issues = new HashMap<>();

	/**
	 * Creates a new Issue object in the database and gives it an ID 
	 * 
	 * @parameter Issue : a valid Issue parameter is needed
	 * @return returns a newly created Issue object
	 */
	@Override
	public Issue create(Issue entity) {
			String id = UUID.randomUUID().toString();
			entity = entity.setWorkItemId(id);
			// CHANGE THIS LATER TO GET RESULT FROM DATABASE
			issues.put(id, entity);
			//
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
			// CHANGE THIS LATER TO GET RESULT FROM DATABAS
			issues.put(entity.getWorkItemId(), entity);
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
			// CHANGE THIS LATER TO GET RESULT FROM DATABAS
			if (issues.get(entity.getWorkItemId()) != null) {
				entity.setIssueStatus(IssueStatus.DELETED);
				issues.put(entity.getWorkItemId(), entity);
				return entity;
			}else{
				return null;
			}
	}

	
	// TO DO
	@Override
	public Collection<WorkItem> getAllaWorkItemWithIssue() {
		return null;
	}

	
	// TO DO
	@Override
	public WorkItem addIssueToWorkItem(WorkItem WorkItem, Issue IssueID) {

		return null;
	}

	

}