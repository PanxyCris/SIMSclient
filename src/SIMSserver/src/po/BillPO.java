package SIMSserver.src.po;

import SIMSclient.src.enumeration.BillState;
import SIMSclient.src.enumeration.BillType;

public class BillPO {
	BillType type;
	BillState state;

	public BillPO(BillType t, BillState s){
		type = t;
		state = s;
	}

	public BillType getType(){
		return type;
	}

	public BillState getState(){
		return state;
	}
}
