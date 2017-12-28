package po.commodity;

import java.io.Serializable;

import po.ClassificationVPO;

public class CommodityPO implements Serializable{

	private static final long serialVersionUID = -6035519417985941664L;
	private String id;
	private String name;
	private String model; // ��Ʒ�ͺ�
	private ClassificationVPO classification;
	private int number; // ��Ʒ����
	private double purPrice; // ����
	private double retailedPrice; // ���ۼ�
	private double recentPurPrice; // ���½���
	private double recentRetailedPrice; // �������ۼ�
	private int warmingValue; // ����ֵ


	public CommodityPO(String id, String name, String model, ClassificationVPO classification, int number,
			double purPrice, double retailedPrice, double recentPurPrice, double recentRetailedPrice, int warmingValue) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.classification = classification;
		this.number = number;
		this.purPrice = purPrice;
		this.retailedPrice = retailedPrice;
		this.warmingValue = warmingValue;
		this.recentPurPrice = recentPurPrice;
		this.recentRetailedPrice = recentRetailedPrice;
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


	public ClassificationVPO getClassification() {
		return classification;
	}


	public int getNumber() {
		return number;
	}

	public void setNumner(int number){
		this.number = number;
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


	public void setClassification(ClassificationVPO classification) {
		this.classification = classification;
	}


	public double getRecentRetailedPrice() {
		return recentRetailedPrice;
	}


	public int getWarmingValue() {
		return warmingValue;
	}

	public void setWarningValue(int warmingValue){
		this.warmingValue = warmingValue;
	}

}