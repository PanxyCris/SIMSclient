package SIMSclient.src.bussinesslogic.userbl;

import java.util.ArrayList;

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

	public boolean login(String userName, String passWord) {
		return true;
	}

	public boolean judgeExist(String id){
		return true;
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

    @Override
	public UserVO delete(String info) {
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

	@Override
	public ArrayList<UserVO> getUserList() {
		UserVO user1 = new UserVO("0000001","���","161250058",UserRole.PUR_SALE_MANAGER);
		UserVO user2 =new UserVO("0000002","���Ӳ�","161250134",UserRole.FINANCIAL_MANAGER);
		ArrayList<UserVO> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		return list;
	}
    /**
     * ģ�����ң�������ֵ�����ϸ�ʽ���߸���Ϣ�����ڷ���null�������ڣ����ظ�UserVO
     */
	@Override
	public UserVO blurFind(String info) {
		// TODO Auto-generated method stub
		return vo;
	}



}
