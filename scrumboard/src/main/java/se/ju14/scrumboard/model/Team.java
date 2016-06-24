package se.ju14.scrumboard.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import se.ju14.scrumboard.model.status.TeamStatus;

/**
 * The entity class to Team
 * 
 * @author Jesper Wendler, Pierre Vanderpol
 *
 */

@Entity
@NamedQueries({ @NamedQuery(name = "Team.findAll", query = "Select t from Team t"),
		@NamedQuery(name = "Team.findByName", query = "Select t from Team t where t.name = :name")})
public final class Team extends JpaEntity {

	@Column(unique = true)
	private String name;

	@OneToMany
	@JoinColumn(name = "Team_Members", nullable = true)
	private Set<Member> members;

	@Column
	@Enumerated(EnumType.STRING)
	private TeamStatus teamStatus;

	public Team() {
		super();
	}

	public Team(String name) {
		this.name = name;
		this.teamStatus = TeamStatus.ACTIVE;
		this.members = new HashSet<Member>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

	public TeamStatus getTeamStatus() {
		return teamStatus;
	}

	public void setTeamStatus(TeamStatus teamStatus) {
		this.teamStatus = teamStatus;
	}

	@Override
	public String toString() {
		String tmp = "";
		for (Member m : members) {
			tmp += " " + m + " ";
		}
		return "Team [id=" + super.getId() + ", name=" + name + ", members=" + tmp + ", teamStatus=" + teamStatus + "]";
	}

}
