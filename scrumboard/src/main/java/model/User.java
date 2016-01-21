package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * 
 * @author Jesper Wendler
 *
 */

@Entity
public class User implements Serializable {

	public User() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String userId;

	private String firstName;

	private String lastName;

	private String userName;

	private enum userStatus {
		ACTIVE, DELETED
	};

	private Set<WorkItem> workItems = new HashSet<WorkItem>(0);
	private Set<Team> teams = new HashSet<Team>(0);

	public Set<Team> getTeams() {
		return teams;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<WorkItem> getWorkItems() {
		return workItems;
	}

	public void setWorkItems(Set<WorkItem> workItems) {
		this.workItems = workItems;
	}

}
