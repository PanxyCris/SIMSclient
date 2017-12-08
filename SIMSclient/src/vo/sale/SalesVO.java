package SIMSclient.src.vo.sale;

import java.util.ArrayList;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataenum.Warehouse;
import SIMSclient.src.vo.ViewObject;
import SIMSclient.src.vo.commodity.CommodityItemVO;

public class SalesVO extends ViewObject {
	public String retailerID;
	public String retailer; // �ͻ�����
	public String saleMan; // ҵ��Ա
	public String operator;
	public Warehouse warehouse;
	public ArrayList<CommodityItemVO> commodity;
	public double beforePrice; // ����ǰ�۸�
	public double allowance; // ���ý��
	public double voucher; // ����ȯ���
	public double afterPrice;
	public String remark;
	public BillState state;
	public BillType type;

	/**
	 * @param retailerID
	 * @param retailer
	 * @param saleMan
	 * @param operator
	 * @param warehouse
	 * @param commodity
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 * @param afterPrice
	 * @param remark
	 * @param state
	 * @param type
	 */
	public SalesVO(String id, String retailerID, String retailer, String saleMan, String operator, Warehouse warehouse,
			ArrayList<CommodityItemVO> commodity, double beforePrice, double allowance, double voucher,
			double afterPrice, String remark, BillState state, BillType type) {
		super();
		this.id = id;
		this.retailerID = retailerID;
		this.retailer = retailer;
		this.saleMan = saleMan;
		this.operator = operator;
		this.warehouse = warehouse;
		this.commodity = commodity;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterPrice = afterPrice;
		this.remark = remark;
		this.state = state;
		this.type = type;
	}

	@Override
	public String toString() {
		return "[����ID=" + id + "��������=" + type.value + ", �ͻ�ID=" + retailerID + ", �ͻ�����=" + retailer +", ҵ��Ա=" + saleMan
				+ ", ����Ա=" + operator + ", ��Ʒ�б�=" + commodity + ",\r\n����ǰ�ܶ� =" + beforePrice + ", ���ý��=" + allowance
				+ ", ����ȯ�ܶ�=" + voucher + ", ���ú��ܶ�=" + afterPrice + ", ��ע=" + remark + ", ����״̬=" + state.value + "]";
	}

}