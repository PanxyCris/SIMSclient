package bussinesslogicservice.accountbillblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import vo.AccountVO;
import vo.FinancialBill.ReceiptBillVO;
import vo.member.MemberVO;

public interface ReceiptBillBLService {
	
	public ResultMessage save(ReceiptBillVO receiptBillVO);//���û�У����½��������޸�
	
	public ResultMessage delete(ReceiptBillVO receiptBillVO);
	
	public ArrayList<ReceiptBillVO> find();
	
	public ArrayList<AccountVO> getAccountList();
	
	public ArrayList<MemberVO> getCustomerList();
	
	public ResultMessage judgeLegal(String money);
	
	public ResultMessage commit(ReceiptBillVO receiptBillVO);
	
}
