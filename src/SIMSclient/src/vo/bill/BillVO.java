package SIMSclient.src.vo.bill;

import java.util.Date;


public class BillVO {

	public enum BillState {
		DRAFT("�ݸ�״̬"), COMMITED("���ύ״̬"), SUCCESS("�����ɹ�");

		public final String value;

		BillState(String value) {
			this.value = value;
		}
	}

	public enum BillType{
		INVENTORYGIFTBILL("������͵�"),INVENTORYLOSSBILL("��汨��"),INVENTORYREVENUEBILL("��汨�絥"),INVENTORYWARNINGBILL("��汨����"),

		SALESBILL("���۵�"),PURCHASEBILL("������"),SALESBACKBILL("�����˻���"),PURCHASEBACKBILL("�����˻���"),

		SKD("�տ"),XJFYD("���");

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
