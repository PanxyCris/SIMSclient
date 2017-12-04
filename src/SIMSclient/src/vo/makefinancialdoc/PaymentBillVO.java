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
	private AccountListVO accountListVO;
	
	public PaymentBillVO (String docID,String userID,ArrayList<String> accountName,ArrayList<String> money,String customerID,ArrayList<String> note,String total){
		super(docID,userID,accountName,money,customerID,note);
		accountListVO=new AccountListVO(accountName, money, note);
		this.total=total;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public AccountListVO getAccountListVO() {
		return accountListVO;
	}

	public void setAccountListVO(AccountListVO accountListVO) {
		this.accountListVO = accountListVO;
	}

	
}
