package se.ju14.scrumboard.repository.action;



import java.util.List;

import se.ju14.scrumboard.model.Member;

public interface MemberRepository extends CrudRepository<Member> {

	Member getMemberById(String memberId);

	List<Member> getMemberByFirstName(String firstName);
	
	List<Member> getMemberByLastName(String LastName);

	Member getMemberByUserName(String UserName);
}
