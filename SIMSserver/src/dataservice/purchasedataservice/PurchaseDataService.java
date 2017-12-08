package dataservice.purchasedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.CommonDataService;
import po.PurchasePO;

/**  
* ��˵��   
*  
* @author ****  
* @date 2017��10��22��    
*/
public interface PurchaseDataService extends CommonDataService<PurchasePO> {

	public static final String NAME = "PurchaseData";
	
	public String getPurchaseID() throws RemoteException;
	
	public String getPurchaseBackID() throws RemoteException;
}
