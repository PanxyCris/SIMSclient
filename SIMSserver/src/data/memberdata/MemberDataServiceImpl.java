package data.memberdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import dataservice.memberdataservice.MemberDataService;
import po.MemberPO;


public class MemberDataServiceImpl implements MemberDataService {
	
	private MemberData member;

	@Override
	public ResultMessage insertMember(MemberPO po) throws RemoteException {
		member = new MemberData();
		return member.insert(po);
	}

	@Override
	public ResultMessage deleteMember(String ID) throws RemoteException {
		member = new MemberData();
		return member.delete(ID);
	}

	@Override
	public ResultMessage updateMember(MemberPO po) throws RemoteException {
		member = new MemberData();
		return member.update(po);
	}

	
	@Override
	public ArrayList<MemberPO> showMember() throws RemoteException {
		member = new MemberData();
		return member.show();
	}


	@Override
	public ArrayList<MemberPO> findMember(String keyword, FindMemberType type) throws RemoteException {
		member = new MemberData();
		return member.find(keyword, type);
	}

}
