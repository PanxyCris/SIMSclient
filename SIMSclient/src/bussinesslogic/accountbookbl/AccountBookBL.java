package bussinesslogic.accountbookbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.accountbookblservice.AccountBookBLService;
import dataenum.ResultMessage;
import dataservice.accountbookdataservice.AccountBookDataService;
import po.AccountBookPO;
import rmi.RemoteHelper;
import vo.accountbookvo.AccountBookVO;

public class AccountBookBL implements AccountBookBLService{

	private AccountBookVO accountBookVO;
	private AccountBookPO accountBookPO;

	private AccountBookTransition accountBookTransition;
	private AccountBookDataService accountBookDataService;

	public AccountBookBL() {
		accountBookTransition=new AccountBookTransition();
		accountBookDataService=RemoteHelper.getInstance().getSetUpAccountDataService();
	}
	@Override
	public ResultMessage newBuild(AccountBookVO accountBookVO) {
		String date=accountBookVO.getDate();
		ArrayList<AccountBookVO> accountBookVOs=show();
		for (int i = 0; i < accountBookVOs.size(); i++) {
			if(date.equals(accountBookVOs.get(i).getDate())){
				return ResultMessage.FAIL;
			}
		}
		accountBookPO=accountBookTransition.VOtoPO(accountBookVO);

		try {
			return accountBookDataService.insertAccountBook(accountBookPO);
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

	@Override
	public AccountBookVO choseByYear(int date) {
		String d=Integer.toString(date);
		ArrayList<AccountBookVO> accountBookVOs=show();
		for (int i = 0; i < accountBookVOs.size(); i++) {
			if(d.equals(accountBookVOs.get(i).getDate())){
				accountBookVO=accountBookVOs.get(i);
				break;
			}
		}
		return accountBookVO;
	}

}
