package bussinesslogicservice.salesblservice;

import java.rmi.RemoteException;
import java.util.*;
import dataenum.ResultMessage;
import po.sales.SalesPO;
import vo.billvo.salesbillvo.SalesInputVO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;


/**
 *
* @ClassName: SalesBLService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author lijie
*
 */
public interface SalesBLService {

	public String getSaleID();
	public String getBackSaleID();

	public SalesPO createSale();

	public void addCommodities(CommodityItemVO item);

	public ArrayList<PromotionPricePacksVO> showPricePacks();

	public void addPricePacks(String id);

	public ArrayList<PromotionTotalVO> FindTotalPromotion();

	public ArrayList<PromotionMemberVO> FindMemberPromotion();

	public double setPromotion(String id);

	public void addMembers(String id);

	public void delte(SalesVO info);

	public SalesVO submit(SalesInputVO Info);
	public SalesVO save(SalesInputVO Info);
	public ResultMessage updateDraft(SalesVO vo);
	public ResultMessage submitDraft(String id);
	
	public ArrayList<String> getMemberIDandName();

}
