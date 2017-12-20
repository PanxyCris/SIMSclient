package dataenum.findtype;

public enum FindPaymentBillType {

	ID("���ݱ��"),
	ACCOUNT("�����˻�"),
	TOTAL("�ܶ�"),
	OPERATOR("����Ա");

	public final String value;

	FindPaymentBillType(String value){
		this.value = value;
	}

	public static FindPaymentBillType getType(String value){
		switch(value){
		case "���ݱ��":return ID;
		case "�����˻�":return ACCOUNT;
		case "�ܶ�":return TOTAL;
		default:return OPERATOR;
		}
	}
}
