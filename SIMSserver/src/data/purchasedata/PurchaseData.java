package data.purchasedata;
/**     
*  
* @author Lijie 
* @date 2017年12月8日    
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
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSalesType;
import po.PurchasePO;
import po.commodity.CommodityItemPO;

public class PurchaseData {

	public static void main(String[] args) {
		PurchaseData p = new PurchaseData();
		CommodityItemPO i = new CommodityItemPO("000003", "王灿灿", "脱单大佬", 100, 200, "清单大甩卖");
		CommodityItemPO i1 = new CommodityItemPO("000002", "潘星宇", "单身旺", 1000, 300, "清单大甩卖");
		ArrayList<CommodityItemPO> l = new ArrayList<>();
		l.add(i);
		l.add(i1);
		PurchasePO po = new PurchasePO("JHTHD-20171218-00002", "000002", "王灿灿", Warehouse.WAREHOUSE2, "王灿灿", 
				l, "记得付钱", 200000, BillType.PURCHASEBACKBILL);
		p.insert(po);
//		ArrayList<PurchasePO> list = p.show();
//		System.out.println(list.get(0).getCommodities().get(0).getModel());
	}
	
	public ResultMessage insert(PurchasePO po) {
		
		Connection conn = DBManager.getConnection();
		try {
//			Statement ps0 = conn.createStatement();
//			ResultSet rs = ps0.executeQuery("select count(*) from purchase where id = " + po.getId());
//			int count = 0;
//			if (rs.next()) {
//				count = rs.getInt(1);
//				if (count == 0) {
					String sql = "" + "insert into purchase(id,object) value(?, ?)";
					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getId());
					ps.setObject(2, po);
					ps.executeUpdate();
					conn.commit();
					ps.close();
					conn.close();
					return ResultMessage.SUCCESS;
//				}
//				else {
//					System.out.println("该进货单已存在");
//				}
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}

	public ResultMessage delete(String id) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from purchase where id = ?";
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

	public ResultMessage update(PurchasePO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update purchase set object = ? where id = ?";
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

	public ArrayList<PurchasePO> find(String keyword, FindSalesType type) {
		ArrayList<PurchasePO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "" + "select object from purchase";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// 以下是读取的方法一定要注意了！
				Blob inblob = (Blob) rs.getBlob("object");
				InputStream is = inblob.getBinaryStream();
				BufferedInputStream input = new BufferedInputStream(is);

				byte[] buff = new byte[(int) inblob.length()];// 放到一个buff 字节数组
				while (-1 != (input.read(buff, 0, buff.length)))
					;

				ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
				PurchasePO po = (PurchasePO) in.readObject();

				switch (type) {
				case ID:
					if (keyword.equals(po.getId()))
						list.add(po);
					break;
				case MEMBER:
					if (keyword.equals(po.getMember()))
						list.add(po);
					break;
				case TOTAL:
					if (Double.parseDouble(keyword) == po.getSum())
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

			ps.close();
			conn.close();

		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<PurchasePO> show() {
		ArrayList<PurchasePO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from purchase";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object"); // 获取blob对象
				InputStream is = inBlob.getBinaryStream(); // 获取二进制流对象
				BufferedInputStream bis = new BufferedInputStream(is); // 带缓冲区的流对象
				byte[] buff = new byte[(int) inBlob.length()];

				while (-1 != (bis.read(buff, 0, buff.length))) { // 一次性全部读到buff中
					ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
					PurchasePO po = (PurchasePO) in.readObject(); // 读出对象

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
