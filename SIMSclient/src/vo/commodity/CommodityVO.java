package vo.commodity;

public class CommodityVO {

		private String id;   //��Ʒ���
		private String name;
		private String model; //��Ʒ�ͺ�
		private ClassificationVO classification;
		private String number; //��Ʒ����
		private String purPrice; //����
		private String retailedPrice; //���ۼ�
		private String recentPurPrice; //���½���
		private String recentRetailedPrice; //�������ۼ�
		private String warmingValue; //����ֵ

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

		public void setNumber(String number){
			this.number = number;
		}

		public String getNumber(){
			return number;
		}

	    public void setPurPrice(String purPrice){
	    	this.purPrice = purPrice;
	    }

		public String getPurPrice(){
			return purPrice;
		}

		public void setRetailedPrice(String retailedPrice){
			this.retailedPrice = retailedPrice;
		}

		public String getRetailedPrice(){
			return retailedPrice;
		}

		public void setRecentPurPrice(String recentPurPrice){
			this.recentPurPrice = recentPurPrice;
		}

		public String getRecentPurPrice(){
			 return recentPurPrice;
		}

		public void setRecentRetailedPrice(String recentRetailedPrice){
			this.recentRetailedPrice = recentRetailedPrice;
		}

		public String getRecentRetailedPrice(){
			return recentRetailedPrice;
		}

		public void setWarmingValue(String warmingValue){
			this.warmingValue = warmingValue;
		}

		public String getWarmingValue(){
			return warmingValue;
		}




}
