package bussinesslogicservice.accountbookblservice;

import dataenum.ResultMessage;
import vo.AccountBookVO;

public interface AccountBookBLService {
	
	public ResultMessage newBuild(AccountBookVO accountBookVO);//�½�
	
	public ResultMessage delete(AccountBookVO accountBookVO);//ɾ��
	
	public AccountBookVO find();
	
}
