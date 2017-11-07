package SIMSclient.src.bussinesslogicservice.billblservice;

import java.util.Date;


public interface BillBLService {

	public int getID();
	public Date getDate();
	public SIMSclient.src.vo.bill.BillVO.BillState getState();
	public String getDescription();
}
