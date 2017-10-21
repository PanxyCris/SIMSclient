package SIMSclient.src.vo.bill;

public enum BillType {
	INVENTORY_GIFT("�������"),
	INVENTORY_BENEFIT("��汨��"),
	INVENTORY_LOSS("��汨��"),
	INVENTORY_WARN("��澯��"),

	RECEIVEMENT("�տ"), 
	PAYMENT("�տ"),

	STOCKING("������"),
	RETURNING("�˻���"), 
	SALES("���۵�");
	
	public final String value;

	BillType(String value) {
		this.value = value;
	}
}
