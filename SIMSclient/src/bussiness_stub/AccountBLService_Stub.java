package bussiness_stub;

import java.util.ArrayList;

import bussinesslogicservice.accountblservice.AccountBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import vo.AccountVO;
import vo.FinancialBill.FinancialDocVO;

public class AccountBLService_Stub implements AccountBLService {

	@Override
	public ArrayList<AccountVO> find(String message, FindAccountType findType) {
		ArrayList<AccountVO> list = new ArrayList<>();
		AccountVO account1 = new AccountVO("00001","cancan","20000");
		list.add(account1);
		return list;
	}

	@Override
	public ResultMessage add(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void delete(AccountVO accountVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage judgeLegal(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<AccountVO> getAccountList() {
		ArrayList<AccountVO> list = new ArrayList<>();
		AccountVO account1 = new AccountVO("00001","cancan","20000");
		AccountVO account2 = new AccountVO("00002","lijie","50000");
		list.add(account1);
		list.add(account2);
		return list;
	}

	@Override
	public ResultMessage enterItem(FinancialDocVO financialDocVO, BillType billType) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}