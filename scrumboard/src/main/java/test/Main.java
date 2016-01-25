package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Users;

public class Main {

	  private static final String PERSISTENCE_UNIT_NAME = "board";
	  private static EntityManagerFactory factory;

	  public static void main(String[] args) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // read the existing entries and write to console
	    //Query q = em.createQuery("select u from User u");
	    /*
	    List<Person> personList = q.getResultList();
	    for (Person person : personList) {
	      System.out.println(person);
	    }
	    System.out.println("Size: " + personList.size());
		*/
	    // create new person
	   
	    em.getTransaction().begin();
	    Users user = new Users();
	    user.setUserId("1");
	    user.setFirstName("Anna");
	    user.setLastName("Johansson");
	    em.persist(user);
	    em.getTransaction().commit();
	    
	    em.close();
	    
	    //System.out.println(user.getFirstName());
	    
	  }

}
