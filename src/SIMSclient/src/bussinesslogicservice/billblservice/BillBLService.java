package SIMSclient.src.bussinesslogicservice.billblservice;

import java.util.Date;

import SIMSclient.src.vo.BillVO.BillState;

import SIMSclient.src.vo.BillVO.BillType;

public interface BillBLService {

	public Date getDate();
	public BillType getType();
	public BillState getState();
}
