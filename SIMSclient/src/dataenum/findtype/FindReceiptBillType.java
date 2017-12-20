package dataenum.findtype;

public enum FindReceiptBillType {

	ID("单据编号"),
	MEMBER("会员"),
	ACCOUNT("银行账户"),
	TOTAL("总额"),
	OPERATOR("操作员");

	public final String value;

	FindReceiptBillType(String value){
		this.value = value;
	}

	public static FindReceiptBillType getType(String value){
		switch(value){
		case "单据编号":return ID;
		case "会员":return MEMBER;
		case "银行账户":return ACCOUNT;
		case "总额":return TOTAL;
		default:return OPERATOR;
		}
	}

}
