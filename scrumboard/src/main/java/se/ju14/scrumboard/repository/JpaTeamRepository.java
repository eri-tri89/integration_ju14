package se.ju14.scrumboard.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.status.TeamStatus;
import se.ju14.scrumboard.repository.action.TeamRepository;

/**
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaTeamRepository implements TeamRepository {

	// JUST FOR TEST REMOVE IT LATER
	private final Map<String, Team> teams = new HashMap<>();

	/**
	 * Creates a new Team object in the database and gives it an ID
	 * 
	 * @parameter Team : a valid Issue parameter is needed
	 * @return returns a newly created Team object
	 */
	@Override
	public Team create(Team entity) {
		String id = UUID.randomUUID().toString();
		entity = entity.setTeamID(id);
		// CHANGE THIS LATER TO GET RESULT FROM DATABASE
		teams.put(id, entity);
		//
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
		teams.put(entity.getTeamID(), entity);
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
		if (teams.get(entity.getTeamID()) != null) {
			entity.setTeamStatus(TeamStatus.DELETED);
			teams.put(entity.getTeamID(),entity);
			return entity;
			}else{
		return null;
		}
	}

	/**
	 * Gets all the Teams from the database.
	 * @return returns a collection of Team objects
	 */
	@Override
	public Collection<Team> getAllTeams() {
		return teams.values();
	}

	//////////////////////// TO DO  ////////////////////////
	@Override
	public Collection<Member> getAllTeamMembers(Team team) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
