package se.ju14.scrumboard.model;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

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
import se.ju14.scrumboard.model.status.PriorityStatus;

/**
 * The entity class to WorkItem
 * @author Jesper Wendler
 * @author Pierre Vanderpol
 */

@Entity
@NamedQueries({
	@NamedQuery(name="WorkItem.findAll",query="Select w from WorkItem w"),
	@NamedQuery(name="WorkItem.findByStatus",query="Select w from WorkItem w where w.itemStatus = :itemStatus"),
	@NamedQuery(name="WorkItem.findById",query="Select w from WorkItem w where w.itemID = :itemID")
})
public class WorkItem extends JpaEntity{
	
	private String itemID;

	private String subject;
	private String description;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ItemStatus itemStatus;
	
	@Column
	@Enumerated(EnumType.STRING)
	private PriorityStatus priorityStatus;
	
	@JoinColumn(nullable=true)
	@OneToMany(orphanRemoval=true)
	private Set<Issue> issues;	
	
	public WorkItem() {
		super();
	}

	public WorkItem(String subject, String description) {
		this.itemID = UUID.randomUUID().toString() + new Random().nextInt(9);
		this.subject = subject;
		this.description = description;
		this.itemStatus = ItemStatus.ACTIVE;
		this.priorityStatus = PriorityStatus.NORMAL;
		this.issues = new HashSet<Issue>();
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
		String tmp = "";
		for(Issue i:issues){
			tmp += " "+i+" ";
		}
		return "WorkItem [id=" + super.getId() + ", itemID=" + itemID + ", subject=" + subject + ", description=" + description
				+ ", itemStatus=" + itemStatus + ", priorityStatus=" + priorityStatus + ", issues=" + tmp + "]";
	}

	

}
