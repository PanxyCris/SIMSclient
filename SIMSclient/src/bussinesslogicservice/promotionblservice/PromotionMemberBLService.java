package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import vo.promotion.PromotionMemberVO;

public interface PromotionMemberBLService {

	public ResultMessage insert(PromotionMemberVO vo);
	public void delete(PromotionMemberVO vo);
	public ResultMessage update(PromotionMemberVO vo);
	public ArrayList<PromotionMemberVO> getPromotionMemberList();

}
