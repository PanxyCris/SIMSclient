package SIMSclient.src.bussinesslogicservice.userblservice;

import SIMSclient.src.enumeration.UserRole;
import SIMSclient.src.vo.UserVO;

public interface UserBLService {

    public String getName();

    public int getID();

    public String getPassword();

    public UserRole getRole();

    public void insert(UserVO vo);
	public void delelte(UserVO vo);
	public void update(UserVO vo);
	public void find(UserVO vo);
}
