package bussinesslogicservice.salesblservice;

import java.rmi.RemoteException;

import java.util.ArrayList;
import po.commodity.CommodityItemPO;
import vo.billvo.salesbillvo.SalesPriceVO;
import vo.commodityvo.CommodityItemVO;
import vo.promotionvo.PromotionCommodityVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;
import vo.promotionvo.PromotionVO;

/**
*
* @author Lijie
* @date 2017��12��11��
*/
public interface Sale_PromotionInfo {

	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity(String id, ArrayList<String> commodityIDs, ArrayList<Integer> commodityNumber) throws RemoteException;

	public ArrayList<PromotionMemberVO> findMemberPromotion(String memberID) throws RemoteException;

	public ArrayList<PromotionTotalVO> findTotalPromotion(double beforePrice) throws RemoteException;

	public ArrayList<PromotionPricePacksVO> findPricePacksPromotion(ArrayList<CommodityItemVO> commodityItems) throws RemoteException;

	public PromotionPricePacksVO findPricePacks(String id) throws RemoteException;

	public SalesPriceVO getPromotionPrice(ArrayList<PromotionVO> promotionList);//���ݴ������ԣ����ش���ȯ�ͼ۸�����
	public ArrayList<CommodityItemPO> getGifts(String ID) throws RemoteException;


}