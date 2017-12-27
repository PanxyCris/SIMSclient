package data.promotiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionSpecialDataService;
import po.promotionpo.PromotionPricePacksPO;

public class PromotionSpecialDataServiceImpl implements PromotionSpecialDataService {

	private PromotionData<PromotionPricePacksPO> promotion;

	public PromotionSpecialDataServiceImpl() {
		promotion = new PromotionData<>();
	}

	@Override
	public ResultMessage insertPromotion(PromotionPricePacksPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.insert(po);
	}

	@Override
	public ResultMessage deleteSpecialPromotion(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.delete(ID);
	}

	@Override
	public ResultMessage updatePromotion(PromotionPricePacksPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.update(po);
	}

	@Override
	public ArrayList<PromotionPricePacksPO> findSpecialPromotion(String keyword, FindPromotionType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.find(keyword, type);
	}

	@Override
	public ArrayList<PromotionPricePacksPO> showSpecialPromotion() throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.show();
	}



}
