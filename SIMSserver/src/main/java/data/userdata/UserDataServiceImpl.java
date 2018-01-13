package data.userdata;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.DBManager;
import data.userdata.UserData;
import dataenum.ResultMessage;
import dataenum.findtype.FindUserType;
import dataservice.userdataservice.UserDataService;
import po.userpo.UserPO;

public class UserDataServiceImpl implements UserDataService {

	private UserData user;

	public UserDataServiceImpl() throws RemoteException {
		super();
		user = new UserData();
	}

	public static void main(String[] args) throws RemoteException {
		UserDataServiceImpl u = new UserDataServiceImpl();
		// u.insertUser(p);
		// ArrayList<UserPO> list = u.findUser("000004", FindUserType.ID);
		// for(UserPO po: list) {
		// System.out.println(po.toString());
		// }
		System.out.println(u.login("000002", "admin"));
	}

	@Override
	public ResultMessage insertUser(UserPO po) throws RemoteException {
		return user.insert(po);
	}

	@Override
	public ResultMessage deleteUser(String ID) throws RemoteException {
		return user.delete(ID);
	}

	@Override
	public ResultMessage updateUser(UserPO po) throws RemoteException {
		return user.update(po);
	}

	@Override
	public ArrayList<UserPO> showUser() throws RemoteException {
		return user.show();
	}

	@Override
	public boolean login(String id, String password) throws RemoteException {
		ArrayList<UserPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from userrole";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object"); // ��ȡblob����
				InputStream is = inBlob.getBinaryStream(); // ��ȡ������������
				BufferedInputStream bis = new BufferedInputStream(is); // ����������������
				byte[] buff = new byte[(int) inBlob.length()];

				while (-1 != (bis.read(buff, 0, buff.length))) { // һ����ȫ������buff��
					ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
					UserPO po = (UserPO) in.readObject(); // ��������

					list.add(po);
				}
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (UserPO po : list) {
			if (id.equals(po.getID()) && password.equals(po.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<UserPO> findUser(String info, FindUserType type) throws RemoteException {
		return user.find(info, type);
	}

}
