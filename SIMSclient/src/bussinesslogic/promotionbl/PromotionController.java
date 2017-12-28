package bussinesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataservice.promotiondataservice.PromotionDataService;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.promotionvo.PromotionVO;

/**
 * 
 * @author Lijie
 * @date 2017Äê12ÔÂ24ÈÕ
 */
public class PromotionController implements PromotionBLService {

	private PromotionDataService service;

	public PromotionController() {
		service = RemoteHelper.getInstance().getPromotionDataService();
	}

	@Override
	public ResultMessage insert(PromotionVO vo) {
		return null;
	}

	@Override
	public ResultMessage delete(PromotionVO vo) {
		return null;
	}

	@Override
	public ResultMessage update(PromotionVO vo) {
		return null;
	}

	@Override
	public ArrayList<PromotionVO> show() {
		return null;
	}

	@Override
	public String getID() {
		return null;
	}

	@Override
	public ArrayList<PromotionVO> find(String info, FindPromotionType findType) {
		return null;
	}

}
