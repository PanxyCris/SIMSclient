package SIMSclient.src.bussinesslogic.userbl;

import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.vo.UserVO;
import javafx.scene.image.ImageView;

public class UserBL implements UserBLService {

	UserVO vo;

	private static UserBL userBL = new UserBL();
	public static UserBL getInstance(){
		return userBL;
	}

	public UserBLService getUserService(){
		return (UserBLService)userBL;
	}

	public boolean judgeExist(String userName, String passWord) {
		return true;
	}

	public boolean judgeExist(String id){
		return false;
	}

	public boolean judgeLegal(UserVO vo){
		return true;
	}
	/**
	 * ��������һ�ж�Ϊ�漴Ϊ��
	 * @param id
	 * @param userName
	 * @return
	 */
	public boolean judgeLegal(String id,String userName){
		return true;
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
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
//
//	@Override
//	public Authority getAuthority() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ImageView getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserVO vo) {
		// TODO Auto-generated method stub

	}

    @Override
	public UserVO delete(String id, String name) {
		// TODO Auto-generated method stub
           return vo;
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



}
