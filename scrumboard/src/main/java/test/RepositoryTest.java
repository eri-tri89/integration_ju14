package test;

import java.util.Collection;

import controller.JpaIssueRepository;
import controller.JpaTeamRepository;
import controller.JpaUserRepository;
import model.Issue;
import model.IssueStatus;
import model.Team;
import model.TeamStatus;
import model.Users;
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
			Users usr1 = new Users("Bob","Builder","Boby123");
			testUser.create(usr1);
			System.out.println(usr1.toString());
			System.out.println("");
			
			System.out.println("Create User2");
			Users usr2 = new Users("Anna","Johasson","anna789");
			testUser.create(usr2);
			System.out.println(usr2.toString());
			System.out.println("");
			
			// UPDATE & DELETE
			System.out.println("Update User 2");
			usr2.setUserStatus(UserStatus.DELETED);
			testUser.update(usr2);
			System.out.println(usr2.toString());
			System.out.println("");
			
			
			// GET BY ID
			System.out.println("Get by ID");
			System.out.println(testUser.getUserById(usr2.getUserId()));
			System.out.println("");
			
			
			// GET BY FIRSTNAME
			System.out.println("Get by Firstname");
			System.out.println(testUser.getUserByFirstName("Bob").toString());
			System.out.println("");
			
			
			// GET BY LASTNAME
			System.out.println("Get by Lastname");
			System.out.println("By LastName "+testUser.getUserByLastName("Johasson"));
			System.out.println("");
			
			
			// GET BY USERNAME
			System.out.println("Get by Username");
			System.out.println("By Username "+testUser.getUserByUserName("anna789"));
			System.out.println("");
			
			
			// DELETE
			System.out.println("Delete User 2");
			testUser.delete(usr2);
			System.out.println("null is user deleted : " + usr2.getFirstName() +" " + usr2.getUserStatus());
			
			// GET ALL USERS
			System.out.println("Get all users");
			Collection<Users> userList = testUser.getAllUser();
			
			for(Users u : userList){
				System.out.println(u.toString());
			}
			
			/*
			// ====================================================
			// TEST CLASS JpaTeamRepository
			// ====================================================
*/
			/*
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
			
			*/
		}

	
}
