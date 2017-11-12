package SIMSclient.src.dataservice.setupaccountdataservice;

import SIMSclient.src.po.AccountBookPO;

public interface SetUpAccountDataService {
	
	public void newBuild(AccountBookPO accountBookPO);//ÐÂ½¨
	
	public void delete(AccountBookPO accountBookPO);//É¾³ý
	
	public AccountBookPO find();
}
