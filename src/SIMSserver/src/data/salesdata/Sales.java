package SIMSserver.src.data.salesdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import SIMSserver.src.data.DBManager;
import SIMSserver.src.dataenum.BillType;
import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataenum.Warehouse;
import SIMSserver.src.po.SalesPO;
import SIMSserver.src.po.commodity.CommodityItemPO;

/**
 * 
 * @author Lijie
 * @date 2017年12月5日
 */
public class Sales {

	public ResultMessage createTable() throws RemoteException {
		Connection conn = DBManager.getConnection();
		String sql = "create table Sales (id varchar(25) not null, memberID varchar(20) not null, member varchar(20) not null, "
				+ "saleMan varchar(20), operator varchar(20), warehouse varchar(20), beforePrice double, allowance double, "
				+ "voucher double, afterPrice double, remark varchar(40), type varchar(20));";
		
		try {
			Statement s = conn.createStatement();
			s.execute(sql);
			s.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	public ResultMessage insert(SalesPO po) throws Exception {
		Connection conn = DBManager.getConnection();// 首先拿到数据库的连接
		String sql = "" + "insert into sales values('" + po.getID() + "','" + po.getClientId() + "','" + po.getClientName() + "','" 
		            + po.getSaleMan() + "','" + po.getOperator() + "','" + po.getWarehouse() + "','" + po.getBeforePrice() + "','" 
		            + po.getAllowance() + "','" + po.getVoucher() + "','" + po.getAfterPrice() + "','" + po.getRemark() + ");";
		try{
			Statement s = conn.createStatement();
            s.executeUpdate(sql);
            s.close();
            conn.close();
            return ResultMessage.SUCCESS;
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.FAIL;
        }
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public SalesPO find(String id) throws Exception {
		SalesPO po = null;
		Connection conn = DBManager.getConnection();
		ResultSet rs = null;
		String sql = "select * from sales where id = " + id;
		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);
			
			ArrayList<CommodityItemPO> commodities = null;
			BillType type = null;
			Warehouse warehouse = null;
			String temp = null;
			if(rs.next()) {
				temp = rs.getString(12).toUpperCase();
				if(temp.equals(BillType.SALESBILL)) {
					type = BillType.SALESBILL;
				}
				else {
					type = BillType.SALESBACKBILL;
				}
				
				temp = rs.getString(6).toUpperCase();
				if(temp.equals(Warehouse.WAREHOUSE1)) {
					warehouse = Warehouse.WAREHOUSE1;
				}
				else {
					warehouse = Warehouse.WAREHOUSE2;
				}
				
				po = new SalesPO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), warehouse, commodities, rs.getDouble(7), rs.getDouble(8),
						rs.getDouble(9), rs.getDouble(10), rs.getString(11),type);
			}
			
			s.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
	
	public void delete(String id) throws Exception {
		Connection conn = DBManager.getConnection();
	}
}
