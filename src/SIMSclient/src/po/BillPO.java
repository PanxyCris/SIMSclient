package SIMSclient.src.po;

import SIMSclient.src.vo.bill.BillState;
import SIMSclient.src.vo.bill.BillType;

public class BillPO {
	BillType type;
	BillState state;

	public BillPO(BillType t, BillState s) {
		type = t;
		state = s;
	}

	public BillType getType() {
		return type;
	}

	public BillState getState() {
		return state;
	}
}
