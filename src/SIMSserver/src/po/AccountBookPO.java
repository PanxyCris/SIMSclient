package SIMSserver.src.po;

public class AccountBookPO extends PersistObject {
	private static final long serialVersionUID = 1L;
	private String date;
	private int clerkID;

	public AccountBookPO(String id, String d, int c) {
		super(id);
		date = d;
		clerkID = c;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getClerkID() {
		return clerkID;
	}

	public void setClerkID(int clerkID) {
		this.clerkID = clerkID;
	}
}
