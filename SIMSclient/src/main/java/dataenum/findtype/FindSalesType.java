package dataenum.findtype;

/**
 *
 * @author Lijie
 * @date 2017��12��9��
 */
public enum FindSalesType {

	ID("���ݱ��"), MEMBER("�ͻ�"), OPERATOR("����Ա"), SALEMAN("ҵ��Ա"), TOTAL("�ܶ�");

	public final String value;

	FindSalesType(String value) {
		this.value = value;
	}

	public static FindSalesType getType(String value) {
		switch (value) {
		case "���ݱ��":
			return ID;
		case "�ͻ�":
			return MEMBER;
		case "����Ա":
			return OPERATOR;
		case "ҵ��Ա":
			return SALEMAN;
		default:
			return TOTAL;
		}
	}
}
