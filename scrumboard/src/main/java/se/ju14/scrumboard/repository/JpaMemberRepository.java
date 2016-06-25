package se.ju14.scrumboard.repository;

import java.util.ArrayList;
import java.util.List;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.MemberStatus;
import se.ju14.scrumboard.repository.action.MemberRepository;

/**
 * This Class executes the transactions that has to do with the Member entity
 * @author Pierre Vanderpol, Jesper Wendler, Erik Perez
 *
 */
public final class JpaMemberRepository extends InMemoryRepository<Member> implements MemberRepository {

	public JpaMemberRepository() {
		super("Member",Member.class);
	}

	@Override
	public Member save(Member entity) {
		return super.saveOrUpdateEntity(null, entity);
	}

	@Override
	public Member update(Member entity) {
		return super.saveOrUpdateEntity(entity.getId(), entity);
	}

	@Override
	public Member delete(Member entity) {
		Member memberFound = super.getById(entity.getId());
		if(memberFound != null){
			memberFound.setMemberStatus(MemberStatus.DELETED);
			return this.update(memberFound);
		}
		throw new RuntimeException("Member to Delete not found");
	}

	@Override
	public List<Member> getAll() {
		return super.executeFindAll();
	}

	@Override
	public Member getByMemberId(String memberId) {
		return (Member)super.executeQuery(false,"findById", "memberId", memberId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Member> getByFirstName(String firstName) {
		return (List<Member>)super.executeQuery(true,"findByFirstName", "firstName", firstName);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Member> getByLastName(String lastName) {
		return (List<Member>)super.executeQuery(true,"findByLastName","lastName", lastName);
	}

	@Override
	public Member getByUserName(String userName) {
		return (Member)super.executeQuery(false,"findByUserName", "userName", userName);
	}

	@Override
	public List<Member> getTeamMembers(Team team) {
		return new ArrayList<Member>(team.getMembers());
	}

	@Override
	public Member addWorkItemToMember(Member member, WorkItem workItem) {
		Member memberFound = super.getById(member.getId());
		if(memberFound != null){
			memberFound.getWorkItems().add(workItem);
			return this.update(memberFound);
		}
		throw new RuntimeException("Member not found");
	}

}
