package dataenum.findtype;

public enum FindPurchaseType {

	ID("���ݱ��"),
	MEMBER("�ͻ�"),
	OPERATOR("����Ա"),
	TOTAL("�ܶ�");

	public final String value;

	FindPurchaseType(String value) {
		this.value = value;
	}

	public static FindPurchaseType getType(String value){
		switch(value){
		case "���ݱ��":return ID;
		case "�ͻ�":return MEMBER;
		case "����Ա":return OPERATOR;
		default:return TOTAL;
		}
	}

}
