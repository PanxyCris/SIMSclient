package dataenum.findtype;

public enum FindReceiptBillType {

	ID("���ݱ��"),
	MEMBER("��Ա"),
	ACCOUNT("�����˻�"),
	TOTAL("�ܶ�"),
	OPERATOR("����Ա");

	public final String value;

	FindReceiptBillType(String value){
		this.value = value;
	}

	public static FindReceiptBillType getType(String value){
		switch(value){
		case "���ݱ��":return ID;
		case "��Ա":return MEMBER;
		case "�����˻�":return ACCOUNT;
		case "�ܶ�":return TOTAL;
		default:return OPERATOR;
		}
	}

}
