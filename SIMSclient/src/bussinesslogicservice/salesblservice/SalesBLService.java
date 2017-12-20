package bussinesslogicservice.salesblservice;

import java.rmi.RemoteException;

import java.util.*;
import dataenum.ResultMessage;
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
	public ResultMessage isLegal(CommodityItemVO item);

	public void addCommodities(CommodityItemVO item);

	public ArrayList<PromotionPricePacksVO> showPricePacks();

	public void addPricePacks(String id);

	public ArrayList<PromotionTotalVO> FindTotalPromotion();

	public ArrayList<PromotionMemberVO> FindMemberPromotion();

	public double setPromotion(String id);

	public void addMembers(String id);

	public void delete(SalesVO info);

	public ResultMessage submit(SalesVO Info);
	public ResultMessage save(SalesVO Info);

	public ArrayList<String> getMemberIDandName();

}
