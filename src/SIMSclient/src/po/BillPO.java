package SIMSclient.src.po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BillPO implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String date;
	protected String id;
	
	/*
	 *自动生成单据编号和日期 
	 */
	public BillPO(String id) {
		this.id = id;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		date = sdf.format(new Date());
	}

	public void setID(String id) {
		this.id = id;
	}
	public String getID(){
		return id;
	}

	public String getDate() {
		return this.date;
	}

}
