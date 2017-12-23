package bussinesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.ResultMessage;
import po.PromotionPO;
import vo.promotion.PromotionVO;

public class PromotionBL implements PromotionBLService{
//1234567
	
	@Override
	public ResultMessage delete(String id) throws RemoteException{
		return service.deletePromotion(id);
	}
	@Override
	public ResultMessage update(MemberVO vo) throws RemoteException{
		return service.updatePromotion(transition.VOtoPO(vo));
	}
	@Override
	public getId() throws RemoteException {
		ArrayList<PromotionPO> list = service.showPromotion();
		ArrayList<Integer> IDList = new ArrayList<>();
		for (PromotionPO po : list) {
			IDList.add(Integer.parseInt(po.getId()));
		}
		Collections.sort(IDList);
		String id = String.valueOf(IDList.get(IDList.size()-1)+1);
		StringBuilder sb = new StringBuilder(id);
		int len = id.length();
		for (int i=0; i < 6-len; i++) {
			sb.insert(0, "0");
		}
		return sb.toString();
	}
	@Override
	public delete() throws RemoteException{
		return service.deletePromotion();
	}
	@Override
	public ArrayList<PromotionVO> find(String info, FindPromotionType findType) throws RemoteException {
		ArrayList<PromotionVO> list = new ArrayList<>();
		ArrayList<PromotionPO> poList = service.findPromotion(keyword, type);
		PromotionVO vo = null;
		for (PromotionPO po : poList) {
			vo = transition.POtoVO(po);
			list.add(vo);
		}
		return list;
	}
	public ArrayList<P> getPromotionList(){
		return service.promotionList();
	}
}
