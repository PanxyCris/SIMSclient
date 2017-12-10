package po;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import po.commodity.CommodityItemPO;


public class SalesPO extends PersistObject {
	private static final long serialVersionUID = 1L;
	private String clientId;
	private String clientName; // �ͻ�����
	private String operator; // ����Ա
	private String saleMan; // ҵ��Ա
	private Warehouse warehouse; // �ֿ�
	private double beforePrice; // ����ǰ�۸�
	private double allowance; // ���ý��
	private double voucher; // ����ȯ���
	private double afterPrice; // ���ú���
	private String remark; // ��ע
	private ArrayList<CommodityItemPO> commodities; // ��Ʒ�嵥
	private BillState state;
	private BillType type;

	
	public SalesPO() {
		
	}

	public SalesPO(String id, String clientId, String clientName, String saleMan, String operator, Warehouse warehouse,
			ArrayList<CommodityItemPO> commodities, double beforePrice, double allowance, double voucher,
			double afterPrice, String remark, BillType type) {
		super(id);
		this.clientId = clientId;
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
		this.state = BillState.COMMITED;
		this.type = type;
	}

	public void setState(BillState state) {
		this.state = state;
	}

	public String getClientId() {
		return clientId;
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

	public BillState getState() {
		return state;
	}

	public BillType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "SalesPO [ID=" + this.id + ", clientID=" + this.clientId + ", client=" + this.clientName + ", salesman="
				+ this.saleMan + ", operator=" + this.operator + ", Warehouse=" + this.warehouse + ", commodities="
				+ this.commodities + ", beforePrice=" + this.beforePrice + ", allowance=" + this.allowance
				+ ", voucher=" + this.voucher + ", afterPrice=" + this.afterPrice + ", remark=" + this.remark
				+ ", type=" + this.type + ", state=" + this.state + "]";
	}

}
