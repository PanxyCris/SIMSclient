package SIMSclient.src.vo;

import java.util.Date;


public class BillVO {



	public enum BillState {
		DRAFT("�ݸ�״̬"), COMMITED("���ύ״̬"), SUCCESS("�����ɹ�");

		public final String value;

		BillState(String value) {
			this.value = value;
		}
	}

	public int id;
	public Date date;
	BillState state;
	String description;

	public BillVO(int i,Date d, BillState s,String des){
		id = i;
		date = d;
		state = s;
		description = des;
	}

	public int getID(){
		return id;
	}

	public Date getDate(){
		return date;
	}


	public BillState getState(){
		return state;
	}

	public String getDescription(){
		return description;
	}

}
