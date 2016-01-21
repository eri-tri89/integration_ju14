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
 * @author Jesper Wendler, Pierre Vanderpol
 *
 */

@Entity
public final class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String teamID;
	private String name;
	private Set<User> users = new HashSet<User>(0);
	private TeamStatus teamStatus;
	/* 
	private enum teamStatus {
		ACTIVE, DELETED
	};
	*/
	
	public Team(){
	}

	public Team(String teamID, String name, TeamStatus teamStatus,Set<User> users) {
		this.teamID = teamID;
		this.name = name;
		this.users = users;
		this.teamStatus = teamStatus;
	}

	public String getTeamID() {
		return teamID;
	}

	public Team setTeamID(String teamID) {
		return new Team(teamID,name,teamStatus,users);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeamStatus getTeamStatus() {
		return teamStatus;
	}


	public void setTeamStatus(TeamStatus teamStatus) {
		this.teamStatus = teamStatus;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
	public Set<User> getUsers() {
		return users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamID=" + teamID + ", name=" + name + ", users=" + users + ", teamStatus="
				+ teamStatus + "]";
	}
	
	
	
	

}
