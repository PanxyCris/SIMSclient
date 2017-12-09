package dataenum;

public enum MemberLevel {

	LEVEL1("һ��"),
	LEVEL2("����"),
	LEVEL3("����"),
	LEVEL4("�ļ�"),
	LEVEL5("�弶");

	public final String value;

	MemberLevel(String value) {
		this.value = value;
	}

	public static MemberLevel getLevel(String value){
		switch(value){
		case "һ��":return LEVEL1;
		case "����":return LEVEL2;
		case "����":return LEVEL3;
		case "�ļ�":return LEVEL4;
		default:return LEVEL5;
		}
	}
}