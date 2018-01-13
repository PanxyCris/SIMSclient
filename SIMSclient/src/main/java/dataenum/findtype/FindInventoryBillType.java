package dataenum.findtype;

public enum FindInventoryBillType {

	ID("���ݱ��"), TYPE("��������"), NAME("��Ʒ��"), STATE("����״̬");

	public final String value;

	FindInventoryBillType(String value) {
		this.value = value;
	}

	public static FindInventoryBillType getType(String value) {
		switch (value) {
		case "���ݱ��":
			return ID;
		case "��������":
			return TYPE;
		case "��Ʒ��":
			return NAME;
		default:
			return STATE;
		}
	}

}
