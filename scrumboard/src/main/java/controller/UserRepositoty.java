package controller;

import java.util.Collection;

import model.User;

public interface UserRepositoty extends CrudRepository<User> {

	User getUserById(String userId);

	User getUserByFirstName(String firstName);
	
	User getUserByLastName(String LastName);

	User getUserByUserName(String UserName);
	
	Collection<User> getAllUser();
}
