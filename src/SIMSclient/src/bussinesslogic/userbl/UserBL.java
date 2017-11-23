package SIMSclient.src.bussinesslogic.userbl;

import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.vo.UserVO;
import SIMSclient.src.vo.UserVO.Authority;
import SIMSclient.src.vo.UserVO.UserRole;
import javafx.scene.image.ImageView;

public class UserBL implements UserBLService {

	private static UserBL userBL = new UserBL();
	public static UserBL getInstance(){
		return userBL;
	}

	public UserBLService getUserService(){
		return (UserBLService)userBL;
	}

	public boolean judge(String userName, String passWord) {

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
		return UserRole.USERMANAGER;
	}

	@Override
	public Authority getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

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
	public void delelte(UserVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(UserVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void find(UserVO vo) {
		// TODO Auto-generated method stub

	}

}
