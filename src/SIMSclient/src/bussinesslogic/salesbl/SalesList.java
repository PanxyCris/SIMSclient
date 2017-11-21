package SIMSclient.src.bussinesslogic.salesbl;

import java.util.ArrayList;

import SIMSclient.src.po.WareHouse;
import SIMSclient.src.po.sales.CommodityItemPO;

/*
 * ���۳�������������
 * ���ݱ�ţ�XSD-yyyyMMdd-xxxxx����
 * �ͻ�������ʾ�����̣���
 * ҵ��Ա��������ͻ��򽻵��Ĺ�˾Ա������������һ���ͻ���Ĭ��ҵ��Ա����
 * ����Ա����ǰ��¼ϵͳ���û�����
 * �ֿ⣬
 * ������Ʒ�嵥��
 * ����ǰ�ܶ
 * ���ã�
 * ʹ�ô�����
 * ���ú��ܶ
 * ��ע
 */
public class SalesList {

	private String ID;
	private String Name;
	private WareHouse wareHouse;
	private ArrayList<SalesLineItem> commodityList; // ��Ʒ�б��嵥
	private double beforePrice;
	private double allowance;
	private double voucher;
	private double afterPrice;
	private String remark;

	public SalesList() {
		commodityList = new ArrayList<>();
		beforePrice = 0;
	}

	/*�����Ʒ*/
	public void add(SalesLineItem item) {
		commodityList.add(item);
	}
	
	/*����PO��ת��*/
	public ArrayList<CommodityItemPO> getCommodities() {
		ArrayList<CommodityItemPO> commoditiesPO = new ArrayList<CommodityItemPO>();
		for(SalesLineItem commodity : commodityList) {
			CommodityItemPO po = new CommodityItemPO(commodity.getName(),
					commodity.getNumber(), commodity.getPrice(), commodity.getRemark());
			commoditiesPO.add(po);
		}
		return commoditiesPO;
	}
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public WareHouse getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}


	/*��������ǰ�۸�*/
	public double getBeforePrice() {
		if (beforePrice > 0) {
			return beforePrice;
		}
		for(int i = 0; i < commodityList.size(); i++) {
			beforePrice += commodityList.get(i).getSum();
		}
		return beforePrice;
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

	/*�������ú�۸�*/
	public double getAfterPrice() {
		this.afterPrice = beforePrice - voucher - allowance;
		if (this.afterPrice < 0) {
			return 0;
		}
		return afterPrice;
	}


	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
