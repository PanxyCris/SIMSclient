package SIMSserver.src.po.commodity;

import SIMSserver.src.po.ClassificationPO;
import SIMSserver.src.po.PersistObject;

public class CommodityPO extends PersistObject {

	private static final long serialVersionUID = 1L;
	private String name;
	private String model; // ��Ʒ�ͺ�
	private ClassificationPO classification;
	private int number; // ��Ʒ����
	private double purPrice; // ����
	private double retailedPrice; // ���ۼ�
	private double recentPurPrice; // ���½���
	private double recentRetailedPrice; // �������ۼ�
	private int warmingValue; // ����ֵ

	/**
	 * @Description: TODO(������һ�仰�����������������) @param @param id @param @param
	 * name @param @param model @param @param classification @param @param
	 * number @param @param purPrice @param @param retailedPrice @param @param
	 * warmingValue �趨�ļ� @return �������� @throws
	 */
	public CommodityPO(String id, String name, String model, ClassificationPO classification, int number,
			double purPrice, double retailedPrice, int warmingValue) {
		super(id);
		this.name = name;
		this.model = model;
		this.classification = classification;
		this.number = number;
		this.purPrice = purPrice;
		this.retailedPrice = retailedPrice;
		this.warmingValue = warmingValue;
	}

	public ClassificationPO getClassification() {
		return classification;
	}

	public void setClassification(ClassificationPO classification) {
		this.classification = classification;
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

	public double getPurPrice() {
		return purPrice;
	}

	public double getRetailedPrice() {
		return retailedPrice;
	}

	public double getRecentPurPrice() {
		return recentPurPrice;
	}

	public double getRecentRetailedPrice() {
		return recentRetailedPrice;
	}

	public int getWarmingValue() {
		return warmingValue;
	}
	
	
	public void setRecentPurPrice(double recentPurPrice) {
		this.recentPurPrice = recentPurPrice;
	}

	public void setRecentRetailedPrice(double recentRetailedPrice) {
		this.recentRetailedPrice = recentRetailedPrice;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + model + "," + number + "," + purPrice + "," + retailedPrice + ","
				+ recentPurPrice + "," + recentRetailedPrice + "," + warmingValue;
	}
}