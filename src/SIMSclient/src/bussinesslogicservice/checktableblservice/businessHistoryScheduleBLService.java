package SIMSclient.src.bussinesslogicservice.checktableblservice;

import SIMSclient.src.po.BillPO;
import SIMSclient.src.vo.table.BusinessHistoryScheduleVO;

public interface businessHistoryScheduleBLService {
	
	public void viewReport(BusinessHistoryScheduleVO businessHistoryScheduleVO);
	
	public void exportReport();
	
	public void writeOff();//ºì³å
	
	public void writeOffAndCopy(BillPO billPO);//ºì³å²¢¸´ÖÆ
	
}
