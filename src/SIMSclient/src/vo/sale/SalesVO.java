package SIMSclient.src.vo.sale;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.vo.BillVO;
import SIMSclient.src.vo.commodity.CommodityVO;
/**
 *
 * @author
 *
 */
public class SalesVO extends BillVO{
	public String clientID;
	public String clientName;  //客户姓名
	public String user; // 操作员
	public String saleMan; // 业务员
	public double beforePrice; // 折让前价格
	public double allowance; // 折让金额
	public double voucher; // 代金券金额
	public double afterPrice; // 折让后金额
	public String remark; // 备注
	public BillState state; // 单据状态
	public ArrayList<CommodityVO> commodities; // 商品清单

	public SalesVO(int ID, Date date, String clientID, String clientName, String cellNumber, String user, String saleMan,
			double beforePrice, double allowance, double voucher, double afterPrice, String remark,
			BillState state, ArrayList<CommodityVO> commodities) {
	    super(ID, date, state, remark);
		this.id = ID;
		this.date = date;
		this.clientID = clientID;
		this.clientName = clientName;
		this.user = user;
		this.saleMan = saleMan;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterPrice = afterPrice;
		this.remark = remark;
		this.state = state;
		this.commodities = commodities;
	}

	public String toString() {
		return "[单据ID=" + id +",日期="+date+ ", 客户ID=" + clientID + ", 客户姓名=" + clientName
				+ ", 业务员=" + saleMan + ", 操作员=" + user + ", 商品列表=" + commodities + ",\r\n折让前总额 =" + beforePrice
				+ ", 折让金额=" + allowance + ", 代金券总额=" + voucher + ", 折让后总额=" + afterPrice + ", 备注=" + remark + ", 单据状态="
				+ state.value + "]";
	}

}