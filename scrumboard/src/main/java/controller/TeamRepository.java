package controller;

import java.util.Collection;

import model.Team;
import model.User;

/**
 * Crud operations specific to Team.
 * @author Pierre Vanderpol
 *
 */

public interface TeamRepository extends CrudRepository<Team> {
	
	// Get all teams  
	Collection<Team> getAllTeams();

	// Lägg till en user till ett team
	Collection<User> getAllTeamMembers(Team team);
	
	
	
}
