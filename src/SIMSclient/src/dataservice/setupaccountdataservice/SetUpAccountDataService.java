package SIMSclient.src.dataservice.setupaccountdataservice;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.po.AccountBookPO;

public interface SetUpAccountDataService {
	
	public ResultMessage newBuild(AccountBookPO accountBookPO);//ÐÂ½¨
	
	public ResultMessage delete(AccountBookPO accountBookPO);//É¾³ý
	
	public AccountBookPO find();
}
