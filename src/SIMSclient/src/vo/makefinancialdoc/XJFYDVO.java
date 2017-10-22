package SIMSclient.src.vo.makefinancialdoc;

@SuppressWarnings("serial")
public class XJFYDVO extends FinancialDocVO {
	String docID;// ���ݱ��
	String userID;// ����Ա(��ǰ��¼�û�)
	String accountID;// �����˻�ID

	// ��Ŀ�嵥
	String entryName;// ��Ŀ��
	int transferAmount;// ���
	String note;// ��ע

	int total;// �ܶ�

	public XJFYDVO(String d, String u, String a, String e, int trans, String n, int to) {
		super(d, u, n);
		docID = d;
		userID = u;
		accountID = a;
		entryName = e;
		transferAmount = trans;
		note = n;
		total = to;
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

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public int getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
