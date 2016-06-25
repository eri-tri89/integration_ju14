package se.ju14.scrumboard.repository;

import org.junit.Test;

import com.google.gson.Gson;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.JpaEntity;
import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.ItemStatus;

public class TestRepository {

	Gson gson = new Gson();
	
	Member m1, m2, m3;
	Team t1, t2;
	WorkItem w1, w2, w3;
	Issue i1, i2;
	
	JpaMemberRepository memberRepo = new JpaMemberRepository();
	JpaTeamRepository teamRepo = new JpaTeamRepository();
	JpaWorkItemRepository wiRepo = new JpaWorkItemRepository();
	JpaIssueRepository isRepo = new JpaIssueRepository();

	public TestRepository() {
		m1 = (Member)generateJpaObject(1,"Member");
		m2 = (Member)generateJpaObject(2,"Member");
		m3 = (Member)generateJpaObject(3,"Member");
		
		t1 = (Team)generateJpaObject(1,"Team");
		t2 = (Team)generateJpaObject(2,"Team");
		
		w1 = (WorkItem)generateJpaObject(1,"WorkItem");
		w2 = (WorkItem)generateJpaObject(2,"WorkItem");
		w3 = (WorkItem)generateJpaObject(3,"WorkItem");
		
		i1 = (Issue)generateJpaObject(1,"Issue");
		i2 = (Issue)generateJpaObject(2,"Issue");

	}

	private JpaEntity generateJpaObject(int num, String className) {
		String tmp = "";
		
		switch(className){
		case "Member":
			tmp = className + num;
			return new Member(tmp, tmp + "son", tmp + "user");
		case "Team":
			tmp = className + num;
			return new Team(tmp);
		case "WorkItem":
			tmp = className + num;
			return new WorkItem(tmp, "This is a subject to " + tmp);
		case "Issue":
			tmp = className + num;
			return new Issue(tmp, "this " + tmp + " sucks...");
		}
		return null;
	}

	@Test
	public void TestRepositoryFlow() {
		saveMembersAndTeams();
		addMembersToTeam();
		updateMember();
		deleteMember();
		addWorkItemToMember();
		addIssuesToWorkItems();
		showSavedMembers();
		showSavedTeams();
		showSavedWorkItems();
		showIssues();
	}
	
	private void saveMembersAndTeams(){
		try {
			m1 = memberRepo.save(m1);
			m2 = memberRepo.save(m2);
			m3 = memberRepo.save(m3);
			t1 = teamRepo.save(t1);
			t2 = teamRepo.save(t2);
		} catch (Exception e) {
			System.out.println("Already Saved");
		}
	}
	
	private void updateMember(){
		m1.setFirstName(m1.getFirstName()+"changed");
		memberRepo.update(m1);
	}
	
	private void deleteMember(){
		m3 = memberRepo.delete(m3);
	}
	
	private void addWorkItemToMember(){
		m1 = memberRepo.addWorkItemToMember(m1, w1);
		m2 = memberRepo.addWorkItemToMember(m2, w2);
		m2 = memberRepo.addWorkItemToMember(m2, w3);
	}
	
	private void addMembersToTeam(){
		t1 = teamRepo.addMemberToTeam(m1, t1);
		t2 = teamRepo.addMemberToTeam(m2, t2);
		t2 = teamRepo.addMemberToTeam(m3, t2);
	}
	
	private void addIssuesToWorkItems(){
		wiRepo.addIssue(wiRepo.getByItemId(w1.getItemID()), i1);
		wiRepo.addIssue(wiRepo.getByItemId(w3.getItemID()), i2);
	}
	
	private void showSavedMembers(){
		System.out.println("Getting all Members = \n" + gson.toJson(memberRepo.getAll()));
		System.out.println("Getting by firstName = ("+m2.getFirstName()+") \n" + gson.toJson(memberRepo.getByFirstName(m2.getFirstName())));
		System.out.println("Getting by lastName = ("+m3.getLastName()+") \n"+gson.toJson(memberRepo.getByLastName(m3.getLastName())));
		System.out.println("Getting by memberId ("+m1.getMemberId()+")\n"+gson.toJson(memberRepo.getByMemberId(m1.getMemberId())));
		System.out.println("Getting by username ("+m2.getUserName()+") \n"+gson.toJson(memberRepo.getByUserName(m2.getUserName())));
		System.out.println("Get team members by team name (Team2)\n"+gson.toJson(teamRepo.getTeamByName("Team2").getMembers()));
	}
	
	private void showSavedTeams(){
		System.out.println("Getting all Teams = \n"+gson.toJson(teamRepo.getAll()));
		System.out.println("Getting by team name ("+t2.getName()+")\n"+gson.toJson(teamRepo.getTeamByName(t2.getName())));
	}
	
	private void showSavedWorkItems(){
		System.out.println("Getting workitem by id("+w1.getItemID()+") = \n"+gson.toJson(wiRepo.getByItemId(w1.getItemID())));
		System.out.println("Getting workitems by Member ("+m1+") = \n"+gson.toJson(wiRepo.getByMember(m2)));
		System.out.println("Getting workitems by ItemStatus ("+ItemStatus.ACTIVE.toString()+") = \n"+gson.toJson(wiRepo.getByStatus(ItemStatus.ACTIVE)));
		System.out.println("Getting workItems by Team ("+gson.toJson(teamRepo.getTeamByName("Team2"))+") = \n"+gson.toJson(wiRepo.getByTeam(teamRepo.getTeamByName("Team2"))));
		System.out.println("Getting workitems by wordfilter (\"subject\")\n"+gson.toJson(wiRepo.getByWordFilter("subject")));
		System.out.println("Getting workitems with issues \n"+wiRepo.getWorkItemsWithIssues());
	}
	
	private void showIssues(){
		System.out.println("Getting issue by its issueID ("+i2.getIssueID()+") = \n"+gson.toJson(isRepo.getByID(i2.getIssueID())));
	}
}
