package se.ju14.scrumboard.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import se.ju14.scrumboard.model.status.MemberStatus;

/**
 * 
 * @author Jesper Wendler, Pierre Vanderpol, Erik Perez
 *
 */

@Entity
public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String memberId;
	private String firstName;
	private String lastName;
	private String userName;
	@Enumerated(EnumType.STRING)
	private MemberStatus memberStatus;
	//private Set<WorkItem> workItems;

	public Member() {
	}

	public String getMemberId() {
		return memberId;
	}

	public Member(String firstName, String lastName, String userName) {
		this.memberId = "";
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.memberStatus = MemberStatus.ACTIVE;
	}

	public Member(String memberId2, String firstName2, String lastName2, String userName2, MemberStatus memberStatus2) {
		this.memberId = memberId2;
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.userName = userName2;
		this.memberStatus = memberStatus2;
	}

	public Member setMemberId(String userId) {
		this.memberId = userId;
		return new Member(firstName, lastName, userName);
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

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public MemberStatus getUserStatus() {
		return memberStatus;
	}

	public void setMemberStatus(MemberStatus memberStatus) {
		this.memberStatus = memberStatus;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", userStatus=" + memberStatus + "]";
	}

	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<WorkItem> getWorkItems() {
		return getWorkItems();
	}


	public void setWorkItems(Set<WorkItem> workItems) {
		this.workItems = workItems;
	}
*/

	
	public long getId() {
		return id;
	}

}
