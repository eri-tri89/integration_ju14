package se.ju14.scrumboard.repository.action;


import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.WorkItem;

/**
 * Crud operations specific to Issues.
 * @author Pierre Vanderpol
 *
 */
public interface IssueRepository{

	
	/**
	 * Updates an issue
	 * @param issue the issue to be added
	 * @return the issue updated
	 * */
	Issue update(Issue issue);
	
	/**
	 * Updates the Issue object to DELETED
	 * @param issue the issue to be DELETED
	 * @return the issue DELETED
	 * */
	Issue delete(Issue issue);
	
	/**
	 * Gets an Issue by Id
	 * @param issueID the id of the issue to be brought
	 * @return the issue with the id
	 * */
	Issue getByID(String issueID);
	
}
