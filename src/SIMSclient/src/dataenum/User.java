package SIMSclient.src.dataenum;

public enum User {

	STOCK_MANAGER("��������Ա"), 
	PUR_SALE_MANAGER("����������Ա"), 
	FINANCIAL_MANAGER("������Ա"), 
	GENERAL_MANAGER("�ܾ���"), 
	ADMIN("����Ա");

	public final String value;

	User(String value) {
		this.value = value;
	}

}
