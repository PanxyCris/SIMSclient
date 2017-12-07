package SIMSserver.src.data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataenum.UserRole;
import SIMSserver.src.dataservice.userdataservice.UserDataService;
import SIMSserver.src.po.UserPO;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService {

	public UserDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage insert(UserPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<UserPO> show() throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage createTable() throws RemoteException {
		return null;
	}

	@Override
	public void init() throws RemoteException {
	}

	@Override
	public String getID() throws RemoteException {
		return null;
	}

	@Override
	public UserPO find(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateAdmin(String oldPass, String newPass) throws RemoteException {
		return null;
	}

	@Override
	public UserRole login() throws RemoteException {
		return null;
	}

}
