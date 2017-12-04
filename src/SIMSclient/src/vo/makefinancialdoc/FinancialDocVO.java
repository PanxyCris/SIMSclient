package SIMSclient.src.vo.makefinancialdoc;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * 
 * @author ���Ӳ�
 *@version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class FinancialDocVO implements Serializable {
	protected String docID;//���ݱ��
	protected String userID;//��ǰ��¼�û���ID
	protected ArrayList<String> note;//��ע
	protected ArrayList<String> accountName;//�����˻���
	protected ArrayList<String> money;//ת�˽��
	protected String customerID;//�ͻ�ID
	
	public FinancialDocVO(String docID,String userID,ArrayList<String> accountName,ArrayList<String> money,String customerID,ArrayList<String> note){
		this.docID=docID;
		this.userID=userID;
		this.accountName=accountName;
		this.money=money;
		this.customerID=customerID;
		this.note=note;
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

	public ArrayList<String> getNote() {
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

	public void setNote(ArrayList<String> note) {
		this.note = note;
	}
}
