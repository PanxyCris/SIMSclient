package SIMSclient.src.po;

import java.io.Serializable;

@SuppressWarnings("serial")

/**
 * 
 * @author Íõ²Ó²Ó
 * @version 2017-12-1
 *
 */
public class AccountPO implements Serializable {
	private String name;
	private String money;

	public AccountPO(String n, String m) {
		name = n;
		money = m;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}




}