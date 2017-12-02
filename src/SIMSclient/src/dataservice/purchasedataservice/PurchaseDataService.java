package SIMSclient.src.dataservice.purchasedataservice;

import java.rmi.RemoteException;

import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataservice.DataService;
import SIMSclient.src.po.PurchasePO;

/**     
*  
* @author Lijie 
* @date 2017年12月1日    
*/
public interface PurchaseDataService extends DataService<PurchasePO>{

	/*RMI绑定时候的名称 */
	public static final String NAME = "PurchaseData";
	
	String getID(BillType type) throws RemoteException;

    String getPurchaseID() throws RemoteException;

    String getPurchaseBackID() throws RemoteException;
}
