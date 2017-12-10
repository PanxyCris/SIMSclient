package bussinesslogicservice.accountbillblservice;

import dataenum.ResultMessage;
import vo.makefinancialdoc.ReceiptBillVO;

public interface ReceiptBillBLService {
	
	public ResultMessage save(ReceiptBillVO receiptBillVO);//���û�У����½��������޸�
	
	public ResultMessage delete(ReceiptBillVO receiptBillVO);
	
	public ReceiptBillVO find();
	
	public ResultMessage getAccountList();
	
	public ResultMessage getCustomerList();
	
	public ResultMessage judgeLegal(String money);
	
	public ResultMessage commit(ReceiptBillVO receiptBillVO);
	
}
