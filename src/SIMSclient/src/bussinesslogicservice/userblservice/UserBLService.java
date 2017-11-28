package SIMSclient.src.bussinesslogicservice.userblservice;


import javafx.scene.image.ImageView;

import java.util.ArrayList;

import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.vo.UserVO;

public interface UserBLService {

    public String getName();

    public int getID();

    public String getPassword();

    public UserRole getRole();

    public ImageView getImage();

    public void insert(UserVO vo);
    public UserVO delete(String info);
	public void update(UserVO vo);
	public boolean find(UserVO vo);
	public UserVO find(String id,String name);

	public boolean login(String userName, String passWord);
	public boolean judgeExist(String id);
	public boolean judgeLegal(UserVO vo);
	public boolean judgeLegal(String info);

	public ArrayList<UserVO> getUserList();

}
