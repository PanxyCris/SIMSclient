package SIMSclient.src.bussinesslogicservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.findtype.FindUserType;
import SIMSclient.src.vo.UserVO;

public interface UserBLService {

	public ArrayList<UserVO> find(String info,FindUserType properties) throws RemoteException;//info是信息，properties是属性

	public ResultMessage insert(UserVO vo) throws RemoteException;

	public ResultMessage delete(UserVO vo) throws RemoteException;

	public ResultMessage update(UserVO vo) throws RemoteException;//修改

	public ArrayList<UserVO> getUserList() throws RemoteException;  //改了一下接口，返回一个账户list
	public boolean login(String userName, String passWord) throws RemoteException;


}
