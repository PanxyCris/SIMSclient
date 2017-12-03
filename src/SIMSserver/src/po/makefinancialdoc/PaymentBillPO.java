package SIMSserver.src.po.makefinancialdoc;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class PaymentBillPO extends FinancialDocPO {
	private static final long serialVersionUID = 1L;
	private String userID;//��ǰ��¼�û���ID
	private String note;//��ע
	//ת���б�
	private ArrayList<String> accountName;//�����˻���
	private ArrayList<String> money;//ת�˽��
	private String customerID;//�ͻ�ID
	
	private String total;//ת���ܶ�	

	public PaymentBillPO (String id,String userID,ArrayList<String> accountName,ArrayList<String> money,String customerID,String note,String total){
		super(id,userID,accountName,money,customerID,note);
		this.total=total;
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

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}
