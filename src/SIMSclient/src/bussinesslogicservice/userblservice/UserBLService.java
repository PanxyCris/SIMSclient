package SIMSclient.src.bussinesslogicservice.userblservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.UserVO;

public interface UserBLService {

	public ArrayList<UserVO> find(String info,String properties);//info����Ϣ��properties������

	public ResultMessage insert(UserVO vo);//�½�һ���û�

	public ResultMessage delete(UserVO vo);//ɾ��

	public ResultMessage update(UserVO vo);//�޸�

	public ArrayList<UserVO> getUserList();  //����һ�½ӿڣ�����һ���˻�list
	public boolean login(String userName, String passWord);


}
