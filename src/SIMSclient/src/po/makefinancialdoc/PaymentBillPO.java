package SIMSclient.src.po.makefinancialdoc;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author ���Ӳ�
 *@version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class PaymentBillPO extends FinancialDocPO {
	private String docID;//���ݱ��
	private String userID;//��ǰ��¼�û���ID
	private String note;//��ע
	//ת���б�
	private ArrayList<String> accountName;//�����˻���
	private ArrayList<String> money;//ת�˽��
	private String customerID;//�ͻ�ID
	
	private String total;//ת���ܶ�	

	public PaymentBillPO (String docID,String userID,ArrayList<String> accountName,ArrayList<String> money,String customerID,String note,String total){
		super(docID,userID,accountName,money,customerID,note);
		this.total=total;
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
