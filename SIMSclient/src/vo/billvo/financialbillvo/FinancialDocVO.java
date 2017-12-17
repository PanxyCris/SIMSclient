package vo.billvo.financialbillvo;

import java.io.Serializable;

import dataenum.BillState;
import dataenum.BillType;
import vo.billvo.BillVO;


/**
 *
 * @author 王灿灿
 *@version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class FinancialDocVO extends BillVO implements Serializable {
	protected String userID;//当前登录用户的ID
	protected String customerID;//客户ID

	public FinancialDocVO(String docID,String userID,String customerID,
			BillType type,BillState state,String note){
		super(docID,type, state,note);
		this.userID=userID;
		this.customerID=customerID;

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
