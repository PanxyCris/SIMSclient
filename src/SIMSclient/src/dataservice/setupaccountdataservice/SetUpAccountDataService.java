package SIMSclient.src.dataservice.setupaccountdataservice;

import SIMSclient.src.po.AccountBookPO;

public interface SetUpAccountDataService {
	
	public void newBuild(AccountBookPO accountBookPO);//�½�
	
	public void delete(AccountBookPO accountBookPO);//ɾ��
	
	public AccountBookPO find();
}
