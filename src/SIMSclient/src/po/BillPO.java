package SIMSclient.src.po;

import java.io.Serializable;
import java.util.Date;

public class BillPO implements Serializable{


	private Date date;
	public int id;
	String description;



	/**
	 * @param type
	 * @param state
	 * @param date
	 */
	public BillPO(int i,Date d,String des) {

		id = i;
		date = d;
		description = des;
	}


	public Date getDate() {
		return date;
	}

	public String getDescription(){
		return description;
	}



}
