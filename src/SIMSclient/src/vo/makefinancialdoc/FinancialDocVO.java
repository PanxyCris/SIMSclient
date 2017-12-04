package SIMSclient.src.vo.makefinancialdoc;

import java.io.Serializable;
import java.util.ArrayList;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.vo.ValueObject;


/**
 * 
 * @author ���Ӳ�
 *@version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class FinancialDocVO extends ValueObject implements Serializable {
	protected String docID;//���ݱ��
	protected String userID;//��ǰ��¼�û���ID
	protected ArrayList<String> note;//��ע
	protected ArrayList<String> accountName;//�����˻���
	protected ArrayList<String> money;//ת�˽��
	protected String customerID;//�ͻ�ID
	protected BillType billType;//��������
	protected BillState billState;//����״̬
	
	public FinancialDocVO(String docID,String userID,ArrayList<String> accountName,ArrayList<String> money,String customerID,
			ArrayList<String> note,BillType billType,BillState billState){
		
		this.docID=docID;
		this.userID=userID;
		this.accountName=accountName;
		this.money=money;
		this.customerID=customerID;
		this.note=note;
		this.billType=billType;
		this.billState=billState;
		
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

	public BillType getBillType() {
		return billType;
	}

	public void setBillType(BillType billType) {
		this.billType = billType;
	}

	public BillState getBillState() {
		return billState;
	}

	public void setBillState(BillState billState) {
		this.billState = billState;
	}
	
	
}
