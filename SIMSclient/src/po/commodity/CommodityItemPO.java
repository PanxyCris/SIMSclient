package po.commodity;
/**     
*  
* @author Lijie 
* @date 2017��12��2��    
*/
public class CommodityItemPO {

	private String id;
	private String name;
	private String model;
	private int number;
	private double price;
	private double total;
	private String remark;

	public CommodityItemPO(String ID, String name, String model, int number, double price, String remark) {
		this.id = ID;
		this.name = name;
		this.model = model;
		this.number = number;
		this.price = price;
		this.remark = remark;
		this.total = number * price;
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

	public double getTotal() {
		return total;
	}

	public String getRemark() {
		return remark;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
