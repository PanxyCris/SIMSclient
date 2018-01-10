package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataservice.accountbilldataservice.ReceiptBillDataService;
import po.FinancialBill.ReceiptBillPO;

/**     
*  
* @author Lijie 
* @date 2018Äê1ÔÂ10ÈÕ    
*/
public class ReceiptBillDataService_Stub implements ReceiptBillDataService{

	@Override
	public ResultMessage insertReceiptBill(ReceiptBillPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteReceiptBill(String id) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateReceiptBill(ReceiptBillPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<ReceiptBillPO> findReceiptBill(String keyword, FindAccountBillType type) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<ReceiptBillPO> showReceiptBill() throws RemoteException {
		return null;
	}

}
