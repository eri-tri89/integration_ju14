package se.ju14.scrumboard.repository;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.ju14.scrumboard.model.JpaEntity;

/**
 * This Class handles the database operations
 * 
 * @author Erik Perez
 */
public class InMemoryRepository<T extends JpaEntity> {

	private static final String PERSISTENCE_UNIT_NAME = "board";
	private static EntityManagerFactory factory;
	public EntityManager entityManager;
	private String className;
	private Class<T> entityClass;

	protected InMemoryRepository(String className, Class<T> entityClass) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.className = className;
		this.entityClass = entityClass;
	}

	/**
	 * Creates the entityManager needed to do the necessary operations to the
	 * database
	 * 
	 * @return the created entityManager
	 */
	protected EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	private T execute(Function<EntityManager, T> operation) {
		entityManager = createEntityManager();
		try {
			entityManager.getTransaction().begin();
			T obj = operation.apply(entityManager);
			entityManager.getTransaction().commit();
			return obj;
		} finally {
			entityManager.close();
		}
	}

	private void executeVoid(Consumer<EntityManager> operation) {
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
	 * Realizes the save/update transaction
	 * 
	 * @param operation
	 *            the operation to be applied to complete the transaction to the
	 *            database
	 */
	protected T saveOrUpdateEntity(Long id, T t) {
		return (id == null) ? execute(em -> {
			em.persist(t);
			return t;
		}) : execute(em -> {
			return em.merge(t);
		});
	}

	protected void deleteEntity(T t) {
		executeVoid(em -> {
			T toRemove = em.merge(t);
			em.remove(toRemove);
		});
	}

	/**
	 * Executes a query that returns all the elements of the same entity from
	 * the database
	 * 
	 * @param className
	 *            the name of the entity
	 * @param t
	 *            the class type of the entity
	 * @return a list of the elements found by the query executed
	 */
	protected List<T> executeFindAll() {
		entityManager = createEntityManager();
		try {
			return entityManager.createNamedQuery(className + ".findAll", entityClass).getResultList();
		} finally {
			entityManager.close();
		}
	}
	
	protected T getById(Long id) {
		entityManager = createEntityManager();
		try {
			return entityManager.find(entityClass, id);
		} finally {
			entityManager.close();
		}
	}

	/**
	 * Executes a named query from the entity
	 * 
	 * @param query
	 *            the namedQuery to be executed
	 * @param t
	 *            the class type of the entity
	 * @param param
	 *            the name of the param stablished in the named query of the
	 *            entity
	 * @param toFind
	 *            the object to be found within the entity
	 * @return a result list from the query executed
	 */
	protected List<T> executeQuery(String query, String param, Object toFind) {
		entityManager = createEntityManager();
		try {
			return entityManager.createNamedQuery(className + "." + query, entityClass).setParameter(param, toFind)
					.getResultList();
		} finally {
			entityManager.close();
		}
	}

}
