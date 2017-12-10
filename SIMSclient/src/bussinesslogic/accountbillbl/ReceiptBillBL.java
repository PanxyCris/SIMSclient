package bussinesslogic.accountbillbl;

import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import dataenum.ResultMessage;
import vo.makefinancialdoc.PaymentBillVO;
import vo.makefinancialdoc.ReceiptBillVO;

public class ReceiptBillBL implements ReceiptBillBLService{

	private static ReceiptBillBL skdController = new ReceiptBillBL();
	public static ReceiptBillBL getInstance(){
		return skdController;
	}

	public ReceiptBillBLService getSKDBLService(){
		return (ReceiptBillBLService)skdController;
	}

	@Override
	public ResultMessage save(ReceiptBillVO receiptBillVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(ReceiptBillVO receiptBillVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptBillVO find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage judgeLegal(String money) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage commit(ReceiptBillVO receiptBillVO) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
