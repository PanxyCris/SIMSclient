package bussinesslogicservice.salesblservice;

import java.rmi.RemoteException;


import java.util.*;
import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import po.sales.SalesPO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;
/**
 *
* @ClassName: SalesBLService
* @Description: TODO(������һ�仰��������������)
* @author lijie
*
 */
public interface SalesBLService {

	public String getSaleID();
	public String getBackSaleID();
	public ResultMessage isLegal(CommodityItemVO item);
	public void delete(SalesVO info);

	public ResultMessage submit(SalesVO Info);
	public ResultMessage save(SalesVO Info);

	public ArrayList<SalesVO> show();
	public ArrayList<SalesVO> find(String info,FindSalesType type);


	public ArrayList<PromotionPricePacksVO> showPricePacks();

	public ArrayList<PromotionTotalVO> FindTotalPromotion();

	public ArrayList<PromotionMemberVO> FindMemberPromotion();

}
