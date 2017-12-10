package bussinesslogicservice.checktableblservice;

import vo.ViewObject;
import vo.makefinancialdoc.FinancialDocVO;
import vo.table.BusinessHistoryScheduleVO;

public interface businessHistoryScheduleBLService {

	public FinancialDocVO viewReport(BusinessHistoryScheduleVO businessHistoryScheduleVO);

	public void exportReport();

	public void writeOff();//ºì³å

	public void writeOffAndCopy(ViewObject billVO);//ºì³å²¢¸´ÖÆ

}
