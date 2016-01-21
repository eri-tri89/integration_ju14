package test;

import controller.JpaIssueRepository;
import controller.JpaTeamRepository;
import controller.JpaUserRepository;
import model.Issue;
import model.IssueStatus;
import model.Team;
import model.TeamStatus;
import model.User;
import model.UserStatus;


/**
 * 
 * @author Pierre Vanderpol
 *
 */
public class RepositoryTest {

	
		public static void main(String[] args) {
			// ====================================================
			// TEST CLASS JpaTeamRepository
			// ====================================================

			System.out.println("==================================================== TEST ====================================================");
			JpaUserRepository testUser = new JpaUserRepository();
			
			// CREATE
			System.out.println("Create first User");
			User usr1 = new User("1","Bob","Builder","Boby123",UserStatus.ACTIVE);
			testUser.create(usr1);
			System.out.println(usr1.toString());
			System.out.println("");
			
			System.out.println("Create first User");
			User usr2 = new User("2","Anna","Johasson","anna789",UserStatus.ACTIVE);
			testUser.create(usr2);
			System.out.println(usr2.toString());
			System.out.println("");
			
			// UPDATE
			System.out.println("Update User 2");
			testUser.update(new User("rwerer678b7iaysud","Anna","Johasson-Benett","anna789",UserStatus.ACTIVE));
			System.out.println(usr2.toString());
			System.out.println("");
			
			// GET BY ID
			User usr = new User();
			usr = testUser.getUserById("1");
			System.out.println(usr);
			System.out.println("");
			
			// GET BY FIRSTNAME
			usr = testUser.getUserByFirstName("Bob");
			System.out.println("By FirstName "+usr);
			System.out.println("");
			
			// GET BY LASTNAME
			usr = testUser.getUserByLastName("Johasson-Benett");
			System.out.println("By LastName "+usr);
			System.out.println("");
			
			// GET BY USERNAME
			usr = testUser.getUserByUserName("anna789");
			System.out.println("By Username "+usr);
			System.out.println("");
			
			// DELETE
			System.out.println("Delete User 2");
			testUser.delete(usr2);
			System.out.println("null is user deleted : " + usr2.getFirstName());
			
			// ====================================================
			// TEST CLASS JpaTeamRepository
			// ====================================================

			System.out.println("==================================================== TEST ====================================================");
			JpaTeamRepository test = new JpaTeamRepository();

			System.out.println("Create first TEAM");

			// Team teamTest = new Team("r567bre67rg5","Production team", TeamStatus.ACTIVE,Set<User> users);
			Team teamTest = new Team("r567bre67rg5","Production team", TeamStatus.ACTIVE,null);
			teamTest = test.create(teamTest);
			System.out.println(teamTest.toString());
			System.out.println("");
			System.out.println("Create second TEAM");
			Team teamTest2 = new Team("4786br6e8asr6a78", "Support team", TeamStatus.ACTIVE,null);
			teamTest2 = test.create(teamTest2);
			System.out.println(teamTest2.toString());
			System.out.println("");
			
			// GET ALL ISSUES
			System.out.println("Get all TEAMS =========== TO DO ==================");

			test.delete(teamTest2);

			System.out.println("Get all TEAM AFTER DELET");
			System.out.println(teamTest2);
			System.out.println("");
			System.out.println("==================================================== NEXT TEST ====================================================");
			
			// ====================================================
			// TEST CLASS JpaIssueRepository
			// ====================================================

			JpaIssueRepository test2 = new JpaIssueRepository();

			// CREATE ISSUES
			System.out.println("Create first issue");

			Issue issueTest = new Issue("1fhsdjkfsd", "this is issue number 1", IssueStatus.WAITING);
			issueTest = test2.create(issueTest);
			System.out.println(issueTest.toString());
			System.out.println("");
			System.out.println("Create second issue");
			Issue issueTest2 = new Issue("2ewrtyew", "this is issue number 2", IssueStatus.ACTIVE);
			issueTest2 = test2.create(issueTest2);
			System.out.println(issueTest2.toString());
			System.out.println("");
			
			// GET ALL ISSUES
			System.out.println("Get all issues =========== TO DO ==================");

			test2.delete(issueTest2);

			System.out.println("Get all issues AFTER DELETE");
			System.out.println(issueTest2);
			
			System.out.println("");
			System.out.println("==================================================== NEXT TEST ====================================================");
			
			
		}

	
}
