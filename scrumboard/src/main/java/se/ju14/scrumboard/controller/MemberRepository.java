package controller;

import java.util.Collection;

import model.Users;

public interface UserRepositoty extends CrudRepository<Users> {

	Users getUserById(String userId);

	Users getUserByFirstName(String firstName);
	
	Users getUserByLastName(String LastName);

	Users getUserByUserName(String UserName);
	
	Collection<Users> getAllUser();
}
