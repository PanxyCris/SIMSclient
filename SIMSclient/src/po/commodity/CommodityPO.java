package po.commodity;

import java.io.Serializable;
import java.sql.Date;

import po.ClassificationPO;
import po.PersistObject;

public class CommodityPO implements Serializable{

	private static final long serialVersionUID = -6035519417985941664L;
	private String id;   //商品编号
	private String name;
	private String model; //商品型号
	private ClassificationPO classification;
	private Integer number; //商品数量
	private Double purPrice; //进价
	private Double retailedPrice; //零售价
	private Double recentPurPrice; //最新进价
	private Double recentRetailedPrice; //最新零售价
	private Double averagePrice;//库存均价
	private Integer batch;//批次
	private String batchNumber;//批号
	private Date productionDate;//出厂日期
	private Integer warmingValue; //警戒值

	public CommodityPO(String id,String name,String model,ClassificationPO classification,
			Integer number,Double purPrice,Double retailedPrice,Integer batch,String batchNumber,
			Date productionDate,Integer warmingValue){
		this.id = id;
		this.name = name;
		this.model = model;
		this.classification = classification;
		this.number = number;
		this.purPrice = purPrice;
		this.recentPurPrice  = purPrice;
		this.retailedPrice = retailedPrice;
		this.recentRetailedPrice = retailedPrice;
		this.averagePrice = purPrice;
		this.batch = batch;
		this.batchNumber = batchNumber;
		this.productionDate = productionDate;
		this.warmingValue = warmingValue;
	}

	public String getID(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

    public void setModel(String model){
    	this.model = model;
    }

	public String getModel(){
		return model;
	}

	public void setClassification(ClassificationPO classification){
		this.classification = classification;
	}

	public ClassificationPO getClassification(){
		return classification;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public Integer getNumber(){
		return number;
	}


	public Double getPurPrice(){
		return purPrice;
	}

	public Double getRetailedPrice(){
		return retailedPrice;
	}

	public void setRecentPurPrice(Double recentPurPrice){
		this.recentPurPrice = recentPurPrice;
		this.averagePrice = recentPurPrice;
	}

	public Double getRecentPurPrice(){
		 return recentPurPrice;
	}

	public void setRecentRetailedPrice(Double recentRetailedPrice){
		this.recentRetailedPrice = recentRetailedPrice;
	}

	public Double getRecentRetailedPrice(){
		return recentRetailedPrice;
	}

	public Double getAveragePrice(){
		return averagePrice;
	}

	public Integer getBatch(){
		return batch;
	}

	public String getBatchNumber(){
		return batchNumber;
	}

	public Date getProductionDate(){
		return productionDate;
	}

	public void setWarmingValue(Integer warmingValue){
		this.warmingValue = warmingValue;
	}

	public Integer getWarmingValue(){
		return warmingValue;
	}
	@Override
	public String toString() {
		return id + "," + name + "," + model + "," + number + "," + purPrice + "," + retailedPrice + ","
				+ recentPurPrice + "," + recentRetailedPrice + "," + warmingValue;
	}
}