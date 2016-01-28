package test;

import java.util.List;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.IssueStatus;
import se.ju14.scrumboard.model.status.ItemStatus;
import se.ju14.scrumboard.model.status.TeamStatus;
import se.ju14.scrumboard.repository.JpaIssueRepository;
import se.ju14.scrumboard.repository.JpaMemberRepository;
import se.ju14.scrumboard.repository.JpaTeamRepository;
import se.ju14.scrumboard.repository.JpaWorkItemRepository;

public class Main {

	static JpaMemberRepository memberRepo = new JpaMemberRepository();
	static JpaTeamRepository teamRepo = new JpaTeamRepository();
	static JpaWorkItemRepository itemRepo = new JpaWorkItemRepository();
	static JpaIssueRepository issueRepo = new JpaIssueRepository();

	public static void main(String[] args) {
		System.out.println("***************** User operations begin *******************\n");

		Member member1 = new Member("Firstman", "Firstmanson", "numberone");
		createMember(member1);

		member1.setFirstName("Dudeboyman");
		updateMember(member1);

		deleteMember(member1);

		getMemberById(member1.getMemberId());
		getMemberByFirstName(member1.getFirstName());
		getMemberByLastName(member1.getLastName());
		getMemberByUserName(member1.getUserName());

		Team team = teamRepo.save(new Team("firstTeam"));
		getTeamMembers(team, member1);

		System.out.println("\n***************** User operations end *******************\n");
		System.out.println("\n***************** Team operations begin *******************\n");

		Team team2 = new Team("secondTeam");
		createTeam(team2);

		team.setTeamStatus(TeamStatus.ACTIVE);
		updateTeam(team);

		deleteTeam(team2);
		getAllTeams();

		Member member2 = new Member("Second", "SecondSon", "secondone");
		memberRepo.save(member2);
		addMemberToTeam(team, member2);

		System.out.println("\n***************** Team operations end *******************\n");
		System.out.println("\n***************** WorkItem operations begin *******************\n");
		
		WorkItem workItem1 = new WorkItem("kill the dragon","kill it with fire");
		WorkItem workItem2 = new WorkItem("kill the batman","kill it with flowers");
		createAndAddWorkItemToUser(member2,workItem1);
		createAndAddWorkItemToUser(member2,workItem2);
		
		changeWorkItemStatus(workItem2);
		
		deleteWorkItem(workItem1);
		
		getAllWorkItemsByStatus();
		
		getWorkItemsByTeam(team);
		
		getWorkItemsByMember(member2);
		
		getWorkItemsByWord("batman");
		
		
		System.out.println("\n***************** WorkItem operations end *******************\n");
		System.out.println("\n***************** Issue operations begin *******************\n");
		
		Issue issue1 = new Issue("My first issue","I broke my leg playing chess");
		Issue issue2 = new Issue("My second issue","No hablo ingles");
		Issue issue3 = new Issue("My third issue","I broke my teeth eating bananas");
		
		createAndAssignIssueToWorkItem(workItem1,issue1);
		createAndAssignIssueToWorkItem(workItem2,issue2);
		createAndAssignIssueToWorkItem(workItem2,issue3);
		
		updateIssue(issue2);
		getAllWorkItemsWithIssues();
		deleteIssue(issue3);
		System.out.println("\n***************** Issue operations end *******************\n");

	}

	/**********************************************************************************************************/
	// User
	// - Skapa en User
	private static void createMember(Member member) {
		memberRepo.save(member);
		System.out.println("Member created " + member.toString());
	}

	// - Uppdatera en User
	private static void updateMember(Member member) {
		memberRepo.update(member);
		System.out.println("Member updated " + member.toString());
	}

	// - Ta bort* en User
	private static void deleteMember(Member member) {
		memberRepo.delete(member);
		System.out.println("Member deleted " + member.toString());
	}

	// - Hämta en User baserat på user id (inte entity id)
	private static void getMemberById(String memberId) {
		Member m = memberRepo.getById(memberId);
		System.out.println("Member by Id (" + memberId + ") " + m.toString());
	}

	// - Söka efter en User baserat på förnamn eller efternamn eller
	// användarnamn
	private static void getMemberByFirstName(String firstName) {
		List<Member> list = memberRepo.getByFirstName(firstName);
		System.out.println("Members by firstName(" + firstName + ")");
		for (Member m : list) {
			System.out.println("\t - " + m.toString());
		}
	}

	private static void getMemberByLastName(String lastName) {
		List<Member> list = memberRepo.getByLastName(lastName);
		System.out.println("Members by lastName(" + lastName + ")");
		for (Member m : list) {
			System.out.println("\t - " + m.toString());
		}
	}

	private static void getMemberByUserName(String userName) {
		Member m = memberRepo.getByUserName(userName);
		System.out.println("Member by userName(" + userName + ") " + m.toString());
	}

