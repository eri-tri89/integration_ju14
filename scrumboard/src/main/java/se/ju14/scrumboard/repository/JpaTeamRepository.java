package se.ju14.scrumboard.repository;

import java.util.Collection;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.repository.action.TeamRepository;

/**
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaTeamRepository  extends InMemoryRepository implements TeamRepository {


	/**
	 * Creates a new Team object in the database and gives it an ID
	 * 
	 * @parameter Team : a valid Issue parameter is needed
	 * @return returns a newly created Team object
	 */
	@Override
	public Team create(Team entity) {
		
		return entity;
	}

	/**
	 * Updates an existing Team object in the database
	 * 
	 * @parameter Team : a valid Team parameter is needed
	 * @return returns the updated Team object
	 */
	@Override
	public Team update(Team entity) {
		
		return entity;
	}

	/**
	 * Deletes an existing Team object in the database. Objects are never
	 * deleted but their status is changed.
	 * 
	 * @parameter Team : a valid Team parameter is needed
	 * @return returns the updated Team object
	 */
	@Override
	public Team delete(Team entity) {
		
		return entity;
	}

	/**
	 * Gets all the Teams from the database.
	 * @return returns a collection of Team objects
	 */
	@Override
	public Collection<Team> getAllTeams() {
		return null;
	}

	
	@Override
	public Collection<Member> getAllTeamMembers(Team team) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
