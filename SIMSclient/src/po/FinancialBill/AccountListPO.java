package po.FinancialBill;

import java.util.ArrayList;

public class AccountListPO {
	
	protected ArrayList<String> accountName;//�����˻���
	protected ArrayList<String> money;//ת�˽��
	protected ArrayList<String> note;//��ע
	
	public AccountListPO(ArrayList<String> accountName,ArrayList<String> money,ArrayList<String> note){
		this.accountName=accountName;
		this.money=money;
		this.note=note; 
	}

	public ArrayList<String> getAccountName() {
		return accountName;
	}

	public void setAccountName(ArrayList<String> accountName) {
		this.accountName = accountName;
	}

	public ArrayList<String> getMoney() {
		return money;
	}

	public void setMoney(ArrayList<String> money) {
		this.money = money;
	}

	public ArrayList<String> getNote() {
		return note;
	}

	public void setNote(ArrayList<String> note) {
		this.note = note;
	}
	
}
