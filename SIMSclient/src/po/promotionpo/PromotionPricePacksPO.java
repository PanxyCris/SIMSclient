package po.promotionpo;
/**
*  �ؼ۰�
* @author ������
* @date 2017��12��27��
*/

import java.time.LocalDate;
import java.util.ArrayList;
import dataenum.PromotionType;
import po.commodity.GiftPO;

public class PromotionPricePacksPO extends PromotionPO {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	*/
	private static final long serialVersionUID = 5383295935262148394L;
	private ArrayList<GiftPO> pricePacks;
	private Double discount; 

	public PromotionPricePacksPO(String id,LocalDate beginDate, LocalDate endDate,Double discount, ArrayList<GiftPO> pricePacks) {
		super(id,beginDate,endDate,PromotionType.PRICEPACKS);
		this.pricePacks = pricePacks;
		this.discount = discount;
	}

	public void setPricePacks(ArrayList<GiftPO> pricePacks){
		this.pricePacks = pricePacks;
	}

	public ArrayList<GiftPO> getPricePacks(){
		return pricePacks;
	}

	public void setDiscount(Double discount){
		this.discount = discount;
	}

	public Double getDiscount(){
		return discount;
	}


}
