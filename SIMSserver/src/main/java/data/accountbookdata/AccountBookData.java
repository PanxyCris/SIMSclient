package data.accountbookdata;
/**     
*  
* @author Lijie 
* @date 2017年12月14日    
*/

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
import dataenum.findtype.FindAccountBookType;
import po.UserPO;
import po.accountbookpo.AccountBookPO;
import po.accountpo.AccountPO;

public class AccountBookData {

	public ResultMessage insert(AccountBookPO po) {
		Connection conn = DBManager.getConnection();// 首先拿到数据库的连接
		try {
//			Statement ps0 = conn.createStatement();
//			ResultSet rs = ps0.executeQuery("select count(*) from accountbook where id = " + po.getID());
//			int count = 0;
//			if (rs.next()) {
//				count = rs.getInt(1);
//				if (count == 0) {
					String sql = "" + "insert into accountbook(id, object) values (?,?)";
					
					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getDate());
			        ps.setObject(2, po);
			        ps.executeUpdate();
			        conn.commit();
			        ps.close();
			        conn.close();
			        return ResultMessage.SUCCESS;
//				}
//				else {
//					System.out.println("该期初建账已存在");
//				}
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}
	
	public ResultMessage delete(String id) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from accountbool where id = ?";
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
	
	public ResultMessage update(AccountBookPO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update accountbook set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getDate());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}

	}
	
	public ArrayList<AccountBookPO> find(String keyword, FindAccountBookType type) {
		ArrayList<AccountBookPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from accountbook";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object");   //获取blob对象 
				InputStream is = inBlob.getBinaryStream();                //获取二进制流对象  
                BufferedInputStream bis = new BufferedInputStream(is);    //带缓冲区的流对象  
                byte[] buff = new byte[(int) inBlob.length()];
                
                while(-1!=(bis.read(buff, 0, buff.length))){            //一次性全部读到buff中  
                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));  
                    AccountBookPO po = (AccountBookPO)in.readObject();                   //读出对象  
                      
//                  switch (type) {
//					case :
//						
//						break;
//
//					default:
//						break;
//					}
                    list.add(po);
//                }  
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
	
	public ArrayList<AccountBookPO> show() {
		ArrayList<AccountBookPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from accountbook";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object");   //获取blob对象 
				InputStream is = inBlob.getBinaryStream();                //获取二进制流对象  
                BufferedInputStream bis = new BufferedInputStream(is);    //带缓冲区的流对象  
                byte[] buff = new byte[(int) inBlob.length()];
                
                while(-1!=(bis.read(buff, 0, buff.length))){            //一次性全部读到buff中  
                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));  
                    AccountBookPO po = (AccountBookPO)in.readObject();                   //读出对象  
                      
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
