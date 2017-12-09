package dataenum.findtype;
/**
*
* @author Lijie
* @date 2017��12��3��
*/
public enum FindAccountType {

	ID("�˻�ID"),
	NAME("�˻�����");

	public final String value;

	FindAccountType(String value) {
		this.value = value;
	}

	public static FindAccountType getFindType(String value){
		switch(value){
		case "�˻�ID":return FindAccountType.ID;
		case "�˻�����":return FindAccountType.NAME;
		default:return FindAccountType.NAME;
		}
	}
}
