package SIMSclient.src.bussinesslogicservice.accountbookblservice;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountBookVO;

public interface AccountBookBLService {
	
	public ResultMessage newBuild(AccountBookVO accountBookVO);//�½�
	
	public ResultMessage delete(AccountBookVO accountBookVO);//ɾ��
	
	public AccountBookVO find();
	
}
