package se.ju14.scrumboard.repository.action;



import java.util.List;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;

public interface MemberRepository extends CrudRepository<Member> {

	
	Member addWorkItemToMember(Member member,WorkItem workItem);
	/**
	 * Gets a single Member entity by its memberId
	 * @param memberId the id of the element to get
	 * @return the Member with the parameter id
	 * */
	Member getByMemberId(String memberId);
	
	/**
	 * Gets a list of Members by its first name
	 * @param firstname the id of the element to get
	 * @return a list of the Member with the same first name
	 * */
	List<Member> getByFirstName(String firstName);
	
	/**
	 * Gets a list of Members by its last name
	 * @param lastName the id of the element to get
	 * @return a list of the Member with the same last name
	 * */
	List<Member> getByLastName(String lastName);

	/**
	 * Gets a single Member entity by its user name
	 * @param memberId the id of the element to get
	 * @return a list of the Member with the same user name
	 **/
	Member getByUserName(String userName);
	
	/**
	 * Gets a last of members of a certain team entity
	 * @param team the team the members have in common
	 * @return a list of the Member from the same team
	 * */
	List<Member> getTeamMembers(Team team);
}
