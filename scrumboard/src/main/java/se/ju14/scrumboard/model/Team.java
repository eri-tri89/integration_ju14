package se.ju14.scrumboard.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import se.ju14.scrumboard.model.status.TeamStatus;

/**
 * 
 * @author Jesper Wendler, Pierre Vanderpol
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Team.findById", query = "Select t from Team t where t.name = :name")
})
public final class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true)
	private String name;
	
	/*
	@Column(nullable = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "members")  /// WHAT IS THAT ?
	private Set<Member> members;
	*/
	
	@Enumerated(EnumType.STRING)
	private TeamStatus teamStatus;	

	public Team(String name, TeamStatus teamStatus) {		
		this.name = name;
		this.teamStatus = teamStatus;
		this.members = new HashSet<Member>(0);
	}
	
	// Must have an empty public constructor
	public Team() {
	}
	
	

	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
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
	
	

}
