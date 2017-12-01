package SIMSclient.src.bussinesslogic.userbl;

import java.util.ArrayList;

import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.vo.UserVO;
import javafx.scene.image.ImageView;

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
	/**
	 *
	 */

	public boolean judgeExist(String id){
		return false;
	}
	/**
	 * 判断该vo的信息是否都合法
	 */

	public boolean judgeLegal(UserVO vo){
		return true;
	}
	/**
	 * 两者择其一判断为真即为真
	 * @param id
	 * @param userName
	 * @return
	 */
	public boolean judgeLegal(String info){
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole getRole() {
		// TODO Auto-generated method stub
		return UserRole.USER_MANAGER;
	}

	@Override
	public ImageView getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserVO vo) {
        System.out.println("Success!");
	}
	/**
     * 模糊查找，若输入值不符合格式或者该信息不存在返回null，若存在，返回该UserVO
     */
	@Override
	public ArrayList<UserVO> blurFind(String info,String properties) {
		// TODO Auto-generated method stub
		return list;
	}
	/**
	 * 通过模糊查找返回需要删除的vo,同时进行delete操作
	 */
    @Override
	public void delete(UserVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(UserVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserVO find(String id,String name) {
		// TODO Auto-generated method stub
        return vo;
	}

	@Override
	public boolean find(UserVO vo) {
		// TODO Auto-generated method stub
		return true;
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
