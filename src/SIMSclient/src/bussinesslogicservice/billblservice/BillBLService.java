package SIMSclient.src.bussinesslogicservice.billblservice;

import SIMSclient.src.vo.bill.BillState;
import SIMSclient.src.vo.bill.BillType;

public interface BillBLService {
	public BillType getType();
	public BillState getState();
}
