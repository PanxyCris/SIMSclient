package SIMSclient.src.vo.sale;

public class CommodityItemVO {

	public String id;
	public String name;
	public String model;  //��Ʒ�ͺ�
	public int number;  //��Ʒ����
	public double price;
	public double sum;  //�ܶ�
	public String remark;  //��ע

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
