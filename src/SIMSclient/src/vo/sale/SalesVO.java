package SIMSclient.src.vo.sale;

import java.util.ArrayList;

import SIMSclient.src.vo.Commodity.CommodityItemVO;

public class SalesVO {
	public String BillID; // 单据ID
	public String clientID; // 客户ID
	public String clientName; // 客户名字
	public String cellNumber; // 电话号码
	public String user; // 操作员
	public String saleMan; // 业务员
	public double beforePrice; // 折让前价格
	public double allowance; // 折让金额
	public double voucher; // 代金券金额
	public double afterPrice; // 折让后金额
	public String remark; // 备注
	public BillType type; // 单据类型
	public BillState state; // 单据状态
	public ArrayList<CommodityItemVO> commodities; // 商品清单

	public SalesVO(String ID, String clientID, String clientName, String cellNumber, String user, String saleMan,
			double beforePrice, double allowance, double voucher, double afterPrice, String remark, BillType type,
			BillState state, ArrayList<CommodityItemVO> commodities) {
		super();
		this.clientID = clientID;
		this.clientName = clientName;
		this.cellNumber = cellNumber;
		this.user = user;
		this.saleMan = saleMan;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterPrice = afterPrice;
		this.remark = remark;
		this.type = type;
		this.state = state;
		this.commodities = commodities;
	}

	@Override
	public String toString() {
		return "[单据ID=" + ID + "单据类型=" + type.value + ", 客户ID=" + clientID + ", 客户姓名=" + clientName + ", 业务员=" + saleMan
				+ ", 操作员=" + user + ", 商品列表=" + commodities + ",\r\n折让前总额 =" + beforePrice + ", 折让金额=" + allowance
				+ ", 代金券总额=" + voucher + ", 折让后总额=" + afterPrice + ", 备注=" + remark + ", 单据状态=" + state.value + "]";
	}

}