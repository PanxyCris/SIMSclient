package SIMSclient.src.po.sales;

import java.io.Serializable;
import java.util.ArrayList;
import SIMSclient.src.dataenum.Warehouse;
import SIMSclient.src.po.sales.CommodityItemPO;

public class SalesPO implements Serializable {

	public static final long serialVersionUID = 1L;
	public String ID; // 单据编号
	public String clientID;
	public String clientName; // 客户姓名
	public String operator; // 操作员
	public String saleMan; // 业务员
	public Warehouse warehouse; // 仓库
	public double beforePrice; // 折让前价格
	public double allowance; // 折让金额
	public double voucher; // 代金券金额
	public double afterPrice; // 折让后金额
	public String remark; // 备注
	public ArrayList<CommodityItemPO> commodities; // 商品清单

	/**
	 * @param iD
	 * @param clientID
	 * @param clientName
	 * @param user
	 * @param saleMan
	 * @param warehouse
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 * @param afterPrice
	 * @param remark
	 * @param billType
	 * @param state
	 * @param commodities
	 */
	public SalesPO(String iD, String clientID, String clientName, String saleMan, String operator, Warehouse warehouse,
			double beforePrice, double allowance, double voucher, double afterPrice, String remark,
			 ArrayList<CommodityItemPO> commodities) {
		super();
		ID = iD;
		this.clientID = clientID;
		this.clientName = clientName;
		this.operator = operator;
		this.saleMan = saleMan;
		this.warehouse = warehouse;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterPrice = afterPrice;
		this.remark = remark;
		this.commodities = commodities;
	}

	public String getID() {
		return ID;
	}

	

	public String getClientID() {
		return clientID;
	}

	
	public String getClientName() {
		return clientName;
	}


	public String getOperator() {
		return operator;
	}


	public String getSaleMan() {
		return saleMan;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public double getBeforePrice() {
		return beforePrice;
	}


	public double getAllowance() {
		return allowance;
	}

	public double getVoucher() {
		return voucher;
	}


	public double getAfterPrice() {
		return afterPrice;
	}

	public String getRemark() {
		return remark;
	}


	public ArrayList<CommodityItemPO> getCommodities() {
		return commodities;
	}

}
