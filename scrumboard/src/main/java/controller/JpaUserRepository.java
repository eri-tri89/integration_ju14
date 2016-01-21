package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import model.User;
import model.UserStatus;

/**
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaUserRepository implements UserRepositoty {

	   // JUST FOR TEST REMOVE IT LATER
		private final Map<String, User> users = new HashMap<>();
	
		/**
		 * Creates a new User object in the database and gives it an ID
		 * 
		 * @parameter USer : a valid User parameter is needed
		 * @return returns a newly created User object
		 */
		@Override
		public User create(User entity) {
			String id = UUID.randomUUID().toString();
			entity = entity.setUserId(id);
			// CHANGE THIS LATER TO GET RESULT FROM DATABASE
			users.put(id, entity);
			//
			return entity;
		}

		
		/**
		 * Updates an existing User object in the database
		 * 
		 * @parameter User : a valid User parameter is needed
		 * @return returns the updated User object
		 */
		@Override
		public User update(User entity) {
			users.put(entity.getUserId(), entity);
			return entity;
		}

		/**
		 * Deletes an existing User object in the database. Objects are never
		 * deleted but their status is changed.
		 * 
		 * @parameter User : a valid User parameter is needed
		 * @return returns the updated User object
		 */
		@Override
		public User delete(User entity) {
			
			// CHANGE TO DATABASE
			if (users.get(entity.getUserId()) != null) {
				entity.setUserStatus(UserStatus.DELETED);
				users.put(entity.getUserId(),entity);
				return entity;
				}else{
				return null;
			}
		}
		
		
		/**
		 * Get an existing User object in the database by ID
		 * 
		 * @parameter User : a valid String id parameter is needed
		 * @return returns the corresponding User object
		 */
		@Override
		public User getUserById(String userId) {
			
			if (users.get(userId) != null) {
				return users.get(userId);
				}else{
				return null;
			}
		}

	
		/**
		 * Get an existing User object in the database by firstName
		 * 
		 * @parameter User : a valid String id parameter is needed
		 * @return returns the corresponding User object
		 */
		@Override
		public User getUserByFirstName(String firstName) {
			Collection<User> usr = users.values();
			for(User u : usr){
				if(u.getFirstName().equals(firstName)){
					return u;
				}
			}
			
			return null;
		}

		/**
		 * Get an existing User object in the database by LastName
		 * 
		 * @parameter User : a valid String id parameter is needed
		 * @return returns the corresponding User object
		 */
		
		@Override
		public User getUserByLastName(String LastName) {
			Collection<User> usr = users.values();
			for(User u : usr){
				if(u.getLastName().equals(LastName)){
					return u;
				}
			}
			return null;
		}
		
		/**
		 * Get an existing User object in the database by UserName
		 * 
		 * @parameter User : a valid String id parameter is needed
		 * @return returns the corresponding User object
		 */
		
		@Override
		public User getUserByUserName(String UserName) {
			Collection<User> usr = users.values();
			for(User u : usr){
				if(u.getUserName().equals(UserName)){
					return u;
				}
			}
			return null;
		}
		

}
