package vo.commodity;

public class CommodityVO {

		private String id;   //��Ʒ���
		private String name;
		private String model; //��Ʒ�ͺ�
		private ClassificationVO classification;
		private Integer number; //��Ʒ����
		private Double purPrice; //����
		private Double retailedPrice; //���ۼ�
		private Double recentPurPrice; //���½���
		private Double recentRetailedPrice; //�������ۼ�
		private Integer warmingValue; //����ֵ

		public CommodityVO(String id,String name,String model,ClassificationVO classification,
				int number,double purPrice,double retailedPrice,int warmingValue){
			this.id = id;
			this.name = name;
			this.model = model;
			this.classification = classification;
			this.number = number;
			this.purPrice = purPrice;
			this.recentPurPrice  = purPrice;
			this.retailedPrice = retailedPrice;
			this.recentRetailedPrice = retailedPrice;
			this.warmingValue = warmingValue;
		}

		public void setID(String id){
			this.id = id;
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

		public void setClassification(ClassificationVO classification){
			this.classification = classification;
		}

		public ClassificationVO getClassification(){
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
