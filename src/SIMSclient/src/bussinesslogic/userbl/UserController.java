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
     * µ«¬ºµƒ”√ªß√˚º∞√‹¬Î≈–∂œ
     */
	public boolean login(String userName, String passWord) {
		return true;
	}


    @Override
	public ResultMessage insert(UserVO vo) {
		// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
	}

    @Override
   	public ResultMessage delete(UserVO vo) {
   		// TODO Auto-generated method stub
       	return ResultMessage.SUCCESS;
   	}

	@Override
	public ResultMessage update(UserVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<UserVO> find(String info,FindUserType properties) {
		UserVO user1 = new UserVO("0000002","Õı≤”≤”","161250134",UserRole.USER_MANAGER);
		ArrayList<UserVO> userList = new ArrayList<>();
		userList.add(user1);
		return userList;
	}

	@Override
	public ArrayList<UserVO> getUserList() {
		UserVO user1 = new UserVO("0000001","¿ÓΩ‹","161250058",UserRole.PUR_SALE_MANAGER);
		UserVO user2 =new UserVO("0000002","Õı≤”≤”","161250134",UserRole.FINANCIAL_MANAGER);
		UserVO user3 =new UserVO("0000003","ÀÔºŒΩ‹","161250122",UserRole.GENERAL_MANAGER);
		UserVO user4 =new UserVO("0000004","≈À–«”Ó","161250095",UserRole.INVENTORY_MANAGER);
		ArrayList<UserVO> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		return list;
	}




}
