package vo.promotionvo;

import java.time.LocalDate;

import dataenum.PromotionType;
import vo.ViewObject;

/**
*
* @author Lijie
* @date 2017��12��11��
*/
public class PromotionVO extends ViewObject{

	private String id;
	private LocalDate beginDate;
	private LocalDate endDate;
	private PromotionType type;
	private String typeString;

	public PromotionVO(String id,LocalDate beginDate,LocalDate endDate,PromotionType type){
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.setType(type);
		this.typeString = type.value;
	}

	public String getId(){
		return id;
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

	public String getTypeString() {
		return typeString;
	}



}
