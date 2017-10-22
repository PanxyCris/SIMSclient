package SIMSclient.src.po;

public class AccountBookPO {
	String date;
	int clerkID;

	public AccountBookPO(String d, int c) {
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
