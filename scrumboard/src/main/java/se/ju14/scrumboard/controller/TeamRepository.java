package controller;

import java.util.Collection;

import model.Team;
import model.Users;

/**
 * Crud operations specific to Team.
 * @author Pierre Vanderpol
 *
 */

public interface TeamRepository extends CrudRepository<Team> {
	
	// Get all teams  
	Collection<Team> getAllTeams();

	// Lägg till en user till ett team
	Collection<Users> getAllTeamMembers(Team team);
	
	
	
}
