package po.FinancialBill;


public class AccountListPO {
	
	protected String accountID;//�����˻�ID
	protected String money;//ת�˽��
	protected String note;//��ע
	
	public AccountListPO(String accountID,String money,String note){
		this.accountID=accountID;
		this.money=money;
		this.note=note; 
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	
}
