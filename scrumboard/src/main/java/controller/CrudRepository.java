package controller;

/**
 * Common Crud operations shared by all repositories. 
 * @author Pierre Vanderpol
 *
 */
public interface CrudRepository<E> {

	E saveOrUpdate(E entity);
	
	E remove(E entity);
	
}
