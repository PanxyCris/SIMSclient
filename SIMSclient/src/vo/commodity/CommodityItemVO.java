package vo.commodity;

import vo.ViewObject;

public class CommodityItemVO extends ViewObject {


	CommodityVO commodity;
	public String price;
	public String sum;  //�ܶ�
	public String remark;  //��ע

	public CommodityItemVO(CommodityVO commodity, String remark) {
		this.commodity = commodity;
		this.remark = remark;
	}

	public void setPrice(String price){
		this.price = price;
	}

	@Override
	public String toString() {
		return "\r\n\t[��ƷID=" + id + ", ��Ʒ����=" + commodity.getName() + ", ��Ʒ�ͺ�=" + commodity.getModel() + ", ��Ʒ����=" + commodity.getModel() + ", ��Ʒ����=" + price
				+ ", ��Ʒ�ܼ�=" + sum + ", ��ע=" + remark + "]";
	}
}
