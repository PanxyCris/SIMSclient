package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PurchasePO;
import po.sales.SalesPO;

/**     
*  
* @author Lijie 
* @date 2017��12��15��    
*/
public interface CommonDataService extends Remote {

	public ArrayList<SalesPO> showSales() throws RemoteException;
	public ArrayList<PurchasePO> showPurchase() throws RemoteException;
}