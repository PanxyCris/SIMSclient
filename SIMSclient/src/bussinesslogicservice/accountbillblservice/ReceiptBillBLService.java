package bussinesslogicservice.accountbillblservice;

import java.util.ArrayList;
import dataenum.ResultMessage;
import vo.billvo.financialbillvo.ReceiptBillVO;


public interface ReceiptBillBLService {

	public ResultMessage save(ReceiptBillVO receiptBillVO);//���û�У����½��������޸�

	public ResultMessage delete(ReceiptBillVO receiptBillVO);

	public ArrayList<ReceiptBillVO> find();

	public ArrayList<String> getAccountList();

	public ArrayList<String> getCustomerList();

	public ResultMessage commit(ReceiptBillVO receiptBillVO);

}
