package bussinesslogicservice.accountbillblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import vo.billvo.financialbillvo.ReceiptBillVO;

public interface ReceiptBillBLService {

	public ResultMessage save(ReceiptBillVO receiptBillVO);// ���û�У����½��������޸�

	public ResultMessage delete(ReceiptBillVO receiptBillVO);

	public ArrayList<ReceiptBillVO> show();

	public ArrayList<ReceiptBillVO> find(String info, FindAccountBillType type);

	public ArrayList<String> getAccountList();// id+" "+name

	public ArrayList<String> getCustomerList();// id+" "+name

	public ResultMessage commit(ReceiptBillVO receiptBillVO);

	public String getId();

}
