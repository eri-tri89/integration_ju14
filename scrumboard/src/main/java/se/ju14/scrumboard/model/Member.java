package se.ju14.scrumboard.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import se.ju14.scrumboard.model.status.MemberStatus;

/**
 * 
 * @author Jesper Wendler, Pierre Vanderpol, Erik Perez
 *
 */

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Member.findAll", query = "Select m from Member m"),
	@NamedQuery(name = "Member.findById", query = "Select m from Member m where m.memberId = :memberId"),
	@NamedQuery(name = "Member.findByFirstName", query = "Select m from Member m where m.firstName = :firstName"),
	@NamedQuery(name = "Member.findByLastName", query = "Select m from Member m where m.lastName = :lastName"),
	@NamedQuery(name = "Member.findByUserName", query = "Select m from Member m where m.userName = :userName")
	})
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String memberId;
	private String firstName;
	private String lastName;

	@Column(unique = true)
	private String userName;

	@Enumerated(EnumType.STRING)
	private MemberStatus memberStatus;

	@OneToMany
	@Column(nullable = true)	
	private Set<WorkItem> workItems;

	public Member() {
		super();
	}

	public Member(String firstName, String lastName, String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.memberStatus = MemberStatus.ACTIVE;
		this.workItems = new HashSet<WorkItem>();
	}

	public long getId() {
		return id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public MemberStatus getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(MemberStatus memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Set<WorkItem> getWorkItems() {
		return workItems;
	}

	public void setWorkItems(Set<WorkItem> workItems) {
		this.workItems = workItems;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", memberStatus=" + memberStatus + ", workItems=" + workItems + "]";
	}

}
