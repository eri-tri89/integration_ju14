package se.ju14.scrumboard.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Jesper Wendler
 * @author Pierre Vanderpol
 */

@Entity
public final class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String workItemId;
	private String description;
	
	@Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

	
	/*
	private enum issueStatus {
		ACTIVE, ONHOLD, WAITING, DONE, DELETED
	};
	*/
	
	public Issue() {
	}
	
	public Issue(String workItemId, String description,IssueStatus issueStatus) {
		super();
		this.workItemId = workItemId;
		this.description = description;
		this.issueStatus = issueStatus;
	}

	public String getWorkItemId() {
		return workItemId;
	}

	public Issue setWorkItemId(String workItemId) {
		return new Issue(workItemId,description,issueStatus);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IssueStatus getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", workItemId=" + workItemId + ", description=" + description + ", issueStatus="
				+ issueStatus + "]";
	}

	
	

}
