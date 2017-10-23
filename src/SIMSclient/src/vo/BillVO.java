package SIMSclient.src.vo;

import java.util.Date;


public class BillVO {



	public enum BillType {
		INVENTORY_GIFT("�������"), INVENTORY_BENEFIT("��汨��"), INVENTORY_LOSS("��汨��"), INVENTORY_WARN("��澯��"),

		RECEIVEMENT("�տ"), PAYMENT("�տ"),

		STOCKING("������"), RETURNING("�˻���"), SALES("���۵�");

		public final String value;

		BillType(String value) {
			this.value = value;
		}
	}

	public enum BillState {
		DRAFT("�ݸ�״̬"), COMMITED("���ύ״̬"), SUCCESS("�����ɹ�");

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
