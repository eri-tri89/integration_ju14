package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class User implements Serializable{
	//@ManyToOne
	//@JoinColumn(name = "userId")

	public User(){
		
	}
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;

	
	String userId;
	
	String firstName;
	
	String lastName;
	
	String userName;
	
	Enum userStatus;
	
	
	private Set<WorkItem> workItems = new HashSet<WorkItem>(0);

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Enum getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Enum userStatus) {
		this.userStatus = userStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<WorkItem> getWorkItems() {
		return workItems;
	}

	public void setWorkItems(Set<WorkItem> workItems) {
		this.workItems = workItems;
	}

	
	
	
	
}
