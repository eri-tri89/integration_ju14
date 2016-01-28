package se.ju14.scrumboard.repository;

import java.util.List;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.status.TeamStatus;
import se.ju14.scrumboard.repository.action.TeamRepository;

/**
 * This Class executes the transactions that has to do with the Team entity
 * @author Pierre Vanderpol, Jesper Wendler, Erik Perez
 *
 */
public final class JpaTeamRepository extends InMemoryRepository<Team> implements TeamRepository {

	public JpaTeamRepository() {
		super();
	}

	@Override
	public Team save(Team entity) {
		super.saveOrUpdateEntity(manager -> {
			manager.persist(entity);
		});
		return entity;
	}

	@Override
	public Team update(Team entity) {
		super.saveOrUpdateEntity(manager -> {
			if (manager.find(Team.class, entity.getId()) != null)
				manager.merge(entity);
		});
		return entity;
	}

	@Override
	public Team delete(Team entity) {
		super.saveOrUpdateEntity(manager -> {
			if (manager.find(Team.class, entity.getId()) != null) {
				entity.setTeamStatus(TeamStatus.DELETED);
				manager.merge(entity);
			}
		});
		return entity;
	}

	@Override
	public List<Team> getAll() {
		return super.executeFindAll("Team", Team.class);
	}

	@Override
	public Team getTeamByName(String name) {
		return super.executeQuery("Team.findByName", Team.class, "name", name).get(0);
	}

	@Override
	public Team addMemberToTeam(Member member, Team team) {
		super.saveOrUpdateEntity(manager -> {
			if (manager.find(Team.class, team.getId()) != null) {
				if (manager.find(Member.class, member.getId()) != null) {
					team.getMembers().add(member);
					manager.merge(team);
				}
			}
		});
		return team;
	}

	// @Override
	// public Team create(Team entity) {
	// super.saveOrUpdateEntity(manager -> {
	// manager.persist(entity);
	// });
	// return entity;
	// }
	//
	// @Override
	// public Team update(Team entity) {
	// super.saveOrUpdateEntity(manager -> {
	// manager.merge(entity);
	// });
	// return null;
	// }
	//
	// @Override
	// public Team delete(Team entity) {
	// super.saveOrUpdateEntity(manager -> {
	// entity.setTeamStatus(TeamStatus.DELETED);
	// manager.merge(entity);
	// });
	// return entity;
	// }
	//
	// @Override
	// public List<Team> getAll() {
	// return super.executeFindAll("Team.findAll", Team.class);
	// }
	//
	// @Override
	// public Team getTeamByName(String name) {
	// return super.executeQuery("Team.findByName", Team.class, "name",
	// name).get(0);
	// }
	//
	// @Override
	// public List<Member> getAllTeamMembers(String name) {
	// List<Member> membersList = new ArrayList<Member>();
	// Team team = super.executeQuery("Team.findByName", Team.class, "name",
	// name).get(0);
	// membersList.addAll(team.getMembers());
	// return membersList;
	// }

}
