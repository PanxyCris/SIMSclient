package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import dataservice.billdataservice.BillDataService;
import po.inventorybillpo.InventoryBillPO;

/**     
*  
* @author Lijie 
* @date 2018Äê1ÔÂ10ÈÕ    
*/
public class BillDataService_Stub implements BillDataService {

	@Override
	public ResultMessage insertInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteInventoryBill(String id) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<InventoryBillPO> findInventoryBill(String keyword, FindInventoryBillType type)
			throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<InventoryBillPO> showInventoryBill() throws RemoteException {
		return null;
	}

}
