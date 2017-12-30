package data.promotiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionMemberDataService;
import po.promotionpo.PromotionMemberPO;

public class PromotionMemberDataServiceImpl implements PromotionMemberDataService{

	private PromotionData<PromotionMemberPO> promotion;
	
	public static void main(String[] args) {
		
	}

	public PromotionMemberDataServiceImpl() {
		promotion = new PromotionData<>();
	}

	@Override
	public ResultMessage insertPromotion(PromotionMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.insert(po);
	}

	@Override
	public ResultMessage deleteMemberPromotion(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.delete(ID);
	}

	@Override
	public ResultMessage updatePromotion(PromotionMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.update(po);
	}

	@Override
	public ArrayList<PromotionMemberPO> findMemberPromotion(String keyword, FindPromotionType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.find(keyword, type);
	}

	@Override
	public ArrayList<PromotionMemberPO> showMemberPromotion() throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.show();
	}


}
