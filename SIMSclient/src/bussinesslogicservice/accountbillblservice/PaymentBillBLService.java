package bussinesslogicservice.accountbillblservice;

import dataenum.ResultMessage;
import vo.makefinancialdoc.PaymentBillVO;

public interface PaymentBillBLService {

	public ResultMessage save(PaymentBillVO paymentBillVO);//���û�У����½��������޸�
	
	public ResultMessage delete(PaymentBillVO paymentBillVO);
	
	public PaymentBillVO find();
	
	public ResultMessage getAccountList();
	
	public ResultMessage getCustomerList();
	
	public ResultMessage judgeLegal(String money);
	
	public ResultMessage commit(PaymentBillVO paymentBillVO);
	
}
