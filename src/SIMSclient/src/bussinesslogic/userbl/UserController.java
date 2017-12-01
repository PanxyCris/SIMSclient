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
     * ��¼���û����������ж�
     */
	public boolean login(String userName, String passWord) {
		return true;
	}

	@Override
	public ResultMessage insert(UserVO vo) {
        return ResultMessage.SUCCESS;
	}
	/**
	 * ͨ��ģ�����ҷ�����Ҫɾ����vo,ͬʱ����delete����
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
		UserVO user1 = new UserVO("0000001","���","161250058",UserRole.PUR_SALE_MANAGER);
		UserVO user2 =new UserVO("0000002","���Ӳ�","161250134",UserRole.FINANCIAL_MANAGER);
		ArrayList<UserVO> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		return list;
	}




}
