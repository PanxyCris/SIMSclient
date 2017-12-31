package bussinesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionSumDataService;
import po.commodity.GiftPO;
import po.promotionpo.PromotionTotalPO;
import rmi.RemoteHelper;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionTotalVO;

/**
 *
 * @author ≈À–«”Ó
 * @date 2017ƒÍ12‘¬27»’
 */
public class PromotionSumBL implements PromotionBLService<PromotionTotalVO> {


	private PromotionSumDataService service;

	public PromotionSumBL() {
		service = RemoteHelper.getInstance().getSumPromotionDataService();
	}

	@Override
	public ResultMessage insert(PromotionTotalVO vo) throws RemoteException {
		return service.insertPromotion(voTopo(vo));
	}

	@Override
	public ResultMessage delete(PromotionTotalVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.deleteSumPromotion(vo.getId());
	}

	@Override
	public ResultMessage update(PromotionTotalVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.updatePromotion(voTopo(vo));
	}

	@Override
	public ArrayList<PromotionTotalVO> getPromotionList() throws RemoteException {
		ArrayList<PromotionTotalVO> promotionList = new ArrayList<>();
		for(PromotionTotalPO po:service.showSumPromotion())
			promotionList.add(poTovo(po));
		return promotionList;
	}

	@Override
	public String getID() throws RemoteException {
		ArrayList<PromotionTotalPO> promotionList = service.showSumPromotion();
		String oldID = promotionList.get(promotionList.size()-1).getId();
		int tmp = Integer.parseInt(oldID);
		tmp++;
		String newID = String.valueOf(tmp);
		while(newID.length() < oldID.length())
			newID = "0"+newID;
		return newID;
	}

	@Override
	public ArrayList<PromotionTotalVO> find(String info, FindPromotionType findType) throws RemoteException {
		ArrayList<PromotionTotalVO> promotionList = new ArrayList<>();
		for(PromotionTotalPO po:service.findSumPromotion(info, findType))
			promotionList.add(poTovo(po));
		return promotionList;
	}

	public PromotionTotalPO voTopo(PromotionTotalVO vo){
		ArrayList<GiftPO> gifts = new ArrayList<>();
		if(vo.getGifts()!=null){
		for(GiftVO gift:vo.getGifts())
			gifts.add(new GiftPO(gift.getName(),gift.getNumber()));
		}
		else
			gifts = null;
		PromotionTotalPO po = new PromotionTotalPO(vo.getId(),vo.getBeginDate(),vo.getEndDate(),
				vo.getTotal(),vo.getVoucher(),gifts);
		return po;
	}

	public PromotionTotalVO poTovo(PromotionTotalPO po){
		ArrayList<GiftVO> gifts = new ArrayList<>();
		if(po.getGifts()!=null){
		for(GiftPO gift:po.getGifts())
			gifts.add(new GiftVO(gift.getName(),gift.getNumber()));
		}
		else
			gifts = null;
		PromotionTotalVO vo = new PromotionTotalVO(po.getId(),po.getBeginDate(),po.getEndDate(),
				po.getTotal(),po.getVoucher(),gifts);
		return vo;
	}
}
