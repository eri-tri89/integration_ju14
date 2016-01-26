package se.ju14.scrumboard.repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InMemoryRepository<T> {

	private static final String PERSISTENCE_UNIT_NAME = "board";
	private static EntityManagerFactory factory;
	public EntityManager entityManager;
	protected String AUTOGENERATED_ID = UUID.randomUUID().toString();

	protected InMemoryRepository() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	protected EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	protected void saveOrUpdateEntity(Consumer<EntityManager> operation) {
		entityManager = factory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			operation.accept(entityManager);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	protected List<T> executeQuery(String query, Class<T> t) {
		entityManager = factory.createEntityManager();
		try {
			return entityManager.createNamedQuery(query, t).getResultList();
		} finally {
			entityManager.close();
		}
	}
	
	protected List<T> executeQuery(String query, Class<T> t,String param,Object toFind) {
		entityManager = factory.createEntityManager();
		try {
			return entityManager.createNamedQuery(query,t).setParameter(param, toFind).getResultList();
		} finally {
			entityManager.close();
		}
	}

}
