package SIMSclient.src.bussinesslogic.userbl;

import java.rmi.RemoteException;

import java.util.ArrayList;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.findtype.FindUserType;
import SIMSclient.src.dataservice.userdataservice.UserDataService;
import SIMSclient.src.po.UserPO;
import SIMSclient.src.rmi.RemoteHelper;
import SIMSclient.src.vo.UserVO;

public class UserController implements UserBLService{

	UserDataService service = RemoteHelper.getInstance().getuserDataService();

	private static UserController userController = new UserController();
	public static UserController getInstance(){
		return userController;
	}

	public UserBLService getUserService(){
		return (UserBLService)userController;
	}
    /**
     * 登录的用户名及密码判断
     * @throws RemoteException
     */
	public boolean login(String userName, String passWord) throws RemoteException {
		return service.login(userName,passWord);
	}


    @Override
	public ResultMessage insert(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
    	return service.insert(voTopo(vo));
	}

    @Override
   	public ResultMessage delete(UserVO vo) throws RemoteException {
   		// TODO Auto-generated method stub
       	return service.delete(vo.getID());
   	}

	@Override
	public ResultMessage update(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.update(voTopo(vo));
	}

	@Override
	public ArrayList<UserVO> find(String info,FindUserType properties) throws RemoteException {
		ArrayList<UserVO> voList = new ArrayList<>();
		ArrayList<UserPO> poList = service.find(info, properties);
		for(int i=0;i<poList.size();i++)
			voList.add(poTovo(poList.get(i)));
		return voList;
	}

	@Override
	public ArrayList<UserVO> getUserList() throws RemoteException {
		ArrayList<UserVO> voList = new ArrayList<>();
		ArrayList<UserPO> poList = service.show();
		for(int i=0;i<poList.size();i++)
			voList.add(poTovo(poList.get(i)));
		return voList;
	}

	public UserPO voTopo(UserVO vo){
		UserPO po = new UserPO(vo.getID(),vo.getName(),vo.getPassword(),vo.getRole(),vo.getImage());
		return po;

	}

	public UserVO poTovo(UserPO po){
		UserVO vo = new UserVO(po.getID(),po.getName(),po.getPassword(),po.getRole(),po.getImage());
		return vo;

	}



}
