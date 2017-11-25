package SIMSserver.src.dataservice.setupaccountdataservice;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.AccountBookPO;

public interface SetUpAccountDataService {
	
	public ResultMessage newBuild(AccountBookPO accountBookPO);//ÐÂ½¨
	
	public ResultMessage delete(AccountBookPO accountBookPO);//É¾³ý
	
	public AccountBookPO find();
}
