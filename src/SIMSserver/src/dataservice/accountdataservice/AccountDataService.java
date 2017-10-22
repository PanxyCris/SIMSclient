package SIMSserver.src.dataservice.accountdataservice;

import java.rmi.RemoteException;

import SIMSclient.src.po.AccountPO;

public interface AccountDataService {
	
public AccountPO check(String message)throws RemoteException;//message是用户查找ID时输入的信息，经过逻辑处理后返回一个AccountPO对象
	
	public AccountPO newBuild()throws RemoteException;//新建一个账户,返回一个AccountPO对象
	
	public boolean delete(AccountPO accountPO)throws RemoteException;//删除
	
	public boolean modify(String name)throws RemoteException;//修改
}
