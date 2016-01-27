package se.ju14.scrumboard.repository;

import java.util.ArrayList;
import java.util.List;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.status.TeamStatus;
import se.ju14.scrumboard.repository.action.TeamRepository;

/**
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaTeamRepository extends InMemoryRepository<Team> implements TeamRepository {

	@Override
	public Team create(Team entity) {
		super.saveOrUpdateEntity(manager -> {
			manager.persist(entity);
		});
		return entity;
	}

	@Override
	public Team update(Team entity) {
		super.saveOrUpdateEntity(manager -> {
			manager.merge(entity);
		});
		return null;
	}

	@Override
	public Team delete(Team entity) {
		super.saveOrUpdateEntity(manager -> {
			entity.setTeamStatus(TeamStatus.DELETED);
			manager.merge(entity);
		});
		return entity;
	}

	@Override
	public List<Team> getAll() {
		return super.executeQuery("Team.findAll", Team.class);
	}

	@Override
	public List<Team> getTeamByName(String name) {
		return super.executeQuery("Team.findByName", Team.class, "name", name);
	}

	@Override
	public List<Member> getAllTeamMembers(String name) {
		List<Member> membersList = new ArrayList<Member>();
		Team team = super.executeQuery("Team.findByName", Team.class, "name", name).get(0);
		membersList.addAll(team.getMembers());
		return membersList;
	}

}
