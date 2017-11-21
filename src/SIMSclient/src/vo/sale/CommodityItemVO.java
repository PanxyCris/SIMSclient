package SIMSclient.src.vo.sale;

public class CommodityItemVO {

	public String id;
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
}
