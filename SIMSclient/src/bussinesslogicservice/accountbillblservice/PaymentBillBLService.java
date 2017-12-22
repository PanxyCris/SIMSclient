package bussinesslogicservice.accountbillblservice;

import java.util.ArrayList;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import vo.billvo.financialbillvo.PaymentBillVO;

public interface PaymentBillBLService {

	public ResultMessage save(PaymentBillVO paymentBillVO);//���û�У����½��������޸�

	public ResultMessage delete(PaymentBillVO paymentBillVO);

	public ArrayList<PaymentBillVO> show();

	public ArrayList<PaymentBillVO> find(String info,FindAccountBillType type);

	public ArrayList<String> getAccountList();  // ����(ID)

	public ArrayList<String> getCustomerList();  // ����(ID)

	public ResultMessage judgeLegal(String money);

	public ResultMessage commit(PaymentBillVO paymentBillVO);



}
