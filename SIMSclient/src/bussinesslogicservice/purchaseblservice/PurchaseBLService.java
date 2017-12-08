package SIMSclient.src.bussinesslogicservice.purchaseblservice;

import java.util.ArrayList;

import SIMSclient.src.vo.PromotionVO;
import SIMSclient.src.vo.commodity.CommodityVO;
import SIMSclient.src.vo.purchase.PurchaseVO;

/**  
* ��˵��   ����
*  
* @author ****  
* @date 2017��10��22��    
*/
public interface PurchaseBLService {

	public String getPurchaseID();
	public String getPurBackID();
	
	public CommodityVO getCommodityByID(int ID);
	
	public ArrayList<PromotionVO> getCommodityPromotionListByID(int commodityID);
	
	public PurchaseVO submit(PurchaseVO Info);
	
	public PurchaseVO save(PurchaseVO Info);

	public void endSales();
}
