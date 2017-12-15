package data.commondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.CommonDataService;
import po.PurchasePO;
import po.SalesPO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ15ÈÕ    
*/
public class CommonDataServiceImpl implements CommonDataService {

	private CommonData common;
	
	public CommonDataServiceImpl() {
		common = new CommonData();
		
	}
	
	@Override
	public ArrayList<SalesPO> showSales() throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PurchasePO> showPurchase() throws RemoteException {
		return null;
	}

}
