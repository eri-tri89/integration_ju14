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
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String teamID;
	private String name;

	private enum teamStatus {
		ACTIVE, DELETED
	};

	private Set<User> users = new HashSet<User>(0);

	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
	public Set<User> getUsers() {
		return users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
