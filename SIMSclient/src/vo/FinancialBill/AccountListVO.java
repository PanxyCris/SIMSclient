package vo.FinancialBill;

import java.util.ArrayList;

public class AccountListVO {

	protected String accountID;//�����˻�ID
	protected String money;//ת�˽��
	protected String note;//��ע

	public AccountListVO(String accountID,String money,String note){
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
