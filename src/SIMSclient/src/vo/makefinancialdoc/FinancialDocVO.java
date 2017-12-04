package SIMSclient.src.vo.makefinancialdoc;

import java.io.Serializable;
import java.util.ArrayList;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.vo.ValueObject;


/**
 * 
 * @author 王灿灿
 *@version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class FinancialDocVO extends ValueObject implements Serializable {
	protected String docID;//单据编号
	protected String userID;//当前登录用户的ID
	protected ArrayList<String> note;//备注
	protected ArrayList<String> accountName;//银行账户名
	protected ArrayList<String> money;//转账金额
	protected String customerID;//客户ID
	protected BillType billType;//单据类型
	protected BillState billState;//单据状态
	
	public FinancialDocVO(String docID,String userID,ArrayList<String> accountName,ArrayList<String> money,String customerID,
			ArrayList<String> note,BillType billType,BillState billState){
		
		this.docID=docID;
		this.userID=userID;
		this.accountName=accountName;
		this.money=money;
		this.customerID=customerID;
		this.note=note;
		this.billType=billType;
		this.billState=billState;
		
	}

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public ArrayList<String> getNote() {
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

	public void setNote(ArrayList<String> note) {
		this.note = note;
	}

	public BillType getBillType() {
		return billType;
	}

	public void setBillType(BillType billType) {
		this.billType = billType;
	}

	public BillState getBillState() {
		return billState;
	}

	public void setBillState(BillState billState) {
		this.billState = billState;
	}
	
	
}
