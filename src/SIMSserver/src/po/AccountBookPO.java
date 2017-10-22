package SIMSserver.src.po;

public class AccountBookPO {
	String date;
	String clerkID;

	public AccountBookPO(String d, String c) {
		date = d;
		clerkID = c;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClerkID() {
		return clerkID;
	}

	public void setClerkID(String clerkID) {
		this.clerkID = clerkID;
	}
}
