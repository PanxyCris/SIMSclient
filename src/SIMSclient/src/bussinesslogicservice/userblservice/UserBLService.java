package SIMSclient.src.bussinesslogicservice.userblservice;

import java.util.ArrayList;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.findtype.FindUserType;
import SIMSclient.src.vo.UserVO;

public interface UserBLService {

	public ArrayList<UserVO> find(String info,FindUserType properties);//info����Ϣ��properties������

	public ResultMessage update(ArrayList<UserVO> list);//����

	public ResultMessage modify(UserVO vo);//�޸�

	public ArrayList<UserVO> getUserList();  //����һ�½ӿڣ�����һ���˻�list
	public boolean login(String userName, String passWord);


}
