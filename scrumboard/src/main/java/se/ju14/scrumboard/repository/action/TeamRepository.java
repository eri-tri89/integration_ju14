package se.ju14.scrumboard.repository.action;


import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;

/**
 * Crud operations specific to Team.
 * @author Pierre Vanderpol
 *
 */

public interface TeamRepository extends CrudRepository<Team> {
	
	/**
	 * Gets a team by its name
	 * @param name the name of the team to be brought
	 * @return the team with the parameter's name
	 * */
	Team getTeamByName(String name);
	
	/**
	 * Adds a member to a certain team
	 * @param member the member to be added to the team
	 * @param team the team that the member will be part of
	 * @return the updated team
	 * */
	Team addMemberToTeam(Member member,Team team);
	
	
	
}
