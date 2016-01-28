package se.ju14.scrumboard.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import se.ju14.scrumboard.model.status.TeamStatus;

/**
 * The entity class to Team
 * @author Jesper Wendler, Pierre Vanderpol
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Team.findAll", query = "Select t from Team t"),
	@NamedQuery(name = "Team.findByName", query = "Select t from Team t where t.name = :name")
})
public final class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true)
	private String name;
	
	@JoinColumn(nullable = true)
	@OneToMany
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
		this.members = new HashSet<Member>(0);
	}

	public Long getId() {
		return id;
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
		return "Team [id=" + id + ", name=" + name + ", members=" + members + ", teamStatus=" + teamStatus + "]";
	}
	
	

}
