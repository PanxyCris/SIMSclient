package SIMSclient.src.dataservice.billdataservice;

import SIMSclient.src.enumeration.BillState;
import SIMSclient.src.enumeration.BillType;

public interface BillDataService {

	public BillType getType();
	public BillState getState();

}
