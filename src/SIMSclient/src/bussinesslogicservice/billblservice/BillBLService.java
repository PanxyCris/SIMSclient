package SIMSclient.src.bussinesslogicservice.billblservice;

import java.util.Date;
import SIMSclient.src.vo.bill.BillVO.BillState;

public interface BillBLService {

	public int getID();
	public Date getDate();
	public BillState getState();
	public String getDescription();
}
