package SIMSclient.src.bussinesslogicservice.checktableblservice;

import SIMSclient.src.vo.BillVO;
import SIMSclient.src.vo.makefinancialdoc.FinancialDocVO;
import SIMSclient.src.vo.table.BusinessHistoryScheduleVO;

public interface businessHistoryScheduleBLService {

	public FinancialDocVO viewReport(BusinessHistoryScheduleVO businessHistoryScheduleVO);

	public void exportReport();

	public void writeOff();//���

	public void writeOffAndCopy(BillVO billVO);//��岢����

}
