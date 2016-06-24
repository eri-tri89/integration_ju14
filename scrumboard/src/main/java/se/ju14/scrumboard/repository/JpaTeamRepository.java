package se.ju14.scrumboard.repository;

import java.util.List;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.status.TeamStatus;
import se.ju14.scrumboard.repository.action.TeamRepository;

/**
 * This Class executes the transactions that has to do with the Team entity
 * 
 * @author Pierre Vanderpol, Jesper Wendler, Erik Perez
 *
 */
public final class JpaTeamRepository extends InMemoryRepository<Team> implements TeamRepository {

	public JpaTeamRepository() {
		super("Team", Team.class);
	}

	@Override
	public Team save(Team entity) {
		return super.saveOrUpdateEntity(null, entity);
	}

	@Override
	public Team update(Team entity) {
		return super.saveOrUpdateEntity(entity.getId(), entity);
	}

	@Override
	public Team delete(Team entity) {
		Team teamFound = super.getById(entity.getId());
		if(teamFound != null){
			teamFound.setTeamStatus(TeamStatus.DELETED);
			return this.update(teamFound);
		}
		throw new RuntimeException("Team to delete not found");
	}

	@Override
	public List<Team> getAll() {
		return super.executeFindAll();
	}

	@Override
	public Team getTeamByName(String name) {
		List<Team> tmp = super.executeQuery("findByName","name", name);
		return tmp.isEmpty() ? tmp.get(0) : null;
	}

	@Override
	public Team addMemberToTeam(Member member, Team team) {
		Team teamFound = super.getById(team.getId());
		if(teamFound != null){
			teamFound.getMembers().add(member);
			return this.update(teamFound);
		}
		throw new RuntimeException("Team not found");
	}

}
