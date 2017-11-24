package SIMSclient.src.dataenum;

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
}
