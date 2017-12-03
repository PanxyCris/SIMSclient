package SIMSserver.src.dataservice.userdataservice;


import java.rmi.RemoteException;

import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataenum.UserRole;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.UserPO;

public interface UserDataService extends CommonDataService<UserPO>{

	public static final String NAME = "UserData"; //rmi的名称
	public ResultMessage updateAdmin(String oldPass, String newPass) throws RemoteException;  //更改管理员密码
	
    /**
     * 
    * @Title: login 
    * @Description: 验证登录信息
    * @param 之后看看应该传入的值
    * @param @throws RemoteException    
    * @return UserRole   
    * @throws
     */
    public UserRole login() throws RemoteException;

}
