package vo.promotionvo;
/**
*
* @author Lijie
* @date 2017Äê12ÔÂ11ÈÕ
*/

import java.time.LocalDate;

import java.util.ArrayList;

import dataenum.PromotionType;
import vo.commodityvo.CommodityItemVO;


public class PromotionCommodityVO extends PromotionVO{

	public double allowance;
	public double voucher;
	public ArrayList<CommodityItemVO> gifts;
	public ArrayList<PromotionGoodsVO> goods;
	
	public PromotionCommodityVO(String id, LocalDate beginDate, LocalDate endDate, PromotionType type, double allowance,
			double voucher, ArrayList<CommodityItemVO> gifts, ArrayList<PromotionGoodsVO> goods) {
		super(id, beginDate, endDate, type);
		this.allowance = allowance;
		this.voucher = voucher;
		this.gifts = gifts;
		this.goods = goods;
	}

	

}
