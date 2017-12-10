package dataenum;

public enum BillType {

	INVENTORYGIFTBILL("������͵�", "KCZSD"),
	INVENTORYLOSSBILL("��汨��", "KCBSD"),
	INVENTORYREVENUEBILL("��汨�絥", "KCBYD"),
	INVENTORYWARNINGBILL("��汨����", "KCBJD"),
	SALESBILL("���۵�", "XSD"),
	PURCHASEBILL("������", "JHD"),
	SALESBACKBILL("�����˻���", "XSTHD"),
	PURCHASEBACKBILL("�����˻���", "JHTHD"),
	SKD("�տ", "SKD"),
	XJFYD("���", "FKD");

	public final String value;
	public final String prefix;

	BillType(String value, String prefix){
		this.value = value;
		this.prefix = prefix;
	}

	public static BillType getType(String value){
		switch(value){
		case "������͵�":return BillType.INVENTORYGIFTBILL;
		case "��汨��":return BillType.INVENTORYLOSSBILL;
		case "��汨�絥":return BillType.INVENTORYREVENUEBILL;
		case "��汨����":return BillType.INVENTORYWARNINGBILL;
		case "���۵�":return BillType.SALESBILL;
		case "������":return BillType.PURCHASEBILL;
		case "�����˻���":return BillType.SALESBACKBILL;
		case "�����˻���":return BillType.PURCHASEBACKBILL;
		case "�տ":return BillType.SKD;
		case "���":return BillType.XJFYD;
		default:return BillType.XJFYD;
		}
	}
}
