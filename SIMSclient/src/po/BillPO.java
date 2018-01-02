package po;

import java.io.Serializable;

import dataenum.BillState;
import dataenum.BillType;

public class BillPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected BillType billType;//��������
	protected BillState billState;//����״̬

	public BillPO(BillType billType,BillState billState) {
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
}
