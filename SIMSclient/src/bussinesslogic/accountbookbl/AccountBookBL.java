package bussinesslogic.accountbookbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.accountbookblservice.AccountBookBLService;
import dataenum.ResultMessage;
import dataservice.accountbookdataservice.AccountBookDataService;
import po.AccountBookPO;
import vo.accountbookvo.AccountBookVO;

public class AccountBookBL implements AccountBookBLService{

	AccountBookVO accountBookVO;
	AccountBookPO accountBookPO;
	
	AccountBookTransition accountBookTransition;
	AccountBookDataService accountBookDataService;
	
	@Override
	public ResultMessage newBuild(AccountBookVO accountBookVO) {
		accountBookPO=accountBookTransition.VOtoPO(accountBookVO);
		
		try {
			return accountBookDataService.insertAccountBook(accountBookPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(AccountBookVO accountBookVO) {
		String id=accountBookVO.getId();
		
		try {
			return accountBookDataService.deleteAccountBook(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<AccountBookVO> show() {
		
		ArrayList<AccountBookVO> accountBookVOs=new ArrayList<>();
		try {
			ArrayList<AccountBookPO> accountBookPOs=accountBookDataService.showAccountBook();
			for (int i = 0; i < accountBookPOs.size(); i++) {
				accountBookVOs.add(accountBookTransition.POtoVO(accountBookPOs.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return accountBookVOs;
	}

}
