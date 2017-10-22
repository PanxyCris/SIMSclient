package SIMSclient.src.po.makefinancialdoc;

/**
 * �տ
 * @author xxx
 *
 */
@SuppressWarnings("serial")
public class ReceiptPO extends FinancialDocPO {
	String docID;// ���ݱ��
	String userID;// ��ǰ��¼�û���ID
	String note;// ��ע

	String customer;// �ͻ�(������Ӧ�̺�������)

	// ת���б�
	String accountID;// �����˻�
	int transferAmount;// ת�˽��

	int total;// �ܶ� ����

	

	/**
	 * @param d
	 * @param u
	 * @param n
	 * @param docID
	 * @param userID
	 * @param note
	 * @param customer
	 * @param accountID
	 * @param transferAmount
	 * @param total
	 */
	public ReceiptPO(String d, String u, String n, String docID, String userID, String note, String customer,
			String accountID, int transferAmount, int total) {
		super(d, u, n);
		this.docID = docID;
		this.userID = userID;
		this.note = note;
		this.customer = customer;
		this.accountID = accountID;
		this.transferAmount = transferAmount;
		this.total = total;
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



	public String getCustomer() {
		return customer;
	}



	public void setCustomer(String customer) {
		this.customer = customer;
	}



	public String getAccountID() {
		return accountID;
	}



	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}



	public int getTransferAmount() {
		return transferAmount;
	}



	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}

	
	
}
