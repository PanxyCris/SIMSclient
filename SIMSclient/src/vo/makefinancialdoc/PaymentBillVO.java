package SIMSclient.src.vo.makefinancialdoc;

import java.util.ArrayList;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;

/**
 *
 * @author ���Ӳ�
 *@version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class PaymentBillVO extends FinancialDocVO {
	private String total;//ת���ܶ�
	private String accountID;
	private ArrayList<EntryVO> entryListVO;

	public PaymentBillVO (String docID,String userID,String customerID,String accountID,ArrayList<EntryVO> entryListVO,
			String total,BillType billType,BillState billState){
		super(docID,userID,customerID,billType,billState);
		entryListVO=new ArrayList<EntryVO>();
		this.accountID = accountID;
		this.total=total;
	}

	public String getAccountID(){
		return accountID;
	}

	public void setAccountID(String accountID){
		this.accountID = accountID;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public ArrayList<EntryVO> getAccountListVO() {
		return entryListVO;
	}

	public void setAccountListVO(ArrayList<EntryVO> entryListVO) {
		this.entryListVO = entryListVO;
	}


}
