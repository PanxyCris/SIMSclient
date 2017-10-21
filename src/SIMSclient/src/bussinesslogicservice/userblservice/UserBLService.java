package SIMSclient.src.bussinesslogicservice.userblservice;

import SIMSclient.src.UserRole;

public interface UserBLService {

    public String getName();

    public int getID();

    public String getPassword();

    public UserRole getRole();
}
