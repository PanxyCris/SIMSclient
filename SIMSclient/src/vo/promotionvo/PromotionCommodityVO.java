package vo.promotionvo;
/**
*
* @author Lijie
* @date 2017��12��11��
*/

import java.time.LocalDate;

import java.util.ArrayList;

import vo.commodityvo.CommodityItemVO;


public class PromotionCommodityVO extends PromotionVO{

	public double allowance;
	public double voucher;
	public ArrayList<CommodityItemVO> gifts;
	public ArrayList<PromotionGoodsVO> goods;

	public PromotionCommodityVO(LocalDate beginDate, LocalDate endDate, double allowance, double voucher,
			ArrayList<CommodityItemVO> gifts, ArrayList<PromotionGoodsVO> goods) {
		super(beginDate,endDate);
		this.allowance = allowance;
		this.voucher = voucher;
		this.gifts = gifts;
		this.goods = goods;
	}


}
