package bussinesslogicservice.accountbillblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import vo.AccountVO;
import vo.FinancialBill.PaymentBillVO;
import vo.member.MemberVO;

public interface PaymentBillBLService {

	public ResultMessage save(PaymentBillVO paymentBillVO);//���û�У����½��������޸�
	
	public ResultMessage delete(PaymentBillVO paymentBillVO);
	
	public PaymentBillVO find();
	
	public ArrayList<AccountVO> getAccountList();
	
	public ArrayList<MemberVO> getCustomerList();
	
	public ResultMessage judgeLegal(String money);
	
	public ResultMessage commit(PaymentBillVO paymentBillVO);
	
}
