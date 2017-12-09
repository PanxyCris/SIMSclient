package dataenum;

public enum MemberCategory {

	RETAILER("������"),
	SUPPLIER("������"),
	BOTH("������&������");

	public final String value;

	MemberCategory(String value) {
		this.value = value;
	}

	public static MemberCategory getCategory(String value){
		switch(value){
		case "������":return RETAILER;
		case "������":return SUPPLIER;
		default:return BOTH;
		}
	}


}
