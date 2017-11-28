package SIMSclient.src.dataservice.userdataservice;

import java.rmi.RemoteException;
import javafx.scene.image.ImageView;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.dataservice.DataService;
import SIMSclient.src.po.UserPO;

public interface UserDataService extends DataService<UserPO>{
	
	public static final String NAME = "UserData";  //RMI绑定时候的名称

    public String getName() throws RemoteException;


    public String getPassword() throws RemoteException;

    public UserRole getRole() throws RemoteException;

    public ImageView getImage() throws RemoteException;

	public void finish() throws RemoteException;
}
