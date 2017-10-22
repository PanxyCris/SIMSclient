package SIMSclient.src.vo.makefinancialdoc;

import java.io.Serializable;

public class FinancialDocVO implements Serializable {
	String docID;//单据编号
	String userID;//当前登录用户的ID
	String note;//备注
	
	public FinancialDocVO(String d,String u,String n){
		docID=d;
		userID=u;
		note=n;
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

	public void setNote(String note) {
		this.note = note;
	}
}
