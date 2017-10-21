package SIMSclient.src.vo.bill;

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
