package SIMSclient.src.bussinesslogicservice.checktableblservice;

import SIMSclient.src.po.BillPO;
import SIMSclient.src.vo.table.BusinessHistoryScheduleVO;

public interface businessHistoryScheduleBLService {
	
	public void viewReport(BusinessHistoryScheduleVO businessHistoryScheduleVO);
	
	public void exportReport();
	
	public void writeOff();//���
	
	public void writeOffAndCopy(BillPO billPO);//��岢����
	
}
