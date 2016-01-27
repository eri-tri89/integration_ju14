package se.ju14.scrumboard.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import se.ju14.scrumboard.model.status.IssueStatus;

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
	private String title;
	private String description;
	
	@Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

	public Issue(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.issueStatus = IssueStatus.ACTIVE;
	}

	// Must have an empty public constructor
	public Issue() {
	}

	public Long getId() {
		return id;
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
	
	
	
}
