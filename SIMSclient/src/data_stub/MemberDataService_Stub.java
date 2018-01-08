package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import dataservice.memberdataservice.MemberDataService;
import po.MemberPO;
import vo.membervo.MemberVO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年10月22日    
*/
public class MemberDataService_Stub implements MemberDataService {

	@Override
	public ArrayList<MemberPO> findMember(String keyword, FindMemberType type) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insertMember(MemberPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteMember(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateMember(MemberPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<MemberPO> showMember() throws RemoteException {
		return null;
	}

	
	
}
