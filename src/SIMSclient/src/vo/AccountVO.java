package SIMSclient.src.vo;
import java.io.Serializable;

/**
 *
 * @author Íõ²Ó²Ó
 * @version 2017-12-1
 */
public class AccountVO implements Serializable{

	private String name;
	private String money;

	public AccountVO(String n,String m){
		name=n;
		money=m;
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

	public void setMoney(String d) {
		this.money = d;
	}



}