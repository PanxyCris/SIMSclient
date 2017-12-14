package data.userdata;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.DBManager;
import dataenum.ResultMessage;
import dataenum.UserRole;
import dataenum.findtype.FindUserType;
import po.UserPO;

/**     
*  
* @author Lijie 
* @date 2017��12��7��    
*/
public class UserData {
	public static void main(String[] args) {
		UserData user = new UserData();
		UserPO po = new UserPO("000004", "���Ӳ�", "1245678", UserRole.FINANCIAL_MANAGER, null);
//		user.delete("00002");
		user.insert(po);
		ArrayList<UserPO> list = user.show();
		System.out.println("555");
		for(UserPO u: list) {
			System.out.println(u.toString());
		}
		
		
	}
	public ResultMessage insert(UserPO po) {
		Connection conn = DBManager.getConnection();// �����õ����ݿ������
		try {
			Statement ps0 = conn.createStatement();
			ResultSet rs = ps0.executeQuery("select count(*) from userrole where id = " + po.getID());
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					String sql = "" + "insert into userrole(id, object) values (?,?)";
					
					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getID());
			        ps.setObject(2, po);
			        ps.executeUpdate();
			        conn.commit();
			        ps.close();
			        conn.close();
			        return ResultMessage.SUCCESS;
				}
				else {
					System.out.println("�ͻ�ID�Ѵ���");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}
	
	public ResultMessage delete(String id)  {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from userrole where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public ArrayList<UserPO> find(String keyword, FindUserType type) {
		ArrayList<UserPO> list = new ArrayList<>();
		UserPO po = null;
		Connection conn = DBManager.getConnection();
		String sql = "" + "select object from userrole";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// �����Ƕ�ȡ�ķ���һ��Ҫע���ˣ�
				Blob inblob = (Blob) rs.getBlob("object");
				InputStream is = inblob.getBinaryStream();
				BufferedInputStream input = new BufferedInputStream(is);

				byte[] buff = new byte[(int) inblob.length()];// �ŵ�һ��buff �ֽ�����
				while (-1 != (input.read(buff, 0, buff.length)));

				ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
				po = (UserPO) in.readObject();
				
				if(type == FindUserType.ID) {
					if(keyword.equals(po.getID())) {
						list.add(po);
					}
				}
				else if (type == FindUserType.NAME) {
					if(keyword.equals(po.getName())) {
						list.add(po);
					}
				}
				else if (type == FindUserType.USERROLE) {
					if(keyword.equals(po.getRole())) {
						list.add(po);
					}
				}
				
			}
					
		}catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return list;
	}
	
	public ResultMessage update(UserPO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update userrole set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getID());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	public ArrayList<UserPO> show() {
		ArrayList<UserPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from userrole";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object");   //��ȡblob���� 
				InputStream is = inBlob.getBinaryStream();                //��ȡ������������  
                BufferedInputStream bis = new BufferedInputStream(is);    //����������������  
                byte[] buff = new byte[(int) inBlob.length()];
                
                while(-1!=(bis.read(buff, 0, buff.length))){            //һ����ȫ������buff��  
                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));  
                    UserPO po = (UserPO)in.readObject();                   //��������  
                      
                    list.add(po);  
                }  
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return list;
		
	}

}
