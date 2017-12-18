package bussiness_stub.promotion_stub;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.MemberLevel;
import dataenum.PromotionType;
import dataenum.ResultMessage;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionMemberVO;


public class PromotionMemberBLService_Stub implements PromotionBLService<PromotionMemberVO> {

	@Override
	public ResultMessage insert(PromotionMemberVO vo,PromotionType type) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void delete(PromotionMemberVO vo,PromotionType type) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage update(PromotionMemberVO vo,PromotionType type) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PromotionMemberVO> getPromotionList(PromotionType type) {
		ArrayList<PromotionMemberVO> list = new ArrayList<>();
		LocalDate startDate = LocalDate.of(2016, 8, 28);
		LocalDate endDate = LocalDate.of(2016, 12, 30);
		ArrayList<GiftVO> gifts = new ArrayList<>();
		GiftVO gift1 = new GiftVO("°×³ãµÆ",2);
		GiftVO gift2 = new GiftVO("Ì¨µÆ",1);
		gifts.add(gift1);
		gifts.add(gift2);
		PromotionMemberVO vo1 = new PromotionMemberVO(startDate,endDate,MemberLevel.LEVEL1,20.00,50.00,gifts);
		list.add(vo1);
		return list;
	}

}
