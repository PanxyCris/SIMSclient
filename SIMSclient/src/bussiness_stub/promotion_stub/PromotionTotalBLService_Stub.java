package bussiness_stub.promotion_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.PromotionType;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import vo.promotionvo.PromotionTotalVO;

public class PromotionTotalBLService_Stub implements PromotionBLService<PromotionTotalVO> {

	@Override
	public ResultMessage insert(PromotionTotalVO vo) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage delete(PromotionTotalVO vo) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(PromotionTotalVO vo) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionTotalVO> getPromotionList() throws RemoteException {
		return null;
	}

	@Override
	public String getID() throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionTotalVO> find(String info, FindPromotionType findType) throws RemoteException {
		return null;
	}

	

}
