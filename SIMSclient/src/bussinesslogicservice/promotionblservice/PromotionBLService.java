package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;
import dataenum.ResultMessage;
import vo.promotionvo.PromotionVO;

public interface PromotionBLService {
//dffff

	public ResultMessage insert(PromotionVO vo);
	public void delete(PromotionVO vo);
	public ResultMessage update(PromotionVO vo);
	public ArrayList<PromotionVO> getPromotionList();



}
