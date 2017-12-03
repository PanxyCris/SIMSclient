package SIMSserver.src.dataservice.userdataservice;


import java.rmi.RemoteException;

import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataenum.UserRole;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.UserPO;

public interface UserDataService extends CommonDataService<UserPO>{

	public static final String NAME = "UserData"; //rmi������
	public ResultMessage updateAdmin(String oldPass, String newPass) throws RemoteException;  //���Ĺ���Ա����
	
    /**
     * 
    * @Title: login 
    * @Description: ��֤��¼��Ϣ
    * @param ֮�󿴿�Ӧ�ô����ֵ
    * @param @throws RemoteException    
    * @return UserRole   
    * @throws
     */
    public UserRole login() throws RemoteException;

}
