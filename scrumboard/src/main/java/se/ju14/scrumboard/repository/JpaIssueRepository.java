package se.ju14.scrumboard.repository;

import java.util.UUID;
import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.IssueStatus;
import se.ju14.scrumboard.repository.action.IssueRepository;

/**
 * This Class executes the transactions that has to do with the Issue entity
 * @author Pierre Vanderpol, Jesper Wendler, Erik Perez
 *
 */
public final class JpaIssueRepository extends InMemoryRepository<Issue> implements IssueRepository {

	public JpaIssueRepository() {
		super();
	}

	@Override
	public WorkItem addIssueToWorkItem(WorkItem workItem, Issue issue) {
		super.saveOrUpdateEntity(manager -> {
			if (manager.find(WorkItem.class, workItem.getId()) != null) {
				String AUTOGENERATED_ID = UUID.randomUUID().toString();
				issue.setIssueID(AUTOGENERATED_ID);
				workItem.getIssues().add(issue);
				manager.persist(issue);
				manager.merge(workItem);
			}
		});
		return workItem;
	}

	@Override
	public Issue update(Issue issue) {
		super.saveOrUpdateEntity(manager -> {
			if (manager.find(Issue.class, issue.getId()) != null) {
				manager.merge(issue);
			}
		});
		return issue;
	}

	@Override
	public Issue delete(Issue issue) {
		super.saveOrUpdateEntity(manager -> {
			if (manager.find(Issue.class, issue.getId()) != null) {
				issue.setIssueStatus(IssueStatus.DELETED);
				manager.merge(issue);
			}
		});
		return issue;
	}

	@Override
	public Issue getByID(String issueID) {
		return super.executeQuery("Issue.findById", Issue.class, "issueID", issueID).get(0);
	}

}
