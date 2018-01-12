package dataenum.findtype;

public enum FindSaleScheduleType {

	NAME("��Ʒ��"),
	MEMBER("�ͻ�"),
	OPERATOR("ҵ��Ա"),
	WAREHOUSE("�ֿ�");

	public final String value;

	FindSaleScheduleType(String value){
		this.value = value;
	}

	public static FindSaleScheduleType getType(String value){
		switch(value){
		case "��Ʒ��":return NAME;
		case "�ͻ�":return MEMBER;
		case "ҵ��Ա":return OPERATOR;
		default:return WAREHOUSE;
		}
	}
}
