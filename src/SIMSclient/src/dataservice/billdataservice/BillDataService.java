package SIMSclient.src.dataservice.billdataservice;

import SIMSclient.src.vo.bill.BillState;
import SIMSclient.src.vo.bill.BillType;

public interface BillDataService {

	public BillType getType();
	public BillState getState();

}
