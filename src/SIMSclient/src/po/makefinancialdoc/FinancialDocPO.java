package SIMSclient.src.po.makefinancialdoc;

import java.io.Serializable;
import java.util.ArrayList;

import SIMSclient.src.po.PersistObject;

/**
 * 
 * @author 王灿灿
 * @version2017-12-2
 *
 */
@SuppressWarnings("serial")
public class FinancialDocPO extends PersistObject{
	private String userID;//当前登录用户的ID
	private String note;//备注
	private ArrayList<String> accountName;//银行账户名
	private ArrayList<String> money;//转账金额
	private String customerID;//客户ID
	
	public FinancialDocPO(String id, String userID,ArrayList<String> accountName,ArrayList<String> money,String customerID,String note){
		super(id);
		this.userID=userID;
		this.note=note;
		this.accountName=accountName;
		this.money=money;
		this.customerID=customerID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getNote() {
		return note;
	}

	public ArrayList<String> getAccountName() {
		return accountName;
	}

	public void setAccountName(ArrayList<String> accountName) {
		this.accountName = accountName;
	}

	public ArrayList<String> getMoney() {
		return money;
	}

	public void setMoney(ArrayList<String> money) {
		this.money = money;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
