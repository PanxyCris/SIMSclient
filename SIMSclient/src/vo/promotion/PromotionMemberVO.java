package vo.promotion;
/**
*
* @author Lijie
* @date 2017Äê12ÔÂ11ÈÕ
*/

import java.time.LocalDate;
import java.util.ArrayList;

import dataenum.MemberLevel;
import vo.commodity.CommodityItemVO;
import vo.commodity.GiftVO;

public class PromotionMemberVO extends PromotionVO {
	private LocalDate beginDate;
	private LocalDate endDate;
	private MemberLevel level;
	private String levelString;
	private Double allowance;
	private Double voucher;
	private ArrayList<GiftVO> gifts;

	public PromotionMemberVO(LocalDate beginDate, LocalDate endDate, MemberLevel level, Double allowance, Double voucher,
			ArrayList<GiftVO> gifts) {
		super();
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.level = level;
		levelString = level.value;
		this.allowance = allowance;
		this.voucher = voucher;
		this.gifts = gifts;
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

	public void setAllowance(Double allowance){
		this.allowance = allowance;
	}

	public Double getAllowance(){
		return allowance;
	}

	public MemberLevel getLevel(){
		return level;
	}

	public String getLevelString(){
		return levelString;
	}

	public void setVoucher(Double voucher){
		this.voucher = voucher;
	}

	public Double getVoucher(){
		return voucher;
	}

	public void setGifts(ArrayList<GiftVO> gifts){
		this.gifts = gifts;
	}

	public ArrayList<GiftVO> getGifts(){
		return gifts;
	}



}
