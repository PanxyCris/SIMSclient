package SIMSserver.src.dataservice.billdataservice;

import SIMSserver.src.enumeration.BillState;
import SIMSserver.src.enumeration.BillType;

public interface BillDataService {

	public BillType getType();
	public BillState getState();

}
