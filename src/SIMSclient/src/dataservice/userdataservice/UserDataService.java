package SIMSclient.src.dataservice.userdataservice;


import java.rmi.RemoteException;
import java.util.ArrayList;
import SIMSclient.src.dataenum.findtype.FindUserType;
import SIMSclient.src.dataservice.CommonDataService;
import SIMSclient.src.po.UserPO;


public interface UserDataService extends CommonDataService<UserPO>{

	public static final String NAME = "UserData"; //rmiµÄÃû³Æ
    public boolean login(String username,String password) throws RemoteException;
    public ArrayList<UserPO> find(String info,FindUserType type) throws RemoteException;

}
