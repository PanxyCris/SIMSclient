package SIMSclient.src.bussinesslogicservice.userblservice;


import javafx.scene.image.ImageView;

import java.util.ArrayList;

import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.vo.UserVO;

public interface UserBLService {

    public String getName();

    public String getID();

    public String getPassword();

    public UserRole getRole();

    public ImageView getImage();

    public void insert(UserVO vo);
    public void delete(UserVO vo);
	public void update(UserVO vo);
	public boolean find(UserVO vo);
	public UserVO find(String id,String name);
	public ArrayList<UserVO> blurFind(String info,String properties);

	public boolean login(String userName, String passWord);
	public boolean judgeExist(String id);
	public boolean judgeLegal(UserVO vo);
	public boolean judgeLegal(String info);

	public ArrayList<UserVO> getUserList();

}
