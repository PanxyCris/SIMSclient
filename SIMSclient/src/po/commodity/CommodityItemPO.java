package SIMSclient.src.po.commodity;

import java.io.Serializable;

/*
 * һ����Ʒ��¼
 */
public class CommodityItemPO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String model;  //��Ʒ�ͺ�
	private int number;  //��Ʒ����
	private double price;
	private double sum;  //�ܶ�
	private String remark;  //��ע
	
	
	public CommodityItemPO(String id, String name, String model, int number, double price, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.number = number;
		this.price = price;
		this.sum = number * price;
		this.remark = remark;
	}

	public CommodityItemPO(String id, String name, int number, double price, String remark) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.price = price;
		this.sum = price * number;
		this.remark = remark;
	}
	
	public CommodityItemPO(String id, int number, double price) {
		this.id = id;
		this.number = number;
		this.price = price;
		this.sum = price * number;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getModel() {
		return model;
	}
	public int getNumber() {
		return number;
	}
	public double getPrice() {
		return price;
	}
	public double getSum() {
		return sum;
	}
	public String getRemark() {
		return remark;
	}

	
}
