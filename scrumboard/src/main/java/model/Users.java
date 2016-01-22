package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Jesper Wendler, Pierre Vanderpol
 *
 */

@Entity
public final class User implements Serializable {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String userName;
	private UserStatus userStatus;
	
	public User() {
	}
	
	public String getUserId() {
		return userId;
	}
	
//	////// REMOVE //////
//	public User setId(Long id) {
//		this.id = id;
//		return new User(id,firstName,lastName,userName);
//	}
//	
//	public Long getId() {
//		return this.id;
//	}
//	

	public User(String firstName, String lastName, String userName) {
	this.userId = "";
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.userStatus = UserStatus.ACTIVE;
}

	public User setUserId(String userId) {
		this.userId = userId;
		return new User(firstName,lastName,userName);
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


	public UserStatus getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", userStatus=" + userStatus + "]";
	}

	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//	public Set<WorkItem> getWorkItems() {
//		return workItems;
//	}
//
//	public void setWorkItems(Set<WorkItem> workItems) {
//		this.workItems = workItems;
//	}

}
