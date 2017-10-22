package SIMSclient.src.vo.makefinancialdoc;

@SuppressWarnings("serial")
public class SKDVO extends FinancialDocVO {
	String docID;//���ݱ��
	int userID;//��ǰ��¼�û���ID
	String note;//��ע
	
	String customer;//�ͻ�(������Ӧ�̺�������)

	//ת���б�
	String accountID;//�����˻�
	int transferAmount;//ת�˽��
	
	int total;//�ܶ�	����
	
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

	public SKDVO (String d,int u,String n,String c,String a,int tran,int tot){
		super(d,u,n);
		docID=d;
		userID=u;
		note=n;
		customer=c;
		accountID=a;
		transferAmount=tran;
		total=tot;
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
