package SIMSclient.src.dataenum;

public enum User {

	STOCK_MANAGER("库存管理人员"), 
	PUR_SALE_MANAGER("进货销售人员"), 
	FINANCIAL_MANAGER("财务人员"), 
	GENERAL_MANAGER("总经理"), 
	ADMIN("管理员");

	public final String value;

	User(String value) {
		this.value = value;
	}

}
