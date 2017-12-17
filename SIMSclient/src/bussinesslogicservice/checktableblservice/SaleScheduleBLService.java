package bussinesslogicservice.checktableblservice;

import vo.tablevo.SaleScheduleVO;

public interface SaleScheduleBLService {

	public void viewReport(SaleScheduleVO saleScheduleVO);

	public void exportReport();

}
