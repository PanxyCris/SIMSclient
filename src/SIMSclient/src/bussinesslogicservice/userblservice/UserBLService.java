package SIMSclient.src.bussinesslogicservice.userblservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.UserVO;

public interface UserBLService {

	public ArrayList<UserVO> find(String info,String properties);//info是信息，properties是属性

	public ResultMessage insert(UserVO vo);//新建一个用户

	public ResultMessage delete(UserVO vo);//删除

	public ResultMessage update(UserVO vo);//修改

	public ArrayList<UserVO> getUserList();  //改了一下接口，返回一个账户list
	public boolean login(String userName, String passWord);


}
