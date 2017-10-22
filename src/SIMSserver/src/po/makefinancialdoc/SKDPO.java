package SIMSserver.src.po.makefinancialdoc;

@SuppressWarnings("serial")
public class SKDPO extends FinancialDocPO {
	String docID;//单据编号
	String userID;//当前登录用户的ID
	String note;//备注
	
	String customer;//客户(包含供应商和销售商)

	//转账列表
	String accountID;//银行账户
	int transferAmount;//转账金额
	
	int total;//总额	汇总
	
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

	public SKDPO (String d,String u,String n,String c,String a,int tran,int tot){
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
