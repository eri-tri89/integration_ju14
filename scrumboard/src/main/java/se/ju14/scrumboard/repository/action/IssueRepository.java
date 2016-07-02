package se.ju14.scrumboard.repository.action;


import se.ju14.scrumboard.model.Issue;

/**
 * Crud operations specific to Issues.
 * @author Pierre Vanderpol
 *
 */
public interface IssueRepository extends CrudRepository<Issue>{

	
	/**
	 * Gets an Issue by Id
	 * @param issueID the id of the issue to be brought
	 * @return the issue with the id
	 * */
	Issue getByID(String issueID);
	
}
