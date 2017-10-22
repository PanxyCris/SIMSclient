package SIMSclient.src.vo.bill;

import SIMSclient.src.enumeration.BillState;
import SIMSclient.src.enumeration.BillType;

public class BillVO {

	BillType type;
	BillState state;

	public BillVO(BillType t, BillState s){
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
