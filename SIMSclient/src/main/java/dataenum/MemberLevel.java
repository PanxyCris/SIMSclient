package dataenum;

public enum MemberLevel {

	LEVEL1("һ��", 1), LEVEL2("����", 2), LEVEL3("����", 3), LEVEL4("�ļ�", 4), LEVEL5("�弶", 5);

	public final String value;
	public final int num;

	MemberLevel(String value, int num) {
		this.value = value;
		this.num = num;
	}

	public static MemberLevel getLevel(String value) {
		switch (value) {
		case "һ��":
			return LEVEL1;
		case "����":
			return LEVEL2;
		case "����":
			return LEVEL3;
		case "�ļ�":
			return LEVEL4;
		default:
			return LEVEL5;
		}
	}
}