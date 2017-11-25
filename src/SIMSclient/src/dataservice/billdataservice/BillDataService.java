package SIMSclient.src.dataservice.billdataservice;

import java.util.Date;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;

public interface BillDataService {

    public int getID();
	public BillType getType();
	public BillState getState();
	public Date getDate();
	public String getDescription();

}
