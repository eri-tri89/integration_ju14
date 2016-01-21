package controller;

/**
 * 
 * @author Pierre Vanderpol
 *
 */
public interface CrudRepository<E> {

	E saveOrUpdate(E entity);
	
	E remove(E entity);
	
}
