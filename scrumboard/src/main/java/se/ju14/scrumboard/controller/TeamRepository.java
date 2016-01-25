package se.ju14.scrumboard.controller;

import java.util.Collection;

import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.Member;

/**
 * Crud operations specific to Team.
 * @author Pierre Vanderpol
 *
 */

public interface TeamRepository extends CrudRepository<Team> {
	
	// Get all teams  
	Collection<Team> getAllTeams();

	// Lägg till en user till ett team
	Collection<Member> getAllTeamMembers(Team team);
	
	
	
}
