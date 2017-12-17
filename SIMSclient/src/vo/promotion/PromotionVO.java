package vo.promotion;

import java.time.LocalDate;

import vo.ViewObject;

/**
*
* @author Lijie
* @date 2017Äê12ÔÂ11ÈÕ
*/
public class PromotionVO extends ViewObject{

	private LocalDate beginDate;
	private LocalDate endDate;

	public PromotionVO(LocalDate beginDate,LocalDate endDate){
		this.beginDate = beginDate;
		this.endDate = endDate;
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



}
