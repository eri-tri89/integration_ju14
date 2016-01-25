package controller;

import javax.ws.rs.core.Response;

import model.Issue;

/**
 * Common Crud operations shared by all repositories. 
 * @author Pierre Vanderpol
 *
 */
public interface CrudRepository<E> {

	E create(E entity);
	
	E update(E entity);
	
	E delete(E entity);

}
