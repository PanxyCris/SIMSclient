package SIMSclient.src.bussinesslogic.userbl;

import java.util.ArrayList;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.dataenum.findtype.FindUserType;
import SIMSclient.src.vo.UserVO;

public class UserController implements UserBLService{

	UserVO vo;
	ArrayList<UserVO> list;

	private static UserController userController = new UserController();
	public static UserController getInstance(){
		return userController;
	}

	public UserBLService getUserService(){
		return (UserBLService)userController;
	}
    /**
     * 登录的用户名及密码判断
     */
	public boolean login(String userName, String passWord) {
		return true;
	}


    @Override
	public ResultMessage modify(UserVO vo) {
		// TODO Auto-generated method stub
    	return ResultMessage.ILLEAGLINPUTDATA;
	}

	@Override
	public ResultMessage update(ArrayList<UserVO> list) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<UserVO> find(String info,FindUserType properties) {
		UserVO user1 = new UserVO("0000002","王灿灿","161250134",UserRole.USER_MANAGER);
		ArrayList<UserVO> userList = new ArrayList<>();
		userList.add(user1);
		return userList;
	}

	@Override
	public ArrayList<UserVO> getUserList() {
		UserVO user1 = new UserVO("0000001","李杰","161250058",UserRole.PUR_SALE_MANAGER);
		UserVO user2 =new UserVO("0000002","王灿灿","161250134",UserRole.FINANCIAL_MANAGER);
		ArrayList<UserVO> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		return list;
	}




}
