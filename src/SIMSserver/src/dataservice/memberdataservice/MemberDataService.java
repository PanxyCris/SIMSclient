package SIMSserver.src.dataservice.memberdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSserver.src.dataenum.FindMemberType;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.MemberPO;

public interface MemberDataService extends CommonDataService<MemberPO>{

	public static final String NAME = "MemberData";  //rmi������
	/**
	 * 
	* @Title: find 
	* @Description: ����keyword, ѡ��������ͣ�����ģ������
	* @param keyword
	* @param type
	* @throws RemoteException     
	* @return ArrayList<MemberPO>    
	 */
	public ArrayList<MemberPO> find(String keyword, FindMemberType type) throws RemoteException;

}
