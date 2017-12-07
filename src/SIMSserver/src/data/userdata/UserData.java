package SIMSserver.src.data.userdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SIMSserver.src.data.DBManager;
import SIMSserver.src.dataenum.UserRole;
import SIMSserver.src.po.UserPO;

/**     
*  
* @author Lijie 
* @date 2017年12月7日    
*/
public class UserData {

	
	public void createTable() throws SQLException {
		Connection conn = DBManager.getConnection();
		String sql = "" + "create table userroel (id varchar(30) not null, name varchar(20) not null, password varchar(20) not null, role varchar(10) not null);";
		Statement s = conn.createStatement();
		s.execute(sql);
	}
	
	public void insert(UserPO po) {
		Connection conn = DBManager.getConnection();// 首先拿到数据库的连接
		String sql = "" + "insert into obj (object) values (?)";
		try{
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, po);
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();    
        }
	}
	
	public void delete(String id)  {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from userrole where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public UserPO find(String id) {
		UserPO po = null;
		Connection conn = DBManager.getConnection();
		String sql = "select * from userrole where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserRole role = UserRole.FINANCIAL_MANAGER;
				po = new UserPO(rs.getString("id"), rs.getString("name"), rs.getString("role"), role, null);
			}
		}catch (NullPointerException  | SQLException e) {
			System.out.println("no data");
		}
		return po;
	}
	
	public void update(UserPO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update userrole set name = ?, password = ?, role = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, po.getName());
			ps.setString(2, po.getPassword());
			ps.setString(3, String.valueOf(po.getRole()));
			ps.setString(4, po.getID());
	        ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
