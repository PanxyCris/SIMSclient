package vo.billvo.financialbillvo;

import java.io.Serializable;

import dataenum.BillState;
import dataenum.BillType;
import vo.billvo.BillVO;


/**
 *
 * @author ���Ӳ�
 *@version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class FinancialDocVO extends BillVO implements Serializable {
	protected String userID;//��ǰ��¼�û���ID
	protected String customer;
	protected String customerID;//�ͻ�ID

	public FinancialDocVO(String docID,String userID,String customer,
			BillType type,BillState state,String note){
		super(docID,type, state,note);
		this.userID=userID;
		this.customer=customer;
        for(int i=0;i<customer.length();i++){
           if(customer.charAt(i)=='('){
        	   customerID = customer.substring(i+1, i+7);
        	   break;
           }
        }
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
