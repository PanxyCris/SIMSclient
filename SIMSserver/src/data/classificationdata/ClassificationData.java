package data.classificationdata;

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
import po.ClassificationVPO;
import po.UserPO;

/**     
*  
* @author Lijie 
* @date 2017��12��14��    
*/
public class ClassificationData {
	
	private Connection conn;
	public ClassificationData() {
		conn = DBManager.getConnection();
	}

	public ResultMessage insert(ClassificationVPO po) {
			try {
			Statement ps0 = conn.createStatement();
			ResultSet rs = ps0.executeQuery("select count(*) from classification where id = " + po.getId());
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					String sql = "" + "insert into classification(id, object) values (?,?)";
					
					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getId());
			        ps.setObject(2, po);
			        ps.executeUpdate();
			        conn.commit();
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
		String sql = "" + "delete from calssification where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			ps.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	public ResultMessage update(ClassificationVPO po) {
		String sql = "" + "update classification set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getId());
			ps.executeUpdate();
			ps.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	public ArrayList<ClassificationVPO> find(String keyword) {
		ArrayList<ClassificationVPO> list = new ArrayList<>();
		String sql = "select object from classification";
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
                    ClassificationVPO po = (ClassificationVPO)in.readObject();                   //��������  
                    
                    if (keyword.equals(po.getName())) list.add(po);
                }  
			}
			rs.close();
			ps.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return list;
		
	}
	
	public ArrayList<ClassificationVPO> show() {
		ArrayList<ClassificationVPO> list = new ArrayList<>();
		String sql = "select object from classification";
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
                    ClassificationVPO po = (ClassificationVPO)in.readObject();                   //��������  
                      
                    list.add(po);  
                }  
			}
			rs.close();
			ps.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return list;
		
	}
	
	public ClassificationVPO getRoot() {
		String sql = "select object from classification where name = ?";
		ClassificationVPO po = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(0, "root");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object");   //��ȡblob���� 
				InputStream is = inBlob.getBinaryStream();                //��ȡ������������  
                BufferedInputStream bis = new BufferedInputStream(is);    //����������������  
                byte[] buff = new byte[(int) inBlob.length()];
   
                while(-1!=(bis.read(buff, 0, buff.length)));
                ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));  
                po = (ClassificationVPO)in.readObject();                   //��������  
           
			}
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return po;
		
	}
	
	public ClassificationVPO findClassification(String name) {
		String sql = "select object from classification where name = ?";
		ClassificationVPO po = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(0, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object");   //��ȡblob���� 
				InputStream is = inBlob.getBinaryStream();                //��ȡ������������  
                BufferedInputStream bis = new BufferedInputStream(is);    //����������������  
                byte[] buff = new byte[(int) inBlob.length()];
   
                while(-1!=(bis.read(buff, 0, buff.length)));
                ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));  
                po = (ClassificationVPO)in.readObject();                   //��������  
           
			}
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return po;
		
	}
}
