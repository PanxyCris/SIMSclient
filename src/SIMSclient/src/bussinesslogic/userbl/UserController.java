package SIMSclient.src.bussinesslogic.userbl;

import java.util.ArrayList;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.UserRole;
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
	public ResultMessage insert(UserVO vo) {
        return ResultMessage.SUCCESS;
	}
	/**
	 * 通过模糊查找返回需要删除的vo,同时进行delete操作
	 */
    @Override
	public ResultMessage delete(String info,String properties) {
		// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(UserVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<UserVO> find(String info,String properties) {
		// TODO Auto-generated method stub
        return list;
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
