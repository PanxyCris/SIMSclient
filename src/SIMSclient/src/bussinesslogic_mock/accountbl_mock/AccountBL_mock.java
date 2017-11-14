package SIMSclient.src.bussinesslogic_mock.accountbl_mock;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.bussinesslogic.accountbl.AccountBL;
import SIMSclient.src.vo.AccountVO;

public class AccountBL_mock extends AccountBL{
	
	AccountVO accountVO;
	
	public AccountBL_mock(){
		
	}
	
	@Override
	public AccountVO find(String message) {
		return accountVO;
	}

	@Override
	public ResultMessage newBuild() {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(AccountVO accountVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(String name) {
		return ResultMessage.SUCCESS;
	}
}
