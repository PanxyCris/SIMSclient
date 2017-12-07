package SIMSserver.src.data.memberdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataenum.findtype.FindMemberType;
import SIMSserver.src.dataservice.memberdataservice.MemberDataService;
import SIMSserver.src.po.MemberPO;

public class MemberDataServiceImpl extends UnicastRemoteObject implements MemberDataService {
	private MemberData member;

	protected MemberDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage insert(MemberPO po) throws RemoteException {
		member.insert(po);
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		member.delete(ID);
		return null;
	}

	@Override
	public ResultMessage update(MemberPO po) throws RemoteException {
		member.update(po);
		return null;
	}

	@Override
	public MemberPO find(String ID) throws RemoteException {
		return member.find(ID);
	}
	
	@Override
	public ArrayList<MemberPO> show() throws RemoteException {
		return member.show();
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
	public ArrayList<MemberPO> find(String keyword, FindMemberType type) throws RemoteException {
		return null;
	}

}
