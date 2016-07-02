package se.ju14.scrumboard.service;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.repository.JpaIssueRepository;

/**
 * This class manages the Issue functions and service
 * 
 * @author Erik Pérez
 */
@Path("/issue")
public class IssueService extends ScrumService<Issue, JpaIssueRepository> {

	@POST
	public Response createIssue(Issue issue) {
		Issue savedIssue = issueRepository.save(issue);
		return super.post(savedIssue.getIssueID(), "Issue Created ");
	}

	@PUT
	public Response updateIssue(Issue issue) {
		Issue issueFound = issueRepository.getByID(issue.getIssueID());
		return super.putOrDelete(true, (issueFound != null), issueRepository, is -> is.update(issue).getIssueID(),
				"Issue Updated ", "Issue not found");
	}

}
