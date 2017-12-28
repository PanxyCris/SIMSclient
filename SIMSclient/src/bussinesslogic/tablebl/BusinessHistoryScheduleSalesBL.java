package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.findtype.FindSaleScheduleType;
import vo.billvo.salesbillvo.SalesVO;

public class BusinessHistoryScheduleSalesBL implements BusinessHistoryScheduleBLService<SalesVO> {

	@Override
	public ArrayList<SalesVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SalesVO> siftTime(LocalDate start, LocalDate end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SalesVO> sift(String info, FindSaleScheduleType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportReport(ArrayList<SalesVO> table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOff(ArrayList<SalesVO> table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOffAndCopy(ArrayList<SalesVO> table) {
		// TODO Auto-generated method stub
		
	}

}
