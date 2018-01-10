package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataservice.accountbilldataservice.PaymentBillDataService;
import po.FinancialBill.PaymentBillPO;

/**     
*  
* @author Lijie 
* @date 2018Äê1ÔÂ10ÈÕ    
*/
public class PaymentBillDataService_Stub implements PaymentBillDataService {

	@Override
	public ResultMessage insertPaymentBill(PaymentBillPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deletePaymentBill(String id) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updatePaymentBill(PaymentBillPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PaymentBillPO> findPaymentBill(String keyword, FindAccountBillType type) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PaymentBillPO> showPaymentBill() throws RemoteException {
		return null;
	}

}
