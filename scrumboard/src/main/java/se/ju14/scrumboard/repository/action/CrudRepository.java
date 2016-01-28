package se.ju14.scrumboard.repository.action;

import java.util.List;

/**
 * Common Crud operations shared by all repositories. 
 * @author Pierre Vanderpol
 *
 */
public interface CrudRepository<E> {

	/**
	 * Saves the entity to the database
	 * @param entity the entity to be saved
	 * @return the entity saved
	 * */
	E save(E entity);	
	
	/**
	 * Updates the entity to the database
	 * @param entity the entity to be updated
	 * @return the entity updated
	 * */
	E update(E entity);
	
	/**
	 * changes the status of the entity to DELETED
	 * @param entity the entity to be DELETED
	 * @return the entity
	 * */
	E delete(E entity);
	
	/**
	 * gets all the elements from database
	 * @return a list with all the elements from database
	 * */
	List<E> getAll();

}
