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
* @date 2017年12月14日
*/
public class ClassificationData {


	public static void main(String[] args){
//
//		ArrayList<ClassificationVPO> children = new ArrayList<>();
//		ArrayList<ClassificationVPO> children1 = new ArrayList<>();
//	    ClassificationVPO c11 = new ClassificationVPO("0005","白白炽灯",true,null,null);
//		ClassificationVPO c12 = new ClassificationVPO("0006","黑白炽灯",true,null,null);
//		children1.add(c11);
//		children1.add(c12);
//
//		ClassificationVPO c1 = new ClassificationVPO("0002","白炽灯",true,null,children1);
//		ClassificationVPO c2 = new ClassificationVPO("0003","照明灯",true,null,null);
//		ClassificationVPO c3 = new ClassificationVPO("0004","黑灯",true,null,null);
//	    children.add(c1);
//		children.add(c2);
//		children.add(c3);
		ClassificationVPO root = new ClassificationVPO("0001","灯",true,null,null);

		ClassificationData d = new ClassificationData();
	    d.insert(root);
	}

	private Connection conn;
	public ClassificationData() {
		conn = DBManager.getConnection();
	}

	public ResultMessage insert(ClassificationVPO po) {

		ArrayList<ClassificationVPO> children;
		if(po.getFather().getChildren()==null)
			children = new ArrayList<>();
		else
			children = po.getFather().getChildren();
		children.add(po);
		ClassificationVPO father = new ClassificationVPO(po.getId(), po.getName(), po.getB(), po.getFather(), children);
		update(father);

			try {
			String sql0 = "select count(*) from classification where id = ?";
			PreparedStatement ps0 = conn.prepareStatement(sql0);
			ps0.setString(1, po.getName());
//			Statement ps0 = conn.createStatement();
			ResultSet rs = ps0.executeQuery();
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
					System.out.println("客户ID已存在");
					return ResultMessage.EXISTED;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResultMessage.FAIL;
	}

	public ResultMessage delete(String id)  {
		String sql = "" + "delete from classification where id = ?";
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
				Blob inBlob = (Blob) rs.getBlob("object");   //获取blob对象
				InputStream is = inBlob.getBinaryStream();                //获取二进制流对象
                BufferedInputStream bis = new BufferedInputStream(is);    //带缓冲区的流对象
                byte[] buff = new byte[(int) inBlob.length()];

                while(-1!=(bis.read(buff, 0, buff.length))){            //一次性全部读到buff中
                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));
                    ClassificationVPO po = (ClassificationVPO)in.readObject();                   //读出对象

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
				Blob inBlob = (Blob) rs.getBlob("object");   //获取blob对象
				InputStream is = inBlob.getBinaryStream();                //获取二进制流对象
                BufferedInputStream bis = new BufferedInputStream(is);    //带缓冲区的流对象
                byte[] buff = new byte[(int) inBlob.length()];

                while(-1!=(bis.read(buff, 0, buff.length))){            //一次性全部读到buff中
                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));
                    ClassificationVPO po = (ClassificationVPO)in.readObject();                   //读出对象

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
		ClassificationVPO po = null;
		ArrayList<ClassificationVPO> list = show();
		for(ClassificationVPO p : list) {
			if (p.getName().equals("灯")) return p;
		}
//		ClassificationVPO root = new ClassificationVPO("0001","灯",true,null,null);
		return po;

	}

	public ClassificationVPO findClassification(String name) {
		String sql = "select object from classification where id = ?";
		ClassificationVPO po = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object");   //获取blob对象
				InputStream is = inBlob.getBinaryStream();                //获取二进制流对象
                BufferedInputStream bis = new BufferedInputStream(is);    //带缓冲区的流对象
                byte[] buff = new byte[(int) inBlob.length()];

                while(-1!=(bis.read(buff, 0, buff.length)));
                ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));
                po = (ClassificationVPO)in.readObject();                   //读出对象

			}
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return po;

	}
}
