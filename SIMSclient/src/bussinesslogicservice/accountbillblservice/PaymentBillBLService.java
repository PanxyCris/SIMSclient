package bussinesslogicservice.accountbillblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import vo.billvo.financialbillvo.PaymentBillVO;

public interface PaymentBillBLService {

	public ResultMessage save(PaymentBillVO paymentBillVO);//如果没有，就新建，否则修改

	public ResultMessage delete(PaymentBillVO paymentBillVO);

	public ArrayList<PaymentBillVO> show();

	public ArrayList<PaymentBillVO> find(String info,FindAccountBillType type);

	public ArrayList<String> getAccountList();  // 名字(ID)

	public ArrayList<String> getCustomerList();  // 名字(ID)

	public ResultMessage judgeLegal(String money);

	public ResultMessage commit(PaymentBillVO paymentBillVO);



}
