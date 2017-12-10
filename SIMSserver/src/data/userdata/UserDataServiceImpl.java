package data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.userdata.UserData;
import dataenum.ResultMessage;
import dataenum.UserRole;
import dataenum.findtype.FindUserType;
import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataServiceImpl implements UserDataService {

	private UserData user;
	
	public UserDataServiceImpl() throws RemoteException {
		super();
	}
	
	public static void main(String[] args) throws RemoteException {
		UserDataServiceImpl u = new UserDataServiceImpl();
		UserPO p = new UserPO("000002", "wangcancan", "admin", UserRole.PUR_SALE_MANAGER, null);
		u.insertUser(p);
		ArrayList<UserPO> list = u.showUser();
		for(UserPO po: list) {
			System.out.println(po.toString());
			if ("000001".equals(String.valueOf(po.getID())) && "admin".equals(String.valueOf(po.getPassword()))){
				System.out.println("true");
			}
		}
		System.out.println(u.login("000001", "admin"));
	}

	@Override
	public ResultMessage insertUser(UserPO po) throws RemoteException {
		user = new UserData();
		return user.insert(po);
	}

	@Override
	public ResultMessage deleteUser(String ID) throws RemoteException {
		user = new UserData();
		return user.delete(ID);
	}

	@Override
	public ResultMessage updateUser(UserPO po) throws RemoteException {
		user = new UserData();
		return user.update(po);
	}

	@Override
	public ArrayList<UserPO> showUser() throws RemoteException {
		user = new UserData();
		return user.show();
	}


	@Override
	public boolean login(String id, String password) throws RemoteException {
		user = new UserData();
		ArrayList<UserPO> list = user.show();
		for (UserPO po: list) {
			if (id.equals(String.valueOf(po.getID())) && password.equals(String.valueOf(po.getPassword()))){
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<UserPO> findUser(String info, FindUserType type) throws RemoteException {
		user = new UserData();
		return user.find(info, type);
	}


	

	
}
