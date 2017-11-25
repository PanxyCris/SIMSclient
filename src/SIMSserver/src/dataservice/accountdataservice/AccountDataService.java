package SIMSserver.src.dataservice.accountdataservice;

import java.rmi.RemoteException;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.AccountPO;

public interface AccountDataService {
	
	public AccountPO find(String message);//message是用户查找ID时输入的信息，经过逻辑处理后返回一个AccountVO对象
	
	public ResultMessage newBuild();//新建一个账户,返回一个AccountPO对象
	
	public ResultMessage delete(AccountPO accountPO);//删除
	
	public ResultMessage modify(String name);//修改
}
