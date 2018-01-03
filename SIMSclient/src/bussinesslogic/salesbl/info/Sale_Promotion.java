package bussinesslogic.salesbl.info;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bussiness_stub.promotion_stub.PromotionTotalBLService_Stub;
import bussinesslogic.memberbl.MemberController;
import bussinesslogic.promotionbl.PromotionMemberBL;
import bussinesslogic.promotionbl.PromotionSpecialBL;
import bussinesslogic.promotionbl.PromotionSumBL;
import bussinesslogicservice.salesblservice.Sale_PromotionInfo;
import dataenum.MemberLevel;
import dataenum.findtype.FindMemberType;
import dataservice.promotiondataservice.PromotionMemberDataService;
import dataservice.promotiondataservice.PromotionSpecialDataService;
import dataservice.promotiondataservice.PromotionSumDataService;
import po.commodity.CommodityItemPO;
import po.commodity.GiftPO;
import po.promotionpo.PromotionMemberPO;
import po.promotionpo.PromotionPricePacksPO;
import po.promotionpo.PromotionTotalPO;
import rmi.RemoteHelper;
import vo.billvo.salesbillvo.SalesPriceVO;
import vo.commodityvo.CommodityItemVO;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;
import vo.promotionvo.PromotionVO;

/**
*
* @author Lijie
* @date 2018年1月2日
*/
public class Sale_Promotion implements Sale_PromotionInfo{

	private PromotionMemberDataService member;
	private PromotionSpecialDataService special;
	private PromotionSumDataService sum;
	private PromotionMemberBL memberbl;
	private PromotionSumBL sumbl;
	private PromotionSpecialBL specialbl;
	private MemberController memberController;

	public Sale_Promotion() {
		member = RemoteHelper.getInstance().getMemberPromotionDataService();
		special = RemoteHelper.getInstance().getSpecialPromotionDataService();
		sum = RemoteHelper.getInstance().getSumPromotionDataService();
		memberbl = new PromotionMemberBL();
		sumbl  = new PromotionSumBL();
		specialbl = new PromotionSpecialBL();
		memberController = new MemberController();
	}

	@Override
	public ArrayList<PromotionMemberVO> findMemberPromotion(String memberID) throws RemoteException {
	    MemberLevel level = memberController.find(memberID, FindMemberType.ID).get(0).getLevel();
		ArrayList<PromotionMemberPO> list = member.showMemberPromotion();
		ArrayList<PromotionMemberVO> result = new ArrayList<>();
		if (list == null) {
			System.out.println("无等级促销");
			return null;
		}

		for (PromotionMemberPO po : list) {
			if (po.getLevel().num >= level.num) {
				result.add(memberbl.poTovo(po));
			}
		}

		return result;
	}

	@Override
	public ArrayList<PromotionTotalVO> findTotalPromotion(double beforePrice) throws RemoteException {
		ArrayList<PromotionTotalVO> result = new ArrayList<>();
		ArrayList<PromotionTotalPO> list = sum.showSumPromotion();
		if (list == null) {
			System.out.println("无总价促销");
			return null;
		}

		for (PromotionTotalPO po : list) {
			if (po.getTotal() >= beforePrice) {
				result.add(sumbl.poTovo(po));
			}
		}
		return result;
	}

	@Override
	public ArrayList<PromotionPricePacksVO> findPricePacksPromotion(ArrayList<CommodityItemVO> commodity)
			throws RemoteException {
		ArrayList<PromotionPricePacksVO> result = new ArrayList<>();
		ArrayList<PromotionPricePacksPO> list = special.showSpecialPromotion();
		if (list == null) {
			System.out.println("无特价包");
			return null;
		}

		for (PromotionPricePacksPO po : list) {
			ArrayList<GiftVO> gifts = poTOvo(po.getPricePacks());
			boolean flag = true;
			for (GiftVO g : gifts) {
				if (commodity.indexOf(g) == -1) {  //商品不存在
					flag = false;
					break;
				}
			}
			if (flag) {
				result.add(specialbl.poTovo(po));
			}
		}
		return result;
	}

	@Override
	public SalesPriceVO getPromotionPrice(ArrayList<PromotionVO> promotionList) {
		double voucher = 0, allowance = 0;
		double max = 0;
		for (PromotionVO vo : promotionList) {
			switch (vo.getType()) {
			case LEVEL_PROMOTION:
				PromotionMemberVO m = (PromotionMemberVO) vo;
				if (m.getAllowance() + m.getVoucher() > max) {
					max = m.getAllowance() + m.getVoucher();
					voucher = m.getVoucher();
					allowance = m.getAllowance();
				}
				break;

			case PRICEPACKS:
				PromotionPricePacksVO p = (PromotionPricePacksVO) vo;
				if (p.getDiscount()  > max) {
					max = p.getDiscount();
					voucher = 0;
					allowance = p.getDiscount();
				}
				break;

			case SUM_PROMOTION:
				PromotionTotalVO t = (PromotionTotalVO) vo;
				if (t.getVoucher() > max) {
					voucher = t.getVoucher();
					allowance = 0;
					max = t.getVoucher();
				}
				break;
			default:
				break;
			}
		}

		SalesPriceVO result = new SalesPriceVO(voucher, allowance);
		return result;
	}

	public ArrayList<GiftVO> poTOvo(ArrayList<GiftPO> list) {
		ArrayList<GiftVO> result = new ArrayList<>();
		for (GiftPO po : list) {
			GiftVO vo = new GiftVO(po.getName(), po.getNumber());
			result.add(vo);
		}
		return result;
	}

}
