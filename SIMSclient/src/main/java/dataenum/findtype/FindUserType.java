package dataenum.findtype;

public enum FindUserType {
	ID("ID"), NAME("�û���"), USERROLE("ְ��");

	public final String value;

	FindUserType(String value) {
		this.value = value;
	}

	public static FindUserType getType(String value) {
		switch (value) {
		case "ID":
			return ID;
		case "�û���":
			return NAME;
		default:
			return USERROLE;
		}
	}
}
