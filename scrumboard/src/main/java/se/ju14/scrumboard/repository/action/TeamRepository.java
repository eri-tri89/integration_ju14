package se.ju14.scrumboard.repository.action;

import java.util.List;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;

/**
 * Crud operations specific to Team.
 * @author Pierre Vanderpol
 *
 */

public interface TeamRepository extends CrudRepository<Team> {
	
	// Get all teams  
	List<Team> getAllTeams();

	// Lägg till en user till ett team
	List<Member> getAllTeamMembers(Team team);
	
	
	
}
