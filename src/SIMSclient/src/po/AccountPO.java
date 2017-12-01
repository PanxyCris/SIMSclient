package SIMSclient.src.po;

import java.io.Serializable;

@SuppressWarnings("serial")

/**
 * 
 * @author ���Ӳ�
 * @version 2017-12-1
 *
 */
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

	public void setMoney(double money) {
		this.money = money;
	}


}