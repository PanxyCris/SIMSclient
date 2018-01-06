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


	public static void main(String[] args){

		ClassificationData d = new ClassificationData();
		ArrayList<ClassificationVPO> children = new ArrayList<>();
		ArrayList<ClassificationVPO> children1 = new ArrayList<>();
	    ClassificationVPO c11 = new ClassificationVPO("0005","�װ׳��",true,null,null);
		ClassificationVPO c12 = new ClassificationVPO("0006","�ڰ׳��",true,null,null);
		children1.add(c11);
		children1.add(c12);

		ClassificationVPO c1 = new ClassificationVPO("0002","�׵�",true,"��",null);
     	ClassificationVPO c2 = new ClassificationVPO("0006","����",true,"�׵�",null);
		ClassificationVPO c3 = new ClassificationVPO("0005","�̵�",true,"�׵�",null);
//	    children.add(c1);
//		children.add(c2);
//		children.add(c3);
		 ClassificationVPO root = new ClassificationVPO("0001","��",true,null,null);

//  	d.insert(c2);
//		d.insert(c1);
//		d.insert(c3);
//		d.delete("�̵�");
		System.out.println(d.show().size());
	}

	private Connection conn;
	public ClassificationData() {
		conn = DBManager.getConnection();
	}

	public ResultMessage insert(ClassificationVPO po) {

			try {
//			String sql0 = "select count(*) from classification where name = ?";
//			PreparedStatement ps0 = conn.prepareStatement(sql0);
//			ps0.setString(1, po.getName());
////			Statement ps0 = conn.createStatement();
//			ResultSet rs = ps0.executeQuery();
//			int count = 0;
//			if (rs.next()) {
//				count = rs.getInt(1);
//				System.out.println(count);
//				if (count == 0) {
					String sql = "" + "insert into classification(name, object) values (?,?)";

					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getName());
			        ps.setObject(2, po);
			        ps.executeUpdate();
			        conn.commit();
			        ps.close();
			        return ResultMessage.SUCCESS;
//				}
//				else {
//					System.out.println("�����Ѵ���");
//					return ResultMessage.EXISTED;
//				}
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResultMessage.FAIL;
	}

	public ResultMessage delete(String name)  {
		String sql = "" + "delete from classification where name = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.execute();
			ps.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ResultMessage update(ClassificationVPO po) {
		String sql = "" + "update classification set object = ? where name = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getName());
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
		ClassificationVPO po = null;
		ArrayList<ClassificationVPO> list = show();
		for(ClassificationVPO p : list) {
			if (p.getName().equals("��")) return p;
		}
//		ClassificationVPO root = new ClassificationVPO("0001","��",true,null,null);
		return po;

	}

	public ClassificationVPO findClassification(String name) {
		String sql = "select object from classification where name = ?";
		ClassificationVPO po = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
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
