package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.ju14.scrumboard.controller.JpaMemberRepository;
import se.ju14.scrumboard.model.Member;

public class Main {


	  public static void main(String[] args) {

	    JpaMemberRepository repo = new JpaMemberRepository();
	 
	    Member member2 = new Member("Anna","Johanssonson","annaJ78") ;
	    
	    
	    repo.create(member2);
	    
	    member2.setFirstName("bob");
	    repo.update(member2);
	  
	    
	  }

}
