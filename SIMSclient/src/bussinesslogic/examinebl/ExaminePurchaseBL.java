package bussinesslogic.examinebl;

import java.util.ArrayList;

import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import vo.billvo.purchasebillvo.PurchaseVO;

public class ExaminePurchaseBL implements ExamineBLService<PurchaseVO>{

	@Override
	public ResultMessage updateBill(PurchaseVO vo, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage passBills(ArrayList<PurchaseVO> vos, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<PurchaseVO> vos, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PurchaseVO> getCommitedBills() {
		// TODO Auto-generated method stub
		return null;
	}

}
