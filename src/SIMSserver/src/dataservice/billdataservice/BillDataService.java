package SIMSserver.src.dataservice.billdataservice;

import java.util.Date;

import SIMSserver.src.po.BillPO.BillState;

import SIMSserver.src.po.BillPO.BillType;

public interface BillDataService {

	public Date getDate();
	public BillType getType();
	public BillState getState();

}
