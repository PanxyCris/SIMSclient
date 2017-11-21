package SIMSclient.src.po;

import java.io.Serializable;

public class AccountBookPO implements Serializable{
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
