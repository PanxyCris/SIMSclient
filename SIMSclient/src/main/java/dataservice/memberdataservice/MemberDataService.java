package dataservice.memberdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import po.MemberPO;

public interface MemberDataService extends Remote {

	public static final String NAME = "MemberData"; // rmi������

	public ArrayList<MemberPO> findMember(String keyword, FindMemberType type) throws RemoteException;

	public ResultMessage insertMember(MemberPO po) throws RemoteException;

	public ResultMessage deleteMember(String ID) throws RemoteException;

	public ResultMessage updateMember(MemberPO po) throws RemoteException;

	public ArrayList<MemberPO> showMember() throws RemoteException;
}
