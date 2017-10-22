package SIMSclient.src.bussinesslogicservice.checktableblservice;

import SIMSclient.src.po.BillPO;
import SIMSclient.src.po.table.BusinessHistorySchedulePO;
import SIMSclient.src.vo.bill.BillType;

public interface businessHistoryScheduleBLService {
	
	public BusinessHistorySchedulePO viewReport();
	
	public void exportReport();
	
	public void writeOff();//ºì³å
	
	public BillPO writeOffAndCopy(BillPO billPO);//ºì³å²¢¸´ÖÆ
	
}
