package SIMSclient.src.dataservice.billdataservice;

import java.util.Date;

import SIMSclient.src.po.BillPO.BillState;
import SIMSclient.src.po.BillPO.BillType;

public interface BillDataService {

    public int getID();
	public BillType getType();
	public BillState getState();
	public Date getDate();
	public String getDescription();

}
