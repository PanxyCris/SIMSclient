package vo.commodityvo;

public class CommodityStockVO {
	private String id;   //��Ʒ���
	private String name;
	private String model; //��Ʒ�ͺ�
	private Integer number; //��Ʒ����
	private Double avgRetailedPrice; //������
	private Double avgPurPrice;//���ۼ�
	private Integer line;//�к�
	
	public CommodityStockVO(String id,String name,String model,Integer number,Double avgRetailedPrice,Double avgPurPrice,Integer line){
		this.id=id;
		this.name=name;
		this.model=model;
		this.number=number;
		this.avgRetailedPrice=avgRetailedPrice;
		this.avgPurPrice=avgPurPrice;
		this.line=line;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public Double getAvgRetailedPrice() {
		return avgRetailedPrice;
	}

	public void setAvgRetailedPrice(Double avgRetailedPrice) {
		this.avgRetailedPrice = avgRetailedPrice;
	}

	public Double getAvgPurPrice() {
		return avgPurPrice;
	}

	public void setAvgPurPrice(Double avgPurPrice) {
		this.avgPurPrice = avgPurPrice;
	}
	
	
	
}
