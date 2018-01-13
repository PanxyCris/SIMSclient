package dataenum.findtype;

public enum FindBillType {

	ID("���ݱ��"), TYPE("��������"), NAME("��Ʒ��"), ACCOUNT("�����˻�"), MEMBER("��Ա"), SALEMAN("ҵ��Ա"), TOTAL("�ܶ�"), OPERATOR("����Ա");

	public final String value;

	FindBillType(String value) {
		this.value = value;
	}

	public static FindBillType getType(String value) {
		switch (value) {
		case "���ݱ��":
			return ID;
		case "��������":
			return TYPE;
		case "��Ʒ��":
			return NAME;
		case "�����˻�":
			return ACCOUNT;
		case "��Ա":
			return MEMBER;
		case "�ܶ�":
			return TOTAL;
		case "����Ա":
			return OPERATOR;
		default:
			return SALEMAN;
		}
	}

}
