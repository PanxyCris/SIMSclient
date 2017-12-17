package vo.promotionvo;
/**
* 根据购买的商品总价，制定折让，赠品，赠送代金券
* @author Lijie
* @date 2017年12月11日
*/

import java.time.LocalDate;
import java.util.ArrayList;

public class PromotionTotalVO extends PromotionVO {


	private Double total;
	private Double allowance;
	private Double voucher;
	private ArrayList<PromotionGoodsVO> gifts;

	public PromotionTotalVO(String id,LocalDate beginDate,LocalDate endDate, Double total,
			Double allowance,Double voucher, ArrayList<PromotionGoodsVO> gifts) {
		super(beginDate,endDate);
		this.id = id;
		this.setAllowance(allowance);
		this.setVoucher(voucher);
		this.setGifts(gifts);
		this.setTotal(total);
	}

	public Double getAllowance() {
		return allowance;
	}

	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getVoucher() {
		return voucher;
	}

	public void setVoucher(Double voucher) {
		this.voucher = voucher;
	}

	public ArrayList<PromotionGoodsVO> getGifts() {
		return gifts;
	}

	public void setGifts(ArrayList<PromotionGoodsVO> gifts) {
		this.gifts = gifts;
	}

}
