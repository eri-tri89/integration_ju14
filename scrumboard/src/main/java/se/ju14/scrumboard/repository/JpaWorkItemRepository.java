package se.ju14.scrumboard.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import se.ju14.scrumboard.model.Issue;
import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.Team;
import se.ju14.scrumboard.model.WorkItem;
import se.ju14.scrumboard.model.status.ItemStatus;
import se.ju14.scrumboard.repository.action.WorkItemRepository;

/**
 * This Class executes the transactions that has to do with the WorkItem entity
 * @author Pierre Vanderpol, Jesper Wendler, Erik Perez
 *
 */
public final class JpaWorkItemRepository extends InMemoryRepository<WorkItem> implements WorkItemRepository {

	public JpaWorkItemRepository() {
		super("WorkItem",WorkItem.class);
	}


	@Override
	public WorkItem changeStatus(WorkItem workItem, ItemStatus itemStatus) {
		WorkItem wiFound = super.getById(workItem.getId());
		if(wiFound != null){ 
			wiFound.setItemStatus(itemStatus);
			return super.saveOrUpdateEntity(wiFound.getId(), wiFound);
		}
		throw new RuntimeException("WorkItem not found");
	}
	
	@Override
	public WorkItem save(WorkItem entity) {
		return super.saveOrUpdateEntity(null, entity);
	}
	
	
	@Override
	public WorkItem update(WorkItem entity) {
		return super.saveOrUpdateEntity(entity.getId(), entity);
	}
	
	@Override
	public WorkItem delete(WorkItem workItem) {
		return this.changeStatus(workItem, ItemStatus.DELETED);
	}
	
	@Override
	public List<WorkItem> getAll() {
		return super.executeFindAll();
	}


	@Override
	public List<WorkItem> getByTeam(Team team) {
		List<WorkItem> workItemList = new ArrayList<WorkItem>();
		List<Member> membersList = new ArrayList<Member>(team.getMembers());

		for (Member m : membersList) {
			Set<WorkItem> workItemListbyMember = m.getWorkItems();
			workItemList.addAll(workItemListbyMember);
		}
		return workItemList;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<WorkItem> getByStatus(ItemStatus itemStatus) {
		return (List<WorkItem>)super.executeQuery(true,"findByStatus", "itemStatus", itemStatus);
	}

	@Override
	public List<WorkItem> getByMember(Member member) {
		return new ArrayList<WorkItem>(member.getWorkItems());
	}

	@Override
	public List<WorkItem> getByWordFilter(String word) {
		List<WorkItem> allWorkItems = super.executeFindAll(),
					   resultList = new ArrayList<WorkItem>();

		for (WorkItem w : allWorkItems) {
			if (w.getSubject().contains(word) || w.getDescription().contains(word)) {
				resultList.add(w);
			}
		}
		return resultList;
	}

	@Override
	public List<WorkItem> getWorkItemsWithIssues() {
		List<WorkItem> allWorkItems = super.executeFindAll(), 
					   resultList = new ArrayList<WorkItem>();

		for (WorkItem w : allWorkItems) {
			if (!w.getIssues().isEmpty()) {
				resultList.add(w);
			}
		}
		return resultList;
	}

	@Override
	public WorkItem getByItemId(String itemID) {
		return (WorkItem)super.executeQuery(false,"findById", "itemID", itemID);
	}


	@Override
	public WorkItem addIssue(WorkItem workItem, Issue issue) {
		WorkItem wiFound = super.getById(workItem.getId());
		if(wiFound != null){
			wiFound.getIssues().add(issue);
			return this.saveOrUpdateEntity(wiFound.getId(), wiFound);
		}
		throw new RuntimeException("workItem not found");
	}

}
