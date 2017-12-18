package vo.billvo.financialbillvo;

import java.util.ArrayList;


import dataenum.BillState;
import dataenum.BillType;

@SuppressWarnings("serial")
public class ReceiptBillVO extends FinancialDocVO {

	private ArrayList<AccountListVO> accountListVOs;//转账列表

	private Double total;//总额

	public ReceiptBillVO(String docID, String userID,String customerID,BillType billType,BillState billState
			,ArrayList<AccountListVO> accountListVOs,Double total,String note) {
		super(docID,userID,customerID,billType,billState,note);
		this.total=total;
		accountListVOs=new ArrayList<AccountListVO>();
	}

	public ArrayList<AccountListVO> getAccountListVOs() {
		return accountListVOs;
	}

	public void setAccountListVOs(ArrayList<AccountListVO> accountListVOs) {
		this.accountListVOs = accountListVOs;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}




}
