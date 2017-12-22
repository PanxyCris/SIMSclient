package po.FinancialBill;

import java.io.Serializable;

import dataenum.BillState;
import dataenum.BillType;
import po.BillPO;

public class FinancialDocPO extends BillPO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected String docID;//���ݱ��
	protected String userID;//��ǰ��¼�û���ID
	protected String customerID;//�ͻ�ID
	protected String note;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public FinancialDocPO(String docID,String userID,String customerID,
			BillType billType,BillState billState){
		super(billType, billState);
		this.docID=docID;
		this.userID=userID;
		this.customerID=customerID;
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

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	
	
}
