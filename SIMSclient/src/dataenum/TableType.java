package dataenum;

public enum TableType {
	BUSINESS_HISTORY_SCHEDULE("��Ӫ���̱�"),SALE_SCHEDULE("������ϸ��"),STATEMENT_OF_OPERATION("��Ӫ�����");

	public final String value;

	TableType(String value) {
		this.value = value;
	}

	public static TableType getType(String value){
		switch(value){
		case "��Ӫ���̱�":return TableType.BUSINESS_HISTORY_SCHEDULE;
		case "������ϸ��":return TableType.SALE_SCHEDULE;
		case "��Ӫ�����":return TableType.STATEMENT_OF_OPERATION;
		default:return TableType.STATEMENT_OF_OPERATION;
		}
	}

}
