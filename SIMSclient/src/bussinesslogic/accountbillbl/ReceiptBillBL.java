package bussinesslogic.accountbillbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import bussinesslogicservice.accountblservice.AccountBLService;
import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataservice.accountbilldataservice.ReceiptBillDataService;
import po.FinancialBill.ReceiptBillPO;
import vo.accountvo.AccountVO;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class ReceiptBillBL implements ReceiptBillBLService{

	ReceiptBillVO receiptBillVO;
	ReceiptBillPO receiptBillPO;
	
	ReceiptBillTransition receiptBillTransition;
	ReceiptBillDataService receiptBillDataService;
	
	AccountBLService accountBLService;
	MemberBLService memberBLService;

	@Override
	public ResultMessage save(ReceiptBillVO receiptBillVO) {
		receiptBillPO=receiptBillTransition.VOtoPO(receiptBillVO);
		
		try {
			return receiptBillDataService.insertReceiptBill(receiptBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(ReceiptBillVO receiptBillVO) {
		String id=receiptBillVO.getId();
		try {
			return receiptBillDataService.deleteReceiptBill(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<ReceiptBillVO> show() {
		ArrayList<ReceiptBillVO> aBillVOs=new ArrayList<>();
		try {
			ArrayList<ReceiptBillPO> aBillPOs=receiptBillDataService.showReceiptBill();
			for (int i = 0; i < aBillPOs.size(); i++) {
				receiptBillVO=receiptBillTransition.POtoVO(aBillPOs.get(i));
				aBillVOs.add(receiptBillVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return aBillVOs;
	}

	@Override
	public ArrayList<ReceiptBillVO> find(String info, FindAccountBillType type) {
		ArrayList<ReceiptBillVO> aBillVOs=new ArrayList<>();
		try {
			ArrayList<ReceiptBillPO> aBillPOs=receiptBillDataService.findReceiptBill(info, type);
			for (int i = 0; i < aBillPOs.size(); i++) {
				receiptBillVO=receiptBillTransition.POtoVO(aBillPOs.get(i));
				aBillVOs.add(receiptBillVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return aBillVOs;
	}

	@Override
	public ArrayList<String> getAccountList() {
		ArrayList<String> list=new ArrayList<>();
 		ArrayList<AccountVO> accountVOs=accountBLService.getAccountList();
		String a="";
		for (int i = 0; i < accountVOs.size(); i++) {
			a=accountVOs.get(i).getId()+" "+accountVOs.get(i).getName();
			list.add(a);
		}
		return list;
	}

	@Override
	public ArrayList<String> getCustomerList() {
		ArrayList<String> list = null;
		try {
		 list=memberBLService.getIDandName();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ResultMessage commit(ReceiptBillVO receiptBillVO) {
		receiptBillVO.setState(BillState.COMMITED);
		receiptBillPO=receiptBillTransition.VOtoPO(receiptBillVO);
		try {
			return receiptBillDataService.updateReceiptBill(receiptBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}


}
