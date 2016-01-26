package se.ju14.scrumboard.repository.action;



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
