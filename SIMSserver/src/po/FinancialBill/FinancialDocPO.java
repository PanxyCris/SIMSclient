package po.FinancialBill;

import dataenum.BillState;
import dataenum.BillType;
import po.BillPO;

public class FinancialDocPO extends BillPO {
	
	private static final long serialVersionUID = 1L;
	protected String docID;//���ݱ��
	protected String userID;//��ǰ��¼�û���ID
	protected String customer;
	protected String customerID;//�ͻ�ID

	public FinancialDocPO(String docID,String userID,String customer,
			BillType billType,BillState billState){
		super(billType, billState);
		this.docID=docID;
		this.userID=userID;
		this.customer=customer;
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

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	
	

}
