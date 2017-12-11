package bussinesslogic.salesbl;

import java.util.ArrayList;

import dataenum.Warehouse;
import po.commodity.CommodityItemPO;

/*
 * ���۵���������
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

	private String memberID;
	private Warehouse warehouse;
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
	
	/*ת����PO*/
	public ArrayList<CommodityItemPO> getCommodities() {
		ArrayList<CommodityItemPO> list = new ArrayList<CommodityItemPO>();
		for(SalesLineItem s : commodityList) {
			CommodityItemPO po = new CommodityItemPO(s.getId(), s.getName(), s.getModel(), s.getNumber(), s.getPrice(), s.getRemark());
			list.add(po);
		}
		return list;
	}
	
	
	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String id) {
		this.memberID = id;
	}

	public Warehouse getWareHouse() {
		return warehouse;
	}

	public void setWareHouse(Warehouse warehouse) {
		this.warehouse = warehouse;
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
		else return afterPrice;
	}


	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
