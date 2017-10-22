package SIMSclient.src.po.makefinancialdoc;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FinancialDocPO implements Serializable {
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

	public FinancialDocPO(String c, String a, int tran, int tot) {

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
