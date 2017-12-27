package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.findtype.FindSaleScheduleType;
import vo.billvo.purchasebillvo.PurchaseVO;

public class BussinessHistorySchedulePurchaseBL implements BusinessHistoryScheduleBLService<PurchaseVO> {

	@Override
	public ArrayList<PurchaseVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PurchaseVO> siftTime(LocalDate start, LocalDate end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PurchaseVO> sift(String info, FindSaleScheduleType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportReport(ArrayList<PurchaseVO> table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOff(ArrayList<PurchaseVO> table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOffAndCopy(ArrayList<PurchaseVO> table) {
		// TODO Auto-generated method stub
		
	}

}
