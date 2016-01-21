package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Jesper Wendler
 *
 */

@Entity
public class WorkItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ItemID;

	private enum itemStatus {
	};

	private String subject;
	private String description;

	private enum priority {
		URGENT, NORMAL, LOW
	};

	private Set<Issue> issues = new HashSet<Issue>(0);

	public String getItemID() {
		return ItemID;
	}

	public void setItemID(String itemID) {
		ItemID = itemID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workItem")
	public Set<Issue> getIssues() {
		return issues;
	}

	public void setIssues(Set<Issue> issues) {
		this.issues = issues;
	}

}
