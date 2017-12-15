package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PurchasePO;
import po.SalesPO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ15ÈÕ    
*/
public interface CommonDataService extends Remote {

	public ArrayList<SalesPO> showSales() throws RemoteException;
	public ArrayList<PurchasePO> showPurchase() throws RemoteException;
}
