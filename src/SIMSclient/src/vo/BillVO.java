package SIMSclient.src.vo;

import java.util.Date;


public class BillVO {



	public enum BillType {
		INVENTORY_GIFT("库存赠送"), INVENTORY_BENEFIT("库存报溢"), INVENTORY_LOSS("库存报损"), INVENTORY_WARN("库存警戒"),

		RECEIVEMENT("收款单"), PAYMENT("收款单"),

		STOCKING("进货单"), RETURNING("退货单"), SALES("销售单");

		public final String value;

		BillType(String value) {
			this.value = value;
		}
	}

	public enum BillState {
		DRAFT("草稿状态"), COMMITED("已提交状态"), SUCCESS("审批成功");

		public final String value;

		BillState(String value) {
			this.value = value;
		}
	}

	public int id;
	public Date date;
	BillType type;
	BillState state;
	String description;

	public BillVO(int i,Date d,BillType t, BillState s,String des){
		id = i;
		date = d;
		type = t;
		state = s;
		description = des;
	}

	public int getID(){
		return id;
	}

	public Date getDate(){
		return date;
	}

	public BillType getType(){
		return type;
	}

	public BillState getState(){
		return state;
	}

	public String getDescription(){
		return description;
	}

}
