package se.ju14.scrumboard.repository;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * This Class handles the database operations 
 * @author Erik Perez
 * */
public class InMemoryRepository<T> {

	private static final String PERSISTENCE_UNIT_NAME = "board";
	private static EntityManagerFactory factory;
	public EntityManager entityManager;
	

	protected InMemoryRepository() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	/**
	 * Creates the entityManager needed to do the necessary operations to the database
	 * @return the created entityManager
	 * */
	protected EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	/**
	 * Realizes the save/update transaction
	 * @param operation the operation to be applied to complete the transaction to the database 
	 * */
	protected void saveOrUpdateEntity(Consumer<EntityManager> operation) {
		entityManager = createEntityManager();
		try {
			entityManager.getTransaction().begin();
			operation.accept(entityManager);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	/**
	 * Executes a query that returns all the elements of the same entity from the database
	 * @param className the name of the entity
	 * @param t the class type of the entity
	 * @return a list of the elements found by the query executed
	 * */
	protected List<T> executeFindAll(String className, Class<T> t) {
		entityManager = createEntityManager();
		try {
			return entityManager.createNamedQuery(className+".findAll", t).getResultList();
		} finally {
			entityManager.close();
		}
	}
	/**
	 * Executes a named query from the entity
	 * @param query the namedQuery to be executed
	 * @param t the class type of the entity
	 * @param param the name of the param stablished in the named query of the entity
	 * @param toFind the object to be found within the entity
	 * @return a result list from the query executed
	 * */
	protected List<T> executeQuery(String query, Class<T> t,String param,Object toFind) {
		entityManager = createEntityManager();
		try {
			return entityManager.createNamedQuery(query,t).setParameter(param, toFind).getResultList();
		} finally {
			entityManager.close();
		}
	}

}
