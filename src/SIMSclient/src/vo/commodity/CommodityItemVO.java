package SIMSclient.src.vo.commodity;

import SIMSclient.src.vo.ValueObject;

public class CommodityItemVO extends ValueObject {

	public String name;
	public String model;  //商品型号
	public int number;  //商品数量
	public double price;
	public double sum;  //总额
	public String remark;  //备注

	public CommodityItemVO(String id, String name, String model, int number, double price, String remark) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.number = number;
		this.price = price;
		this.sum = price * number;
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "\r\n\t[商品ID=" + id + ", 商品名称=" + name + ", 商品型号=" + model + ", 商品数量=" + number + ", 商品单价=" + price
				+ ", 商品总价=" + sum + ", 备注=" + remark + "]";
	}
}
