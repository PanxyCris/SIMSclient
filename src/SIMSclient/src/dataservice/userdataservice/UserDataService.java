package SIMSclient.src.dataservice.userdataservice;

import java.rmi.RemoteException;
import javafx.scene.image.ImageView;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.po.UserPO;

public interface UserDataService {

    public String getName();

    public int getID();

    public String getPassword();

    public UserRole getRole();

    //public Authority getAuthority();
    public ImageView getImage();

    public void insert(UserPO po) throws RemoteException;
	public void delelte(UserPO po) throws RemoteException;
	public void update(UserPO po) throws RemoteException;
	public void find(UserPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}
