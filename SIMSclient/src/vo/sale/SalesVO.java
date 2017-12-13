package vo.sale;

import java.util.ArrayList;


import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import vo.ViewObject;
import vo.commodity.CommodityItemVO;

public class SalesVO extends ViewObject {
	public String retailerID;
	public String retailer; // �ͻ�����
	public String saleMan; // ҵ��Ա
	public String operator;
	public Warehouse warehouse;
	public ArrayList<CommodityItemVO> commodity;
	public Double beforePrice; // ����ǰ�۸�
	public Double allowance; // ���ý��
	public Double voucher; // ����ȯ���
	public Double afterPrice;
	public String remark;
	public BillState state;
	public BillType type;

	
	public SalesVO(String id, String retailerID, String retailer, String saleMan, String operator, Warehouse warehouse,
			ArrayList<CommodityItemVO> commodity, Double beforePrice, Double allowance, Double voucher,
			Double afterPrice, String remark, BillState state, BillType type) {
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

}