package SIMSclient.src.dataservice.userdataservice;


import java.rmi.RemoteException;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.dataservice.CommonDataService;
import SIMSclient.src.po.UserPO;


public interface UserDataService extends CommonDataService<UserPO>{

	public static final String NAME = "UserData"; //rmi������
	public ResultMessage updateAdmin(String oldPass, String newPass) throws RemoteException;  //���Ĺ���Ա����
    public UserRole login() throws RemoteException;

}
