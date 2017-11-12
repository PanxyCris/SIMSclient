package SIMSclient.src.po.makefinancialdoc;

import java.io.Serializable;
import java.util.Date;

import SIMSclient.src.po.BillPO;

@SuppressWarnings("serial")
public class FinancialDocPO {
	Date date;
	String docID;// 单据编号
	int userID;// 当前登录用户的ID
	String note;// 备注

	public FinancialDocPO(String d, int u, String n, Date date) {
		docID = d;
		userID = u;
		note = n;
		this.date = date;
	}

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
