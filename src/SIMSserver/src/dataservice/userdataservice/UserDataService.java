package SIMSserver.src.dataservice.userdataservice;

import SIMSclient.src.UserRole;

public interface UserDataService {

    public String getName();

    public int getID();

    public String getPassword();

    public UserRole getRole();
}
