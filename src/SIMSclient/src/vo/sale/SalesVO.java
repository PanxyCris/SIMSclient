package SIMSclient.src.vo.sale;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataenum.Warehouse;
import SIMSclient.src.vo.bill.PurchaseAndSalesBillVO;
import SIMSclient.src.vo.bill.WareHouse;

public class SalesVO extends PurchaseAndSalesBillVO {
	public String clientID;
	public String retailer; // �ͻ�����
	public String saleMan; // ҵ��Ա
	public double beforePrice; // ����ǰ�۸�
	public double allowance; // ���ý��
	public double voucher; // ����ȯ���

	public SalesVO(String i, Date d, String clientID, String retailer, String saleMan, String operator,
			Warehouse warehouse, ArrayList<CommodityItemVO> commodityList, double beforePrice, double allowance,
			double voucher, double amount, String des, BillState s, BillType t) {
		super(i, d, s, t, des, warehouse, operator, amount, commodityList);
		this.clientID = clientID;
		this.retailer = retailer;
		this.saleMan = saleMan;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
	}

}