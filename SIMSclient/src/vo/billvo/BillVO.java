package vo.billvo;

import dataenum.BillState;

import dataenum.BillType;
import vo.ViewObject;

public class BillVO extends ViewObject{

	protected BillType billType;//单据类型
	protected String billTypeString;
	protected BillState billState;//单据状态
	protected String billStateString;

	public BillVO(BillType billType,BillState billState) {
		this.billType=billType;
		this.billState=billState;
	}

	public BillType getBillType() {
		return billType;
	}

	public void setBillType(BillType billType) {
		this.billType = billType;
	}

	public BillState getBillState() {
		return billState;
	}

	public void setBillState(BillState billState) {
		this.billState = billState;
	}

	public String getBillTypeString(){
		return billType.value;
	}

	public String getBillStateString(){
		return billState.value;
	}


}
