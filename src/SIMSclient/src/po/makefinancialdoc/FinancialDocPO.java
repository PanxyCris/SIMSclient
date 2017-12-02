package SIMSclient.src.po.makefinancialdoc;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author ���Ӳ�
 * @version2017-12-2
 *
 */
@SuppressWarnings("serial")
public class FinancialDocPO implements Serializable{
	private String docID;//���ݱ��
	private String userID;//��ǰ��¼�û���ID
	private String note;//��ע
	private ArrayList<String> accountName;//�����˻���
	private ArrayList<String> money;//ת�˽��
	private String customerID;//�ͻ�ID
	
	public FinancialDocPO(String docID,String userID,ArrayList<String> accountName,ArrayList<String> money,String customerID,String note){
		this.docID=docID;
		this.userID=userID;
		this.note=note;
		this.accountName=accountName;
		this.money=money;
		this.customerID=customerID;
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

	public void setNote(String note) {
		this.note = note;
	}
}
