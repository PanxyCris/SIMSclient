package SIMSclient.src.bussinesslogicservice.billblservice;

import SIMSclient.src.enumeration.BillState;
import SIMSclient.src.enumeration.BillType;

public interface BillBLService {
	public BillType getType();
	public BillState getState();
}
