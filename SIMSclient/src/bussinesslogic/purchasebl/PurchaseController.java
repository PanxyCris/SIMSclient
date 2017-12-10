package bussinesslogic.purchasebl;

import java.util.ArrayList;

import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import vo.PromotionVO;
import vo.commodity.CommodityVO;
import vo.purchase.PurchaseVO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ1ÈÕ    
*/
public class PurchaseController implements PurchaseBLService{

	@Override
	public String getPurchaseID() {
		return null;
	}

	@Override
	public String getPurBackID() {
		return null;
	}

	@Override
	public CommodityVO getCommodityByID(int ID) {
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getCommodityPromotionListByID(int commodityID) {
		return null;
	}

	@Override
	public PurchaseVO submit(PurchaseVO Info) {
		return null;
	}

	@Override
	public PurchaseVO save(PurchaseVO Info) {
		return null;
	}

	@Override
	public void endSales() {
	}

}
