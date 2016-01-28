package se.ju14.scrumboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import se.ju14.scrumboard.model.status.IssueStatus;

/**
 * The entity class to Issue
 * @author Jesper Wendler
 * @author Pierre Vanderpol
 */

@Entity
@NamedQueries(
		@NamedQuery(name="Issue.findById",query="Select i from Issue i where i.issueID = :issueID")
		)
public final class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String issueID;
	private String title;
	private String description;

	@Column
	@Enumerated(EnumType.STRING)
	private IssueStatus issueStatus;

	public Issue() {
		super();
	}

	public Issue(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.issueStatus = IssueStatus.ACTIVE;
	}

	public Long getId() {
		return id;
	}
	
	public String getIssueID() {
		return issueID;
	}

	public void setIssueID(String issueID) {
		this.issueID = issueID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "Issue [id=" + id + ", title=" + title + ", description=" + description + ", issueStatus=" + issueStatus
				+ "]";
	}
	
}
