package dataservice.memberdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.findtype.FindMemberType;
import dataservice.CommonDataService;
import po.MemberPO;


public interface MemberDataService extends CommonDataService<MemberPO>{

	public static final String NAME = "MemberData";  //rmi������
	
	/**
	 * 
	* @Title: find 
	* @Description: ����keyword, ѡ��������ͣ����в���, nullΪģ������
	* @param keyword
	* @param type
	* @throws RemoteException     
	* @return ArrayList<MemberPO>    
	 */
	public ArrayList<MemberPO> find(String keyword, FindMemberType type) throws RemoteException;

}
