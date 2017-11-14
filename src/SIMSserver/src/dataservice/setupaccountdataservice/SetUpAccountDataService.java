package SIMSserver.src.dataservice.setupaccountdataservice;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.po.AccountBookPO;
import SIMSclient.src.vo.AccountBookVO;

public interface SetUpAccountDataService {
	
	public ResultMessage newBuild(AccountBookPO accountBookPO);//ÐÂ½¨
	
	public ResultMessage delete(AccountBookPO accountBookPO);//É¾³ý
	
	public AccountBookPO find();
}
