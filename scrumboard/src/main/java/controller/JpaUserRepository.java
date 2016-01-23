package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import model.Users;
import model.UserStatus;

/**
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaUserRepository implements UserRepositoty {

	   // JUST FOR TEST REMOVE IT LATER
		private final Map<String, Users> users = new HashMap<>();
		//private static final AtomicLong userIds = new AtomicLong();
		
		/**
		 * Creates a new User object in the database and gives it an ID
		 * 
		 * @parameter USer : a valid User parameter is needed
		 * @return returns a newly created User object
		 */
		@Override
		public Users create(Users entity) {
			String id = UUID.randomUUID().toString(); 
			entity = entity.setUserId(id);
			
			// CHANGE THIS LATER TO GET RESULT FROM DATABASE
			//users.put(id, entity);
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
		public Users update(Users entity) {
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
		public Users delete(Users entity) {
			
			// CHANGE TO DATABASE
			if (users.get(entity.getUserId()) != null) {
				entity.setUserStatus(UserStatus.DELETED);
				// users.put(entity.getUserId(),entity);
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
		public Users getUserById(String userId) {
			
			if (users.get(userId) != null) {
				return users.get(userId);
				}else{
				return null;
			}
		}

		
		/**
		 * Get all user object
		 * 
		 * @return returns Collection of User
		 */
		@Override
		public Collection<Users> getAllUser() {
			return users.values();
		}

		/**
		 * Get an existing User object in the database by firstName
		 * 
		 * @parameter User : a valid String id parameter is needed
		 * @return returns the corresponding User object
		 */
		@Override
		public Users getUserByFirstName(String firstName) {
			Collection<Users> usr = users.values();
			for(Users u : usr){
				if(u.getFirstName().equals(firstName)){
					System.out.println("inside collection"+u.toString());
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
		public Users getUserByLastName(String LastName) {
			Collection<Users> usr = users.values();
			for(Users u : usr){
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
		public Users getUserByUserName(String UserName) {
			Collection<Users> usr = users.values();
			for(Users u : usr){
				if(u.getUserName().equals(UserName)){
					return u;
				}
			}
			return null;
		}

}
