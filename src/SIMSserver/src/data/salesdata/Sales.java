package SIMSserver.src.data.salesdata;

import java.sql.Connection;
import java.sql.PreparedStatement;

import SIMSserver.src.data.DBConnection;
import SIMSserver.src.po.SalesPO;
import db.DBUtil;

/**
 * 
 * @author Lijie
 * @date 2017年12月5日
 */
public class Sales {

	public void insert(SalesPO po) throws Exception {
		Connection con = DBConnection.getConnection();// 首先拿到数据库的连接
		String sql = "" + "insert into sales" + "(id,clientId,clientName,operator,saleMan,warehouse,beforePrice, allowance, voucher, afterPrice, remark)"
				+ "values("
				+ "?,?,?,?,?,?,?,?,?,?,?)";// 参数用?表示，相当于占位符;用mysql的日期函数current_date()来获取当前日期
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(0, po.getID());
		ps.setString(1, po.getClientId());
		ps.setString(2, po.getClientName());
		ps.setString(3, po.getOperator());
		ps.setString(4, po.getSaleMan());
		ps.setString(6, String.valueOf(po.getWarehouse()));
		ps.setDouble(7, po.getBeforePrice());
		ps.setDouble(8, po.getAllowance());
		ps.setDouble(9, po.getVoucher());
		ps.setDouble(10, po.getAfterPrice());
		ps.setString(11, po.getRemark());
		ps.execute();
	}
	
	public void delete(String id) throws Exception {
		Connection conn = DBConnection.getConnection();
	}
}
