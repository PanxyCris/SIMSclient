package bussinesslogicservice.accountblservice;

import java.util.ArrayList;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import vo.accountvo.AccountVO;

/**
 *
 * @author ���Ӳ�
 * @version 2017-12-1
 *
 */
public interface AccountBLService {

	public ArrayList<AccountVO> find(String message, FindAccountType findType);

	public ResultMessage add(AccountVO accountVO);

	public ResultMessage modify(AccountVO accountVO);

	public void delete(AccountVO accountVO);

	public ResultMessage judgeLegal(AccountVO accountVO);

	public ArrayList<AccountVO> getAccountList(); // ����һ�½ӿڣ�����һ���˻�list

}
