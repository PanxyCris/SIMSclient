package SIMSclient.src.po.sales;

import java.io.Serializable;
import java.util.ArrayList;
import SIMSclient.src.dataenum.Warehouse;
import SIMSclient.src.po.sales.CommodityItemPO;

public class SalesPO implements Serializable {

	public static final long serialVersionUID = 1L;
	public String ID; // ���ݱ��
	public String clientID;
	public String clientName; // �ͻ�����
	public String operator; // ����Ա
	public String saleMan; // ҵ��Ա
	public Warehouse warehouse; // �ֿ�
	public double beforePrice; // ����ǰ�۸�
	public double allowance; // ���ý��
	public double voucher; // ����ȯ���
	public double afterPrice; // ���ú���
	public String remark; // ��ע
	public ArrayList<CommodityItemPO> commodities; // ��Ʒ�嵥

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
