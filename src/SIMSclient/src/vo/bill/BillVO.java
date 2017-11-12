package SIMSclient.src.vo.bill;

import java.util.Date;


public class BillVO {

	public enum BillState {
		DRAFT("草稿状态"), COMMITED("已提交状态"), SUCCESS("审批成功");

		public final String value;

		BillState(String value) {
			this.value = value;
		}
	}

	public enum BillType{
		INVENTORYGIFTBILL("库存赠送单"),INVENTORYLOSSBILL("库存报损单"),INVENTORYREVENUEBILL("库存报溢单"),INVENTORYWARNINGBILL("库存报警单"),

		SALESBILL("销售单"),PURCHASEBILL("进货单"),SALESBACKBILL("销售退货单"),PURCHASEBACKBILL("进货退货单"),

		SKD("收款单"),XJFYD("付款单");

		public final String value;

		BillType(String value){
			this.value = value;
		}
	}

	public String id;
	public Date date;
	BillState state;
	BillType type;
	String description;

	public BillVO(String i,Date d, BillState s,BillType t,String des){
		id = i;
		date = d;
		state = s;
		type = t;
		description = des;
	}

	public String getID(){
		return id;
	}

	public Date getDate(){
		return date;
	}


	public BillState getState(){
		return state;
	}

	public BillType getType(){
		return type;
	}

	public String getDescription(){
		return description;
	}

}
