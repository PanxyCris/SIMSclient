package SIMSclient.src.vo.bill;

import java.util.Date;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;


public class BillVO {

	public String id;
	public Date date;
	public BillState state;
	public BillType type;
	public String description;

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
