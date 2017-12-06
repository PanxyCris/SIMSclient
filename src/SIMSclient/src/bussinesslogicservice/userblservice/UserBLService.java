package SIMSclient.src.bussinesslogicservice.userblservice;

import java.util.ArrayList;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.findtype.FindUserType;
import SIMSclient.src.vo.UserVO;

public interface UserBLService {

	public ArrayList<UserVO> find(String info,FindUserType properties);//info����Ϣ��properties������

	public ResultMessage insert(UserVO vo);

	public ResultMessage delete(UserVO vo);

	public ResultMessage update(UserVO vo);//�޸�

	public ArrayList<UserVO> getUserList();  //����һ�½ӿڣ�����һ���˻�list
	public boolean login(String userName, String passWord);


}
