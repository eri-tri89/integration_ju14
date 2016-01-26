package se.ju14.scrumboard.repository.action;

import java.util.Collection;

import se.ju14.scrumboard.model.Member;

public interface MemberRepository extends CrudRepository<Member> {

	Member getUserById(String userId);

	Member getUserByFirstName(String firstName);
	
	Member getUserByLastName(String LastName);

	Member getUserByUserName(String UserName);
	
	Collection<Member> getAllUser();
}
