package se.ju14.scrumboard.repository;

import java.util.List;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.repository.action.TeamRepository;

/**
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaTeamRepository  extends InMemoryRepository<Team> implements TeamRepository {

	@Override
	public Team create(Team entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team update(Team entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team delete(Team entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getAllTeamMembers(Team team) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
