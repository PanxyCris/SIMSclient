package SIMSclient.src.bussinesslogic_mock.setupaccountbl_mock;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.bussinesslogic.setupaccountbl.SetUpAccountBL;
import SIMSclient.src.vo.AccountBookVO;

public class SetUpAccountBL_mock extends SetUpAccountBL{
	
	AccountBookVO accountBookVO;
	
	public SetUpAccountBL_mock() {

	}
	
	@Override
	public ResultMessage newBuild(AccountBookVO accountBookVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(AccountBookVO accountBookVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public AccountBookVO find() {
		return accountBookVO;
	}
}
