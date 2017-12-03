package SIMSserver.src.dataservice.billdataservice;

import java.util.Date;

import SIMSserver.src.dataenum.BillState;
import SIMSserver.src.dataenum.BillType;

public interface BillDataService {

	public Date getDate();
	public BillType getType();
	public BillState getState();

}
