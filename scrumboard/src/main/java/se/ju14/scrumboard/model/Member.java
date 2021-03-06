package se.ju14.scrumboard.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import se.ju14.scrumboard.model.status.MemberStatus;

/**
 * The entity class to Member
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
public class Member extends JpaEntity{

	private String memberId;
	private String firstName;
	private String lastName;

	@Column(unique = true)
	private String userName;

	@Column
	@Enumerated(EnumType.STRING)
	private MemberStatus memberStatus;

	@OneToMany(orphanRemoval=true)
	@JoinColumn(nullable = true)	
	private Set<WorkItem> workItems;

	public Member() {
		super();
	}

	public Member(String firstName, String lastName, String userName) {
		this.memberId = UUID.randomUUID().toString() + new Random().nextInt(9);
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.memberStatus = MemberStatus.ACTIVE;
		this.workItems = new HashSet<WorkItem>();
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
		String tmp = "";
		for(WorkItem w:workItems){
			tmp+=" "+w+" ";
		}
		return "Member [id=" + super.getId() + ", memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", memberStatus=" + memberStatus + ", workItems=" + tmp + "]";
	}

}
