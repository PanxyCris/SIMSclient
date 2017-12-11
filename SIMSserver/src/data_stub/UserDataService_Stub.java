package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindUserType;
import dataservice.userdataservice.UserDataService;
import po.UserPO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ11ÈÕ    
*/
public class UserDataService_Stub implements UserDataService{

	@Override
	public boolean login(String id, String password) throws RemoteException {
		return false;
	}

	@Override
	public ArrayList<UserPO> findUser(String info, FindUserType type) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insertUser(UserPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteUser(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateUser(UserPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<UserPO> showUser() throws RemoteException {
		return null;
	}

}
