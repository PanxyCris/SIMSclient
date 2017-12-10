package vo.commodity;

import vo.ViewObject;

public class CommodityItemVO extends ViewObject {


	public CommodityVO commodity;
	public double price;
	public double sum;  //�ܶ�
	public String remark;  //��ע

	public CommodityItemVO() {
		
	}
	
	public CommodityItemVO(CommodityVO commodity, String remark) {
		this.commodity = commodity;
		this.remark = remark;
	}

	public void setPrice(double price){
		this.price = price;
	}

	@Override
	public String toString() {
		return "\r\n\t[��ƷID=" + id + ", ��Ʒ����=" + commodity.getName() + ", ��Ʒ�ͺ�=" + commodity.getModel() + ", ��Ʒ����=" + commodity.getModel() + ", ��Ʒ����=" + price
				+ ", ��Ʒ�ܼ�=" + sum + ", ��ע=" + remark + "]";
	}
}
