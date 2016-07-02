package se.ju14.scrumboard.model.status;

public enum ItemStatus {
	ACTIVE, 
	ONHOLD, 
	WAITING, 
	DONE, 
	DELETED;
	
	public static ItemStatus parse(String status){
		ItemStatus result = null;
		switch(status){
		case "active":
			return result = ACTIVE;
		case "onhold":
			return result = ONHOLD;
		case "waiting":
			return result = WAITING;
		case "done":
			return result = DONE;
		case "deleted":
			return result = DELETED;
		}
		return result;
	}
}
