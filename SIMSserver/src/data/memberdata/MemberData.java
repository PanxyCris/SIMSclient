package data.memberdata;

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
import dataenum.findtype.FindMemberType;
import po.MemberPO;

/**
 * 
 * @author Lijie
 * @date 2017��12��7��
 */
public class MemberData {

	public ResultMessage insert(MemberPO po) {
		Connection conn = DBManager.getConnection();// �����õ����ݿ������
		try {
			Statement ps0 = conn.createStatement();
			ResultSet rs = ps0.executeQuery("select count(*) from member where id = " + po.getId());
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					String sql = "" + "insert into Member (id, object) values (?,?)";
					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getId());
					ps.setObject(2, po);
					ps.executeUpdate();
					conn.commit();
					ps.close();
					conn.close();
					return ResultMessage.SUCCESS;
				}
				else {
					System.out.println("�ÿͻ��Ѵ���");
					return ResultMessage.FAIL;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.FAIL;

	}

	public ResultMessage delete(String id) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from member where id = ?";
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

	public ResultMessage update(MemberPO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update member set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getId());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<MemberPO> find(String keyword, FindMemberType type) {
		ArrayList<MemberPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "" + "select object from member";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// �����Ƕ�ȡ�ķ���һ��Ҫע���ˣ�
				try {
					Blob inblob = (Blob) rs.getBlob("object");
					InputStream is = inblob.getBinaryStream();
					BufferedInputStream input = new BufferedInputStream(is);

					byte[] buff = new byte[(int) inblob.length()];// �ŵ�һ��buff �ֽ�����
					while (-1 != (input.read(buff, 0, buff.length)))
						;

					ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));

					MemberPO po = (MemberPO) in.readObject();

					switch (type) {
					case ADDRESS:
						if (keyword.equals(po.getAddress()))
							list.add(po);
						break;
					case ID:
						if (keyword.equals(po.getId()))
							list.add(po);
						break;
					case EMAIL:
						if (keyword.equals(po.getEmail()))
							list.add(po);
						break;
					case NAME:
						if (keyword.equals(po.getName()))
							list.add(po);
						break;
					case LEVEL:
						if (keyword.equals(po.getLevel().value))
							list.add(po);
						break;
					case KIND:
						if (keyword.equals(po.getCategory().value))
							list.add(po);
						break;
					case PHONE:
						if (keyword.equals(po.getPhone()))
							list.add(po);
						break;
					case POST:
						if (keyword.equals(po.getPost()))
							list.add(po);
						break;
					case PAYABLE:
						if (po.getPayable() == Double.parseDouble(keyword))
							list.add(po);
						break;
					case RECEIVABLE:
						if (po.getReceivable() == Double.parseDouble(keyword))
							list.add(po);
						break;
					case RECEIVABLELIMIT:
						if (po.getRereceivableLimit() == Double.parseDouble(keyword))
							list.add(po);
						break;
					case SALESMAN:
						if (keyword.equals(po.getSaleMan()))
							list.add(po);
						break;
					default:
						break;
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<MemberPO> show() {
		ArrayList<MemberPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from member";
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
					MemberPO po = (MemberPO) in.readObject(); // ��������

					list.add(po);
				}
			}
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;

	}
}
