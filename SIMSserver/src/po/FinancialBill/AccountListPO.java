package po.FinancialBill;

import java.io.Serializable;

public class AccountListPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String accountName;//�����˻���
	protected String money;//ת�˽��
	protected String note;//��ע
	
	public AccountListPO(String accountName,String money,String note){
		this.accountName=accountName;
		this.money=money;
		this.note=note; 
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
