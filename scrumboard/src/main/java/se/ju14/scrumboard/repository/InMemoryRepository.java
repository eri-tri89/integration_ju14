package se.ju14.scrumboard.repository;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InMemoryRepository {

	private static final String PERSISTENCE_UNIT_NAME = "board";
	private static EntityManagerFactory factory;
	public EntityManager entityManager;
	protected final String AUTOGENERATED_ID = UUID.randomUUID().toString();
	
	protected InMemoryRepository() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	protected EntityManager createEntityManager(){
		return factory.createEntityManager();
	}
	
	
	
}