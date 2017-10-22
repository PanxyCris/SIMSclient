package SIMSclient.src.vo;
import java.io.Serializable;

public class AccountVO implements Serializable{
	
	private String name;
	private int money;
	
	public AccountVO(String n,int m){
		name=n;
		money=m;
	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}	
}