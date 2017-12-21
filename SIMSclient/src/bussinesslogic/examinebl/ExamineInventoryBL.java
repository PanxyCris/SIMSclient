package bussinesslogic.examinebl;

import java.util.ArrayList;

import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class ExamineInventoryBL implements ExamineBLService<InventoryBillVO>{

	@Override
	public ResultMessage updateBill(InventoryBillVO vo, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage passBills(ArrayList<InventoryBillVO> vos, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<InventoryBillVO> vos, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> getCommitedBills() {
		// TODO Auto-generated method stub
		return null;
	}

}
