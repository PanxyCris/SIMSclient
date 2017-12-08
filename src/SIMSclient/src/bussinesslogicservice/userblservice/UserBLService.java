package SIMSclient.src.bussinesslogicservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.findtype.FindUserType;
import SIMSclient.src.vo.UserVO;

public interface UserBLService {

	public ArrayList<UserVO> find(String info,FindUserType properties) throws RemoteException;//info����Ϣ��properties������

	public ResultMessage insert(UserVO vo) throws RemoteException;

	public ResultMessage delete(UserVO vo) throws RemoteException;

	public ResultMessage update(UserVO vo) throws RemoteException;//�޸�

	public ArrayList<UserVO> getUserList() throws RemoteException;  //����һ�½ӿڣ�����һ���˻�list
	public boolean login(String userName, String passWord) throws RemoteException;


}
