package vo.promotion;
/**
*  特价包
* @author Lijie
* @date 2017年12月11日
*/

import java.time.LocalDate;

import java.util.ArrayList;
import vo.commodity.GiftVO;

public class PromotionPricePacksVO extends PromotionVO {
	private ArrayList<GiftVO> pricePacks;
	private Double discount;   //特价包优惠前的总价

	public PromotionPricePacksVO(LocalDate beginDate, LocalDate endDate,Double discount, ArrayList<GiftVO> pricePacks) {
		super(beginDate,endDate);
		this.pricePacks = pricePacks;
		this.discount = discount;
	}

	public void setPricePacks(ArrayList<GiftVO> pricePacks){
		this.pricePacks = pricePacks;
	}

	public ArrayList<GiftVO> getPricePacks(){
		return pricePacks;
	}

	public void setDiscount(Double discount){
		this.discount = discount;
	}

	public Double getDiscount(){
		return discount;
	}


}
