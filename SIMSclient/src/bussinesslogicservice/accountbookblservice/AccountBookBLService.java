package bussinesslogicservice.accountbookblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import vo.accountbookvo.AccountBookVO;

public interface AccountBookBLService {

	public ResultMessage newBuild(AccountBookVO accountBookVO);//�½�

	public ResultMessage delete(AccountBookVO accountBookVO);//ɾ��

	public ArrayList<AccountBookVO> show();
	
	public AccountBookVO choseByYear(int date);

}
