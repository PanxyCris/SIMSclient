package dataenum;

public enum MoneyType {

	SALES("������"), COMMODITY("��Ʒ��");

	public final String value;

	MoneyType(String value) {
		this.value = value;
	}

	public static MoneyType getType(String value) {
		switch (value) {
		case "������":
			return SALES;
		default:
			return COMMODITY;
		}
	}

}
