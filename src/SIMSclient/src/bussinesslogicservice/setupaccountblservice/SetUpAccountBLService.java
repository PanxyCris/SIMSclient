package SIMSclient.src.bussinesslogicservice.setupaccountblservice;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountBookVO;

public interface SetUpAccountBLService {
	
	public ResultMessage newBuild(AccountBookVO accountBookVO);//�½�
	
	public ResultMessage delete(AccountBookVO accountBookVO);//ɾ��
	
	public AccountBookVO find();
	
}
