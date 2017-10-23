package SIMSclient.src.po;

import java.util.Date;

public class BillPO {

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

	BillType type;
	BillState state;
	private Date date;
	public int id;
	String description;



	/**
	 * @param type
	 * @param state
	 * @param date
	 */
	public BillPO(int i,Date d,BillType t, BillState s,String des) {

		id = i;
		type = t;
		state = s;
		date = d;
		description = des;
	}

	public BillType getType() {
		return type;
	}

	public BillState getState() {
		return state;
	}

	public Date getDate() {
		return date;
	}

	public String getDescription(){
		return description;
	}



}
