package SIMSserver.src.dataservice.setupaccountdataservice;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.po.AccountBookPO;
import SIMSclient.src.vo.AccountBookVO;

public interface SetUpAccountDataService {
	
	public ResultMessage newBuild(AccountBookPO accountBookPO);//�½�
	
	public ResultMessage delete(AccountBookPO accountBookPO);//ɾ��
	
	public AccountBookPO find();
}
