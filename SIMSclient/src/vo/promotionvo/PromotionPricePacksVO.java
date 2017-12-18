package vo.promotionvo;
/**
*  �ؼ۰�
* @author Lijie
* @date 2017��12��11��
*/

import java.time.LocalDate;

import java.util.ArrayList;

import dataenum.PromotionType;
import vo.commodityvo.GiftVO;

public class PromotionPricePacksVO extends PromotionVO {
	private ArrayList<GiftVO> pricePacks;
	private Double discount;   //�ؼ۰��Ż�ǰ���ܼ�

	public PromotionPricePacksVO(LocalDate beginDate, LocalDate endDate,Double discount, ArrayList<GiftVO> pricePacks) {
		super(beginDate,endDate,PromotionType.PRICEPACKS);
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
