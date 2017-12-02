package SIMSclient.src.vo.makefinancialdoc;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FinancialDocVO implements Serializable {
	private String docID;//单据编号
	private String userID;//当前登录用户的ID
	private String note;//备注
	private String accountName;//银行账户名
	private String money;//转账金额
	private String customerID;
	
	public FinancialDocVO(String docID,String userID,String accountName,String money,String customerID,String note){
		this.docID=docID;
		this.userID=userID;
		this.note=note;
		this.accountName=accountName;
		this.money=money;
		this.customerID=customerID;
	}

	public FinancialDocVO(String c, String a, int tran, int tot) {
		
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

	public String getNote() {
		return note;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
