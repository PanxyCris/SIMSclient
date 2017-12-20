package dataenum.findtype;

public enum FindPaymentBillType {

	ID("单据编号"),
	ACCOUNT("银行账户"),
	TOTAL("总额"),
	OPERATOR("操作员");

	public final String value;

	FindPaymentBillType(String value){
		this.value = value;
	}

	public static FindPaymentBillType getType(String value){
		switch(value){
		case "单据编号":return ID;
		case "银行账户":return ACCOUNT;
		case "总额":return TOTAL;
		default:return OPERATOR;
		}
	}
}
