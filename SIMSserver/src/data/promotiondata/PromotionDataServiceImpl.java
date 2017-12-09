package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionDataService;
import po.PromotionPO;

public class PromotionDataServiceImpl implements PromotionDataService{

	private PromotionData promotion;
	

	@Override
	public ResultMessage insertPromotion(PromotionPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deletePromotion(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updatePromotion(PromotionPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionPO> showPromotion() throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionPO> findPromotion(String keyword, FindPromotionType type) throws RemoteException {
		return null;
	}


}
