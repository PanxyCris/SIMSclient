package SIMSclient.src.dataenum;

public enum UserRole {

	INVENTORY_MANAGER("��������Ա"),
	PUR_SALE_MANAGER("����������Ա"),
	FINANCIAL_MANAGER("������Ա"),
	GENERAL_MANAGER("�ܾ���"),
	USER_MANAGER("�û�����Ա");

	public final String value;

	UserRole(String value) {
		this.value = value;
	}

}
