package SIMSclient.src.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AccountPO implements Serializable {
	private String name;
	private double money;

	public AccountPO(String n, double m) {
		name = n;
		money = m;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

}