package se.ju14.scrumboard.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import se.ju14.scrumboard.model.status.ItemStatus;

/**
 * 
 * @author Jesper Wendler
 * @author Pierre Vanderpol
 */

@Entity
@NamedQueries({
	@NamedQuery(name="WorkItem.findAll",query="Select w from WorkItem w"),
	@NamedQuery(name="WorkItem.findByStatus",query="Select w from WorkItem w where w.itemStatus = :itemStatus"),
	@NamedQuery(name="WorkItem.findById",query="Select w from WorkItem w where w.itemID = :itemID")
})
public class WorkItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String itemID;

	private String subject;
	private String description;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ItemStatus itemStatus;
	
	@JoinColumn(nullable=true)
	@OneToMany
	private Set<Issue> issues;	
	
	public WorkItem() {
		super();
	}

	public WorkItem(String subject, String description) {
		this.subject = subject;
		this.description = description;
		this.itemStatus = ItemStatus.ACTIVE;
		this.issues = new HashSet<Issue>(0);
	}

	public Long getId() {
		return id;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
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

	public ItemStatus getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Set<Issue> getIssues() {
		return issues;
	}

	public void setIssues(Set<Issue> issues) {
		this.issues = issues;
	}

	@Override
	public String toString() {
		return "WorkItem [id=" + id + ", itemID=" + itemID + ", subject=" + subject + ", description=" + description
				+ ", itemStatus=" + itemStatus + ", issues=" + issues + "]";
	}

}
