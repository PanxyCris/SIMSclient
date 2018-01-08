package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionMemberDataService;
import po.promotionpo.PromotionMemberPO;
import po.promotionpo.PromotionPO;


public class PromotionDataService_Stub implements PromotionMemberDataService{

	@Override
	public ResultMessage insertPromotion(PromotionMemberPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteMemberPromotion(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updatePromotion(PromotionMemberPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionMemberPO> findMemberPromotion(String keyword, FindPromotionType type)
			throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionMemberPO> showMemberPromotion() throws RemoteException {
		return null;
	}
	
}
