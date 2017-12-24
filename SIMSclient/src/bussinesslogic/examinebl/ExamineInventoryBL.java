package bussinesslogic.examinebl;

import java.util.ArrayList;

import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import po.inventorybillpo.InventoryBillPO;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;

public class ExamineInventoryBL implements ExamineBLService<InventoryBillVO>{

	@Override
	public ResultMessage updateBill(InventoryBillVO vo) {

		return null;
	}

	@Override
	public ResultMessage passBills(ArrayList<InventoryBillVO> vos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<InventoryBillVO> vos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> getCommitedBills() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> find(String info, FindBillType type) {
		// TODO Auto-generated method stub
		return null;
	}


}
