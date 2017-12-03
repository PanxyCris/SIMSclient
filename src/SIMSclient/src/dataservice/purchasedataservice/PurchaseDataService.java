package SIMSserver.src.dataservice.purchasedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSclient.src.vo.PromotionVO;
import SIMSclient.src.vo.commodity.CommodityVO;
import SIMSclient.src.vo.purchase.PurchaseVO;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.PurchasePO;

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
