package SIMSclient.src.bussinesslogicservice.userblservice;

import java.util.ArrayList;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.findtype.FindUserType;
import SIMSclient.src.vo.UserVO;

public interface UserBLService {

	public ArrayList<UserVO> find(String info,FindUserType properties);//info是信息，properties是属性

	public ResultMessage update(ArrayList<UserVO> list);//更新

	public ResultMessage modify(UserVO vo);//修改

	public ArrayList<UserVO> getUserList();  //改了一下接口，返回一个账户list
	public boolean login(String userName, String passWord);


}
