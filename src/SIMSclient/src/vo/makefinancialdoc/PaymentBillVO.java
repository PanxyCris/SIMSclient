package SIMSclient.src.vo.makefinancialdoc;

import java.util.ArrayList;

/**
 * 
 * @author Íõ²Ó²Ó
 *@version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class PaymentBillVO extends FinancialDocVO {
	private String total;//×ªÕË×Ü¶î	
	
	public PaymentBillVO (String docID,String userID,ArrayList<String> accountName,ArrayList<String> money,String customerID,ArrayList<String> note,String total){
		super(docID,userID,accountName,money,customerID,note);
		AccountListVO accountListVO=new AccountListVO(accountName, money, note);
		this.total=total;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	
}
