package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import dataservice.purchasedataservice.PurchaseDataService;
import po.PurchasePO;

/**     
*  
* @author Lijie 
* @date 2018Äê1ÔÂ10ÈÕ    
*/
public class PurchaseDataService_Stub implements PurchaseDataService {

	@Override
	public ResultMessage insertPurchase(PurchasePO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deletePurchase(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updatePurchase(PurchasePO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PurchasePO> findPurchase(String keyword, FindSalesType type) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PurchasePO> showPurchase() throws RemoteException {
		return null;
	}

}
