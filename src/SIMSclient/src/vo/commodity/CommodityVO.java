package SIMSclient.src.vo.commodity;

public class CommodityVO {

		private int id;   //商品编号
		private String name;
		private String model; //商品型号
		private String classification;
		private int number; //商品数量
		private double purPrice; //进价
		private double retailedPrice; //零售价
		private double recentPurPrice; //最新进价
		private double recentRetailedPrice; //最新零售价
		private int warmingValue; //警戒值

		public void setID(int id){
			this.id = id;
		}

		public int getID(){
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

		public void setClassification(String classification){
			this.classification = classification;
		}

		public String getClassification(){
			return classification;
		}

		public void setNumber(int number){
			this.number = number;
		}

		public int getNumber(){
			return number;
		}

	    public void setPurPrice(double purPrice){
	    	this.purPrice = purPrice;
	    }

		public double getPurPrice(){
			return purPrice;
		}

		public void setRetailedPrice(double retailedPrice){
			this.retailedPrice = retailedPrice;
		}

		public double getRetailedPrice(){
			return retailedPrice;
		}

		public void setRecentPurPrice(double recentPurPrice){
			this.recentPurPrice = recentPurPrice;
		}

		public double getRecentPurPrice(){
			 return recentPurPrice;
		}

		public void setRecentRetailedPrice(double recentRetailedPrice){
			this.recentRetailedPrice = recentRetailedPrice;
		}

		public double getRecentRetailedPrice(){
			return recentRetailedPrice;
		}

		public void setWarmingValue(int warmingValue){
			this.warmingValue = warmingValue;
		}

		public int getWarmingValue(){
			return warmingValue;
		}
		
		


}
