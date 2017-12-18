package vo.promotionvo;

import java.time.LocalDate;

import dataenum.PromotionType;
import vo.ViewObject;

/**
*
* @author Lijie
* @date 2017Äê12ÔÂ11ÈÕ
*/
public class PromotionVO extends ViewObject{

	private LocalDate beginDate;
	private LocalDate endDate;
	private PromotionType type;

	public PromotionVO(LocalDate beginDate,LocalDate endDate,PromotionType type){
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.setType(type);
	}

	public void setBeginDate(LocalDate beginDate){
		this.beginDate = beginDate;
	}

	public LocalDate getBeginDate(){
		return beginDate;
	}

	public void setEndDate(LocalDate endDate){
		this.endDate = endDate;
	}

	public LocalDate getEndDate(){
		return endDate;
	}

	public PromotionType getType() {
		return type;
	}

	public void setType(PromotionType type) {
		this.type = type;
	}



}
