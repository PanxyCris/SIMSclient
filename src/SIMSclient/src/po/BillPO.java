package SIMSclient.src.po;

import javax.xml.crypto.Data;

import SIMSclient.src.enumeration.BillState;
import SIMSclient.src.enumeration.BillType;

public class BillPO {
	BillType type;
	BillState state;
	private Data date;
	
	/**
	 * @param type
	 * @param state
	 * @param date
	 */
	public BillPO(BillType type, BillState state, Data date) {
		super();
		this.type = type;
		this.state = state;
		this.date = date;
	}

	public BillType getType() {
		return type;
	}

	public void setType(BillType type) {
		this.type = type;
	}

	public BillState getState() {
		return state;
	}

	public void setState(BillState state) {
		this.state = state;
	}

	public Data getDate() {
		return date;
	}

	public void setDate(Data date) {
		this.date = date;
	}

	
}
