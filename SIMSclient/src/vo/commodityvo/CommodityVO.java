package vo.commodityvo;

public class CommodityVO {

		private String id;   //��Ʒ���
		private String name;
		private String model; //��Ʒ�ͺ�
		private String classification;
		private Integer number; //��Ʒ����
		private Double purPrice; //����
		private Double retailedPrice; //���ۼ�
		private Double recentPurPrice; //���½���
		private Double recentRetailedPrice; //�������ۼ�
		private Integer warmingValue; //����ֵ
		private Integer line;//�к�

		public CommodityVO(String id,String name,String model,String classification,
				int number,double purPrice, double retailedPrice,int warmingValue){
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


		public double getPurPrice(){
			return purPrice;
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

		public Integer getLine() {
			return line;
		}


		public void setLine(Integer line) {
			this.line = line;
		}

}
