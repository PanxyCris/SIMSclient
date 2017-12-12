package vo.commodity;

public class CommodityItemVO {

	private String id;
	private String name;
	private String model;
	private String number;
	private String price;
	private String total;
	private String remark;

	public CommodityItemVO(String ID, String name, String model, String number, String price, String remark) {
		this.id = ID;
		this.name = name;
		this.model = model;
		this.number = number;
		this.price = price;
		this.remark = remark;
		this.total = String.valueOf(Double.parseDouble(price) * Integer.parseInt(number));
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

	public String getNumber() {
		return number;
	}

	public String getPrice() {
		return price;
	}

	public String getTotal() {
		return total;
	}

	public String getRemark() {
		return remark;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setTotal(String total){
		this.total = total;
	}



}
