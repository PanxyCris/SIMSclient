package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.findtype.FindSaleScheduleType;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class BusinessHistoryScheduleInventoryBL implements BusinessHistoryScheduleBLService<InventoryBillVO> {

	@Override
	public ArrayList<InventoryBillVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> siftTime(LocalDate start, LocalDate end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> sift(String info, FindSaleScheduleType type) {
		/*
		 这个方法不写
		 */
		return null;
	}

	@Override
	public void exportReport(ArrayList<InventoryBillVO> table) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeOff(ArrayList<InventoryBillVO> table) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeOffAndCopy(ArrayList<InventoryBillVO> table) {
		// TODO Auto-generated method stub

	}

}
