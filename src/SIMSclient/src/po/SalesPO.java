package SIMSclient.src.po;

import java.io.Serializable;
import java.util.ArrayList;
import SIMSclient.src.po.WareHouse;
import SIMSclient.src.po.CommodityPO;

public class SalesPO implements Serializable {

	private String ID; // ���ݱ��
	private String clientID;
	private String clientName; // �ͻ�����
	private String user; // ����Ա
	private String saleMan; // ҵ��Ա
	private WareHouse warehouse; // �ֿ�
	private double beforePrice; // ����ǰ�۸�
	private double allowance; // ���ý��
	private double voucher; // ����ȯ���
	private double afterPrice; // ���ú���
	private String remark; // ��ע
	private ArrayList<CommodityPO> commodities; // ��Ʒ�嵥

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
	public SalesPO(String iD, String clientID, String clientName, String user, String saleMan, WareHouse warehouse,
			double beforePrice, double allowance, double voucher, double afterPrice, String remark,
			 ArrayList<CommodityPO> commodities) {
		super();
		ID = iD;
		this.clientID = clientID;
		this.clientName = clientName;
		this.user = user;
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

	public void setID(String iD) {
		ID = iD;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSaleMan() {
		return saleMan;
	}

	public void setSaleMan(String saleMan) {
		this.saleMan = saleMan;
	}

	public WareHouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WareHouse warehouse) {
		this.warehouse = warehouse;
	}

	public double getBeforePrice() {
		return beforePrice;
	}

	public void setBeforePrice(double beforePrice) {
		this.beforePrice = beforePrice;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public double getVoucher() {
		return voucher;
	}

	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}

	public double getAfterPrice() {
		return afterPrice;
	}

	public void setAfterPrice(double afterPrice) {
		this.afterPrice = afterPrice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public ArrayList<CommodityPO> getCommodities() {
		return commodities;
	}

	public void setCommodities(ArrayList<CommodityPO> commodities) {
		this.commodities = commodities;
	}

}
