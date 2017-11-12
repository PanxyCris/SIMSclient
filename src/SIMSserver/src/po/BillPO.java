package SIMSserver.src.po;

import java.io.Serializable;
import java.util.Date;

public class BillPO implements Serializable{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	public int id;
	BillState state;
	BillType type;
	String description;

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


	/**
	 * @param type
	 * @param state
	 * @param date
	 */
	public BillPO(int i,Date d,BillState s, BillType t,String des) {

		id = i;
		date = d;
		state = s;
		type = t;
		description = des;
	}

	public int getID(){
		return id;
	}

	public Date getDate() {
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
