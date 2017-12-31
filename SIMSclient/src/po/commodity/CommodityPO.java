package po.commodity;

import java.io.Serializable;

public class CommodityPO implements Serializable{

	private static final long serialVersionUID = -6035519417985941664L;
	private String id;
	private String name;
	private String model; // ��Ʒ�ͺ�
	private String classification;
	private Integer number; // ��Ʒ����
	private Double purPrice; // ����
	private Double retailedPrice; // ���ۼ�
	private Double recentPurPrice; // ���½���
	private Double recentRetailedPrice; // �������ۼ�
	private Integer warmingValue; // ����ֵ


	public CommodityPO(String id, String name, String model, String classification, int number,
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setID(String id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public void setPurPrice(Double purPrice) {
		this.purPrice = purPrice;
	}


	public void setRetailedPrice(Double retailedPrice) {
		this.retailedPrice = retailedPrice;
	}


	public void setRecentPurPrice(Double recentPurPrice) {
		this.recentPurPrice = recentPurPrice;
	}


	public void setRecentRetailedPrice(Double recentRetailedPrice) {
		this.recentRetailedPrice = recentRetailedPrice;
	}


	public void setWarmingValue(Integer warmingValue) {
		this.warmingValue = warmingValue;
	}


	public String getID() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getModel() {
		return model;
	}


	public String getClassification() {
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


	public void setClassification(String classification) {
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