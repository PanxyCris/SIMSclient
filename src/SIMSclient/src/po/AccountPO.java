package SIMSclient.src.po;

import SIMSclient.src.po.PersistObject;

/**
 * 
 * @author Íõ²Ó²Ó
 * @version 2017-12-1
 *
 */
public class AccountPO extends PersistObject {
	private static final long serialVersionUID = 1L;
	private String name;
	private double money;

	
	public AccountPO(String id, String name, double money) {
		super(id);
		this.name = name;
		this.money = money;
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

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + money;
	}

}