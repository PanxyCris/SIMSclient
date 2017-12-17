package bussiness_stub.promotion_stub;

import java.util.ArrayList;

import bussinesslogicservice.promotionblservice.PromotionMemberBLService;
import dataenum.ResultMessage;
import vo.promotion.PromotionMemberVO;

public class PromotionMemberBLService_Stub implements PromotionMemberBLService {

	@Override
	public ResultMessage insert(PromotionMemberVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void delete(PromotionMemberVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage update(PromotionMemberVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PromotionMemberVO> getPromotionMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

}
