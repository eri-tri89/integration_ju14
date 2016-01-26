package se.ju14.scrumboard.repository;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.status.MemberStatus;
import se.ju14.scrumboard.repository.action.MemberRepository;

/**
 * 
 * @author Pierre Vanderpol, Jesper Wendler, Erik Perez
 *
 */
public final class JpaMemberRepository extends InMemoryRepository implements MemberRepository {

	private static final String PERSISTENCE_UNIT_NAME = "board";
	private static EntityManagerFactory factory;

	/**
	 * Creates a new Member object in the database and gives it an ID
	 * 
	 * @parameter Entity : a valid Entity parameter is needed
	 * @return returns a newly created Member object
	 */
	@Override
	public Member create(Member entity) {

//		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//		EntityManager em = factory.createEntityManager();
			String id = UUID.randomUUID().toString();
			em.getTransaction().begin();
			entity.setMemberId(id);
			em.persist(entity);
			em.getTransaction().commit();
			
			System.out.println("Entity created First name: "+ entity.getFirstName() 
			+ "User name"+entity.getUserName());
		//}
		
		em.close();

		return entity;
	}

	/**
	 * Updates an existing User object in the database(?)
	 * 
	 * @parameter User : a valid User parameter is needed
	 * @return returns the updated User object
	 */
	@Override
	public Member update(Member entity) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		Member memberToChange = em.find(Member.class, entity.getId());
		
		if (memberToChange != null) {			
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			
			System.out.println("Entity updated First name: "+ entity.getFirstName() 
			+ "User name"+entity.getUserName());
		}
		
		em.close();

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
	public Member delete(Member entity) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Member memberToChange = em.find(entity.getClass(), entity.getUserName());
		if (memberToChange != null) {			
			em.getTransaction().begin();
			
			memberToChange.setMemberStatus(MemberStatus.DELETED);
			
			em.persist(entity);
			em.getTransaction().commit();
		}
		
		em.close();

		return entity;

		
	}

	/**
	 * Get an existing User object in the database by ID
	 * 
	 * @parameter User : a valid String id parameter is needed
	 * @return returns the corresponding User object
	 */
	@Override
	public Member getUserById(String userId) {

		return null;
	}

	/**
	 * Get all user object
	 * 
	 * @return returns Collection of User
	 */
	@Override
	public Collection<Member> getAllUser() {

		return null;
	}

	/**
	 * Get an existing User object in the database by firstName
	 * 
	 * @parameter User : a valid String id parameter is needed
	 * @return returns the corresponding User object
	 */
	@Override
	public Member getUserByFirstName(String firstName) {

		return null;	}

	/**
	 * Get an existing User object in the database by LastName
	 * 
	 * @parameter User : a valid String id parameter is needed
	 * @return returns the corresponding User object
	 */

	@Override
	public Member getUserByLastName(String LastName) {

		return null;
	}

	/**
	 * Get an existing User object in the database by UserName
	 * 
	 * @parameter User : a valid String id parameter is needed
	 * @return returns the corresponding User object
	 */

	@Override
	public Member getUserByUserName(String UserName) {

		return null;
	}

}
