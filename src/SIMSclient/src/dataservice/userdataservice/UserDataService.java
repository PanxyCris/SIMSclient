package SIMSclient.src.dataservice.userdataservice;


import java.rmi.RemoteException;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.dataservice.CommonDataService;
import SIMSclient.src.po.UserPO;


public interface UserDataService extends CommonDataService<UserPO>{

	public static final String NAME = "UserData"; //rmi的名称
	public ResultMessage updateAdmin(String oldPass, String newPass) throws RemoteException;  //更改管理员密码
    public UserRole login() throws RemoteException;

}
