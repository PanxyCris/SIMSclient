package data.purchasedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSalesType;
import dataservice.purchasedataservice.PurchaseDataService;
import po.PurchasePO;

/**     
*  
* @author Lijie 
* @date 2017��12��8��    
*/
public class PurchaseDataServiceImpl implements PurchaseDataService{

	private PurchaseData purchase;
	
	public PurchaseDataServiceImpl() {
		purchase = new PurchaseData();
	}
		
	@Override
	public ResultMessage insertPurchase(PurchasePO po) throws RemoteException {
		return purchase.insert(po);
	}

	@Override
	public ResultMessage deletePurchase(String ID) throws RemoteException {
		return purchase.delete(ID);
	}

	@Override
	public ResultMessage updatePurchase(PurchasePO po) throws RemoteException {
		return purchase.update(po);
	}

	@Override
	public ArrayList<PurchasePO> showPurchase() throws RemoteException {
		return purchase.show();
	}


	@Override
	public ArrayList<PurchasePO> findPurchase(String keyword, FindSalesType type) throws RemoteException {
		return purchase.find(keyword, type);
	}

}
