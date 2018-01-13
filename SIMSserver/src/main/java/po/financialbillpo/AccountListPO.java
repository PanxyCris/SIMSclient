package po.financialbillpo;

import java.io.Serializable;

public class AccountListPO implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected String accountID;//�����˻�ID
	protected Double money;//ת�˽��
	protected String note;//��ע

	public AccountListPO(String accountID,Double money,String note){
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

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
