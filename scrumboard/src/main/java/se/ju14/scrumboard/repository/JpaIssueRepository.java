package se.ju14.scrumboard.repository;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.status.IssueStatus;
import se.ju14.scrumboard.repository.action.IssueRepository;

/**
 * This Class executes the transactions that has to do with the Issue entity
 * 
 * @author Pierre Vanderpol, Jesper Wendler, Erik Perez
 *
 */
public final class JpaIssueRepository extends InMemoryRepository<Issue> implements IssueRepository {

	public JpaIssueRepository() {
		super("Issue", Issue.class);
	}

	@Override
	public Issue update(Issue issue) {
		return super.saveOrUpdateEntity(issue.getId(), issue);
	}

	@Override
	public Issue delete(Issue issue) {
		Issue issueFound = super.getById(issue.getId());
		if (issueFound != null) {
			issueFound.setIssueStatus(IssueStatus.DELETED);
			return this.update(issueFound);
		}
		throw new RuntimeException("Issue not found");
	}

	@Override
	public Issue getByID(String issueID) {
		return (Issue)super.executeQuery(false,"findById", "issueID", issueID);
	}

}
