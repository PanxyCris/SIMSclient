package SIMSclient.src.po;


import java.io.Serializable;

public class AccountPO implements Serializable {
	private String name;
	private int money;
	
	public AccountPO(String n,int m){
		name=n;
		money=m;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}	
	
}