package data.salesdata;

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
import java.sql.Statement;
import java.util.ArrayList;

import data.DBManager;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSalesType;
import po.PurchasePO;
import po.sales.SalesPO;
import po.commodity.CommodityItemPO;

/**
 *
 * @author Lijie
 * @date 2017��12��5��
 */
public class SalesData{

	private Connection conn;
	public SalesData() {
		conn = DBManager.getConnection();
	}

	public static void main(String[] args) {
		ArrayList<CommodityItemPO> commodities = new ArrayList<>();
		SalesPO po = new SalesPO("XSTHD-20171231", "000001", "������", "���Ӳ�", "����",
				Warehouse.WAREHOUSE1, commodities, 2000, 200, 300, 1500, "�󼪴��������ϳԼ�", BillType.SALESBACKBILL, BillState.DRAFT);
		CommodityItemPO e = new CommodityItemPO("000001", "������", "������", 100, 200, "����");
		commodities.add(e);
		SalesData s = new SalesData();
		s.insert(po);
		ArrayList<SalesPO> list = s.show();
		for (SalesPO p : list) {
			System.out.println(p.getId() + " " + p.getClientName());
		}
	}

	public ResultMessage insert(SalesPO po) {
		try {
			PreparedStatement ps0 = conn.prepareStatement("select count(*) from sales where id = ?");
			ps0.setString(1, po.getId());
			ResultSet rs = ps0.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					String sql = "" + "insert into sales(id,object) value(?, ?)";
					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getId());
					ps.setObject(2, po);
					ps.executeUpdate();
					conn.commit();
					ps.close();
					return ResultMessage.SUCCESS;
				}
				else {
					System.out.println("�������Ѵ���");
					return ResultMessage.EXISTED;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}

	public ResultMessage delete(String id) {
		String sql = "" + "delete from sales where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ResultMessage update(SalesPO po) {
		String sql = "" + "update sales set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getId());
			ps.executeUpdate();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<SalesPO> find(String keyword, FindSalesType type) {
		ArrayList<SalesPO> list = new ArrayList<>();
		String sql = "" + "select object from sales";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// �����Ƕ�ȡ�ķ���һ��Ҫע���ˣ�
				Blob inblob = (Blob) rs.getBlob("object");
				InputStream is = inblob.getBinaryStream();
				BufferedInputStream input = new BufferedInputStream(is);

				byte[] buff = new byte[(int) inblob.length()];// �ŵ�һ��buff �ֽ�����
				while (-1 != (input.read(buff, 0, buff.length)))
					;

				ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
				SalesPO po = (SalesPO) in.readObject();

				switch (type) {
				case ID:
					if (keyword.equals(po.getId()))
						list.add(po);
					break;
				case MEMBER:
					if (keyword.equals(po.getClientName()))
						list.add(po);
					break;
				case TOTAL:
					if (Double.parseDouble(keyword) == po.getAfterPrice())
						list.add(po);
					break;
				case OPERATOR:
					if (keyword.equals(po.getOperator()))
						list.add(po);
					break;

				default:
					break;
				}
			}

		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<SalesPO> show() {
		ArrayList<SalesPO> list = new ArrayList<>();
		String sql = "select object from sales";
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
					SalesPO po = (SalesPO) in.readObject(); // ��������

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

}
