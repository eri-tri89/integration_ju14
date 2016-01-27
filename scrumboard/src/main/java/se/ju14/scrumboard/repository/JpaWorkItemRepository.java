package se.ju14.scrumboard.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.IssueStatus;
import se.ju14.scrumboard.model.status.ItemStatus;
import se.ju14.scrumboard.repository.action.WorkItemRepository;

/**
 * 
 * @author Pierre Vanderpol
 *
 */
public final class JpaWorkItemRepository extends InMemoryRepository<WorkItem> implements WorkItemRepository {

	@Override
	public WorkItem create(WorkItem entity) {
		super.saveOrUpdateEntity(manager -> {
			entity.setItemID(AUTOGENERATED_ID);
			manager.persist(entity);
		});
		return entity;
	}

	@Override
	public WorkItem update(WorkItem entity) {
		super.saveOrUpdateEntity(manager -> {
			manager.merge(entity);
		});
		return entity;
	}

	@Override
	public WorkItem delete(WorkItem entity) {
		super.saveOrUpdateEntity(manager -> {
			entity.setItemStatus(ItemStatus.DELETED);
			manager.merge(entity);
		});
		return entity;
	}

	@Override
	public List<WorkItem> getAll() {
		return super.executeQuery("WorkItem.findAll", WorkItem.class);
	}

	@Override
	public WorkItem asignWorkItemToMember(Member member, String workItemId) {
		WorkItem workItem = super.executeQuery("WorkItem.findById", WorkItem.class, "itemID", workItemId).get(0);
		super.saveOrUpdateEntity(manager -> {
			member.getWorkItems().add(workItem);
			manager.merge(member);
		});
		return workItem;
	}

	@Override
	public List<WorkItem> getWorkItemsByStatus(IssueStatus issueStatus) {
		return super.executeQuery("WorkItem.findByStatus", WorkItem.class, "itemStatus", issueStatus.toString());
	}

	@Override
	public List<WorkItem> getWorkItemsByTeam(Team team) {
		List<WorkItem> workItemList = new ArrayList<WorkItem>();
		List<Member> membersList = new ArrayList<Member>(team.getMembers());

		for (Member m : membersList) {
			Set<WorkItem> workItemListbyMember = m.getWorkItems();
			if (!workItemListbyMember.isEmpty()) {
				workItemList.addAll(workItemListbyMember);
			}
		}
		return workItemList;
	}

	@Override
	public List<WorkItem> getWorkItemsByMember(Member member) {		
		return new ArrayList<WorkItem>(member.getWorkItems());
	}

	@Override
	public List<WorkItem> getWorkItemsByWord(String word) {
		List<WorkItem> workItemList = new ArrayList<WorkItem>(super.executeQuery("WorkItem.findAll", WorkItem.class));
		List<WorkItem> resultList = new ArrayList<WorkItem>();
		
		for(WorkItem w:workItemList){
			if(w.getDescription().equalsIgnoreCase(word)){
				resultList.add(w);
			}
		}		
		return resultList;
	}

	@Override
	public List<WorkItem> getWorkItemsWithIssues() {
		List<WorkItem> workItemList = new ArrayList<WorkItem>(super.executeQuery("WorkItem.findAll", WorkItem.class));
		List<WorkItem> resultList = new ArrayList<WorkItem>();
		for(WorkItem w:workItemList){
			if(w.getIssues().size() < 0){
				resultList.add(w);
			}
		}	
		
		return resultList;
	}

	@Override
	public WorkItem addIssueToWorkItem(WorkItem workItem, Issue issue) {
		super.saveOrUpdateEntity(manager->{
			workItem.getIssues().add(issue);
			manager.merge(workItem);
		});
		return workItem;
	}

}
