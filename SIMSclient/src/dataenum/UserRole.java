package dataenum;

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

	public static UserRole getRole(String value){
		switch(value){
		case "��������Ա":return UserRole.INVENTORY_MANAGER;
		case "����������Ա":return UserRole.PUR_SALE_MANAGER;
		case "������Ա":return UserRole.FINANCIAL_MANAGER;
		case "�ܾ���":return UserRole.GENERAL_MANAGER;
		case "�û�����Ա":return UserRole.USER_MANAGER;
		default:return UserRole.USER_MANAGER;
		}
	}

}
