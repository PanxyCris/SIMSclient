package bussinesslogic.accountbillbl;

import java.rmi.RemoteException;

import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import dataenum.ResultMessage;
import dataservice.accountbilldataservice.PaymentBillDataService;
import po.FinancialBill.PaymentBillPO;
import vo.FinancialBill.PaymentBillVO;

public class PaymentBillBL implements PaymentBillBLService{
	
	PaymentBillPO paymentBillPO;
	PaymentBillVO paymentBillVO;
	
	PaymentBillTransition paymentBillTransition;
	PaymentBillDataService paymentBillDataService;
	

	@Override
	public ResultMessage save(PaymentBillVO paymentBillVO) {
		paymentBillPO=paymentBillTransition.VOtoPO(paymentBillVO);
		
		try {
			return paymentBillDataService.insertPaymentBill(paymentBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(PaymentBillVO paymentBillVO) {
		String id=paymentBillVO.getDocID();
		try {
			return paymentBillDataService.deletePaymentBill(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public PaymentBillVO find() {
		
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
	public ResultMessage commit(PaymentBillVO paymentBillVO) {
		// TODO Auto-generated method stub
		return null;
	}


}
