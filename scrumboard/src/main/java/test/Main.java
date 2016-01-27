package test;

import java.util.ArrayList;
import java.util.List;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.repository.JpaMemberRepository;
import se.ju14.scrumboard.repository.JpaTeamRepository;

public class Main {


	  public static void main(String[] args) {
		  
		  JpaMemberRepository memberRepo = new JpaMemberRepository();
		  JpaTeamRepository teamRepo = new JpaTeamRepository();
		  Member member = new Member("first","last","thenumberone");
		  Team team = new Team("firstTeam");
		  
		  teamRepo.create(team);
		  memberRepo.create(member);
		  
		  System.out.println("Team created "+team.toString()+"\nMember created: "+member.toString());
		  
		  team.getMembers().add(member);
		  WorkItem workItem = new WorkItem("first subject","first description");
		  member.getWorkItems().add(workItem);
		  
		  Issue issue = new Issue("first title","first issue");
		  workItem.getIssues().add(issue);
		  
		  teamRepo.update(team);
		  memberRepo.update(member);
		  List<Member> members =  new ArrayList<Member>(teamRepo.getAll().get(0).getMembers());
		  List<WorkItem> workItems = new ArrayList<WorkItem>(memberRepo.getAll().get(0).getWorkItems());
		  //List<Issue> issues = new ArrayList<WorkItem>(memberRepo.getAll().get(0).getWorkItems());
		  
		  System.out.println("member list: "+memberRepo.getAll());
		  System.out.println("Team list: "+teamRepo.getAll()+"\n"
		  		+ " team member: "+members.get(0)+"\n"
		  		+ " workItems: "+workItems.get(0));
	  }

}
