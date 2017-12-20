package bussiness_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.salesblservice.Sale_PromotionInfo;
import po.commodity.CommodityItemPO;
import vo.promotionvo.PromotionCommodityVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;

public class Sale_PromotionInfo_Stub implements Sale_PromotionInfo {

	@Override
	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity(String id, ArrayList<String> commodityIDs,
			ArrayList<Integer> commodityNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionMemberVO> findMemberPromotion(String id, String memberID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionTotalVO> findTotalPromotion(String id, double beforePrice) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionPricePacksVO> showPricePacks() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionPricePacksVO findPricePacks(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAllowance(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getVoucher(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CommodityItemPO> getGifts(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
