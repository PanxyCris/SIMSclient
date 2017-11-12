package SIMSclient.src.po.makefinancialdoc;

import java.io.Serializable;
import java.util.Date;

import SIMSclient.src.po.BillPO;

@SuppressWarnings("serial")
public class FinancialDocPO {
	Date date;
	String docID;// ���ݱ��
	int userID;// ��ǰ��¼�û���ID
	String note;// ��ע

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
