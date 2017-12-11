package bussinesslogic.salesbl;

import java.rmi.RemoteException;

import bussinesslogic.commoditybl.Info.CommodityInfo;
import bussinesslogicservice.salesblservice.Sale_CommodityInfo;

/*
 * ���۵��ĳ�����Ʒ�嵥��ϸ����Ŀ
 * ���۵�ͨ��������ϵͳ�Զ����Ŀͻ���Ӧ��Ӧ���Ϳ������
 * ���,
 * ���ƣ�����Ʒѡ�����ѡ��,
 * �ͺ�,
 * �������ֹ����룩,
 * ���ۣ�Ĭ��Ϊ��Ʒ��Ϣ������ۼۣ����޸ģ�,
 * ���Զ����ɣ�����Ʒ��ע
 */
public class SalesLineItem {

	private String id;
	private String name;
	private String model;  //��Ʒ�ͺ�
	private int number;  //��Ʒ����
	private double price;
	private double sum;  //�ܶ�
	private String remark;  //��ע
	private Sale_CommodityInfo info;
	
	public SalesLineItem() {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param model
	 * @param numbers
	 * @param price
	 * @param sum
	 * @param remark
	 */
	public SalesLineItem(String id, int number, double price, String remark) throws RemoteException {
		super();
		info = new CommodityInfo();
		this.id = id;
		this.name = info.getName(id);
		this.model = info.getModel(id);
		this.number = number;
		this.price = price;
		this.sum = number * price;
		this.remark = remark;
		info.setDelete(id, false);
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
