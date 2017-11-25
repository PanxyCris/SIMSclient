package SIMSclient.src.dataenum;

public enum UserRole {

	INVENTORY_MANAGER("库存管理人员"),
	PUR_SALE_MANAGER("进货销售人员"),
	FINANCIAL_MANAGER("财务人员"),
	GENERAL_MANAGER("总经理"),
	USER_MANAGER("用户管理员");

	public final String value;

	UserRole(String value) {
		this.value = value;
	}

}
