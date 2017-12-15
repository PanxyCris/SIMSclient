package bussinesslogicservice.accountblservice;

import java.util.ArrayList;

import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import vo.AccountVO;
import vo.FinancialBill.FinancialDocVO;

/**
 *
 * @author 王灿灿
 * @version 2017-12-1
 *
 */
public interface AccountBLService {

	public ArrayList<AccountVO> find(String message, FindAccountType findType);

	public ResultMessage add(AccountVO accountVO);

	public ResultMessage modify(AccountVO accountVO);

	public void delete(AccountVO accountVO);

	public ResultMessage judgeLegal(AccountVO accountVO);

	public ArrayList<AccountVO> getAccountList(); // 改了一下接口，返回一个账户list

	public ResultMessage enterItem(FinancialDocVO financialDocVO, BillType billType); // 收款单、付款单
																						// 入账

}
