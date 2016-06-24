package se.ju14.scrumboard.repository;

import org.junit.Test;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.JpaEntity;
import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;

public class TestRepository {

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
		memberRepo.delete(m3);
	}
	
	private void addWorkItemToMember(){
		memberRepo.addWorkItemToMember(m1, w1);
		memberRepo.addWorkItemToMember(m2, w2);
		memberRepo.addWorkItemToMember(m2, w3);
	}
	
	private void addMembersToTeam(){
		teamRepo.addMemberToTeam(m1, t1);
		teamRepo.addMemberToTeam(m2, t2);
		teamRepo.addMemberToTeam(m3, t2);
	}
	
	private void addIssuesToWorkItems(){
		wiRepo.addIssue(wiRepo.getByItemId(w1.getItemID()), i1);
		wiRepo.addIssue(wiRepo.getByItemId(w3.getItemID()), i2);
	}
	
	private void showSavedMembers(){
		System.out.println("Getting all Members = " + memberRepo.getAll());
		System.out.println("Getting by firstName = ("+m2.getFirstName()+") \n" + memberRepo.getByFirstName(m2.getFirstName()));
		System.out.println("Getting by lastName = ("+m3.getLastName()+") \n"+memberRepo.getByLastName(m3.getLastName()));
		System.out.println("Getting by memberId ("+m1.getMemberId()+")\n"+memberRepo.getByMemberId(m1.getMemberId()));
		System.out.println("Getting by username ("+m2.getUserName()+") \n"+memberRepo.getByUserName(m2.getUserName()));
		System.out.println("Getting by team ("+t2.getName()+")\n");
		//TODO: fix this: returns null even if the name of the team is registered in the DB
		for(Member m:teamRepo.getTeamByName(t2.getName()).getMembers()){
			System.out.println(m);
		}
	}
}
