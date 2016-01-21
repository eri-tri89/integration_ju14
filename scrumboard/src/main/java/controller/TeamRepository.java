package controller;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

import model.Issue;
import model.Team;
import model.User;
import model.WorkItem;

/**
 * Crud operations specific to Team.
 * @author Pierre Vanderpol
 *
 */



public interface TeamRepository extends CrudRepository<Team> {

	/*
	Hämta alla team 
	Lägga till en User till ett team

	 * */	
	// Get all teams  
	Collection<Team> getAllTeams();

	// Lägga till en user till ett team
	Collection<User> getAllTeamMembers();
	
	
	
	
	
}
