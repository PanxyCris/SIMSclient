package bussinesslogicservice.accountbillblservice;

import java.util.ArrayList;
import dataenum.ResultMessage;
import dataenum.findtype.FindReceiptBillType;
import vo.billvo.financialbillvo.ReceiptBillVO;


public interface ReceiptBillBLService {

	public ResultMessage save(ReceiptBillVO receiptBillVO);//���û�У����½��������޸�

	public ResultMessage delete(ReceiptBillVO receiptBillVO);

	public ArrayList<ReceiptBillVO> show();

	public ArrayList<ReceiptBillVO> find(String info,FindReceiptBillType type);

	public ArrayList<String> getAccountList();

	public ArrayList<String> getCustomerList();

	public ResultMessage commit(ReceiptBillVO receiptBillVO);

}