	// - Hämta alla User som ingår i ett visst team
	private static void getTeamMembers(Team team, Member member) {

		teamRepo.addMemberToTeam(member, team);
		List<Member> list = memberRepo.getTeamMembers(team);
		System.out.println("Members in Team \"" + team.getName() + "\"");
		for (Member m : list) {
			System.out.println("\t - " + m.toString());
		}
	}

	/**********************************************************************************************************/
	// Team
	// - Skapa ett team
	private static void createTeam(Team team) {
		teamRepo.save(team);
		System.out.println("Team created " + team.toString());
	}

	// - Uppdatera ett team
	private static void updateTeam(Team team) {
		teamRepo.update(team);
		System.out.println("Team updated " + team.toString());
	}

	// - Ta bort* ett team
	private static void deleteTeam(Team team) {
		teamRepo.delete(team);
		System.out.println("Member deleted " + team.toString());
	}
	// - Hämta alla team

	private static void getAllTeams() {
		List<Team> list = teamRepo.getAll();
		System.out.println("All Teams");
		for (Team t : list) {
			System.out.println("\t - " + t.toString());
		}
	}

	// - Lägga till en User till ett team
	private static void addMemberToTeam(Team team, Member member) {
		List<Member> list = memberRepo.getTeamMembers(teamRepo.addMemberToTeam(member, team));
		System.out.println("Added Members to Team \"" + team.getName() + "\"");
		for (Member m : list) {
			System.out.println("\t - " + m.toString());
		}
	}

	/**********************************************************************************************************/
	// Work item
	// - Skapa en work item / Tilldela en work item till en User
	private static void createAndAddWorkItemToUser(Member member, WorkItem workItem) {
		itemRepo.saveAndAssignToMember(member, workItem);
		System.out.println(
				"WorkItem Created: " + workItem.toString() + "\n\t" + "Assigned To this member: " + member.toString());
	}

	// - Ändra status på en work item
	private static void changeWorkItemStatus(WorkItem workItem) {
		itemRepo.changeStatus(workItem, ItemStatus.ONHOLD);
		System.out.println("workItem status Changed: " + workItem.toString());
	}

	// - Ta bort* en work item
	private static void deleteWorkItem(WorkItem workItem) {
		itemRepo.delete(workItem);
		System.out.println("workItem status deleted: " + workItem.toString());
	}

	// - Hämta alla work item baserat på status
	private static void getAllWorkItemsByStatus() {
		List<WorkItem> list = itemRepo.getByStatus(ItemStatus.ONHOLD);
		System.out.println("workItems by Status(" + ItemStatus.ONHOLD.toString() + "):");
		for (WorkItem w : list) {
			System.out.println("\t - " + w.toString());
		}

	}

	// - Hämta alla work item för ett Team
	private static void getWorkItemsByTeam(Team team) {
		List<WorkItem> list = itemRepo.getByTeam(team);
		System.out.println("workItems by team(" + team.getName() + "):");
		for (WorkItem w : list) {
			System.out.println("\t - " + w.toString());
		}
	}

	// - Hämta alla work item för en User
	private static void getWorkItemsByMember(Member member) {
		List<WorkItem> list = itemRepo.getByMember(member);
		System.out.println("workItems by member");
		for (WorkItem w : list) {
			System.out.println("\t - " + w.toString());
		}
	}

	// - Söka efter work item som innehåller en viss text i sin beskrivning
	private static void getWorkItemsByWord(String word) {
		List<WorkItem> list = itemRepo.getByWordFilter(word);
		System.out.println("workItems by word ("+word+")");
		for (WorkItem w : list) {
			System.out.println("\t - " + w.toString());
		}
	}

	/**********************************************************************************************************/
	// Issue
	// - Skapa en Issue / Lägga till en Issue till en work item
	private static void createAndAssignIssueToWorkItem(WorkItem workItem,Issue issue) {
		issueRepo.addIssueToWorkItem(workItem, issue);
		System.out.println("Issue Created: " + issue.toString() + "\n\t" + "Assigned To this workItem " + workItem.toString());
	}

	// - Uppdatera en Issue
	private static void updateIssue(Issue issue) {
		issue.setDescription("Something changed!");
		issue.setIssueStatus(IssueStatus.WAITING);
		issueRepo.update(issue);
		System.out.println("Issue Updated "+issue.toString());
	}
	// - Hämta alla work item som har en Issue
	private static void getAllWorkItemsWithIssues() {
		List<WorkItem> list = itemRepo.getWorkItemsWithIssues();
		System.out.println("workItems with Issues");
		for (WorkItem w : list) {
			System.out.println("\t - " + w.toString());
		}
	}
	// - ta bort* en Issue (extra)
	private static void deleteIssue(Issue issue){
		issueRepo.delete(issue);
		System.out.println("Issue deleted "+issue.toString());
	}
	

}
