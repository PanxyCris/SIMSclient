package po.FinancialBill;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;

public class ReceiptBillPO extends FinancialDocPO {
	private static final long serialVersionUID = 1L;
	private ArrayList<AccountListPO> accountListPOs;//ת���б�

	private double total;//�ܶ�

	public ReceiptBillPO(String docID, String userID,String customerID,BillType billType,BillState billState
			,ArrayList<AccountListPO> accountListPOs,Double total,String note) {
		super(docID,userID,customerID,billType,billState,note);
		this.total=total;
		this.accountListPOs=accountListPOs;;
	}

	public ArrayList<AccountListPO> getAccountListPOs() {
		return accountListPOs;
	}

	public void setAccountListPOs(ArrayList<AccountListPO> accountListPOs) {
		this.accountListPOs = accountListPOs;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
