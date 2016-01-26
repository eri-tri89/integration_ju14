package se.ju14.scrumboard.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import se.ju14.scrumboard.model.status.TeamStatus;

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
	private Set<Member> member = new HashSet<Member>(0);
	private TeamStatus teamStatus;
	/*
	 * private enum teamStatus { ACTIVE, DELETED };
	 */

	public Team() {
	}

	public Team(String teamID, String name, TeamStatus teamStatus, Set<Member> member) {
		this.teamID = teamID;
		this.name = name;
		this.member = member;
		this.teamStatus = teamStatus;
	}

	public String getTeamID() {
		return teamID;
	}

	public Team setTeamID(String teamID) {
		return new Team(teamID, name, teamStatus, member);
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

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
	public Set<Member> getUsers() {
		return member;
	}

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
	public void setUsers(Set<Member> member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamID=" + teamID + ", name=" + name + ", users=" + member + ", teamStatus="
				+ teamStatus + "]";
	}

}
