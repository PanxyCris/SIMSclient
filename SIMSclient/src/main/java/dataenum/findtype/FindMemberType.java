package dataenum.findtype;
/**
*  ģ�������û�������
* @author Lijie
* @date 2017��12��2��
*/
public enum FindMemberType {

	ID("�ͻ�ID"),
	KIND("�ͻ����"),
	LEVEL("�ͻ�����"),
	NAME("�ͻ�����"),
	PHONE("�ͻ��绰"),
	ADDRESS("�ͻ���ַ"),
	POST("�ͻ��ʱ�"),
	EMAIL("�ͻ�����"),
	RECEIVABLELIMIT("Ӧ�ն��"),
	RECEIVABLE("Ӧ��"),
	PAYABLE("Ӧ��"),
	SALESMAN("Ĭ��ҵ��Ա");

	public final String value;

	FindMemberType(String value) {
		this.value = value;
	}

	public static FindMemberType getMemberType(String value){
		switch(value){
		case "�ͻ�ID":return ID;
		case "�ͻ����":return KIND;
		case "�ͻ�����":return LEVEL;
		case "�ͻ�����":return NAME;
		case "�ͻ��绰":return PHONE;
		case "�ͻ���ַ":return ADDRESS;
		case "�ͻ��ʱ�":return POST;
		case "�ͻ�����":return EMAIL;
		case "Ӧ�ն��":return RECEIVABLELIMIT;
		case "Ӧ��":return RECEIVABLE;
		case "Ӧ��":return PAYABLE;
		default:return SALESMAN;
		}
	}


}
