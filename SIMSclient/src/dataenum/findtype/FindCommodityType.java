package dataenum.findtype;
/**
*
* @author Lijie
* @date 2017��12��2��
*/
public enum FindCommodityType {

	ID("��ƷID"),
	NAME("��Ʒ����"),
	MODEL("��Ʒ����"),
	CLASSIFICATION("��Ʒ����"),
	NUMBER("��Ʒ����"),
	PURPRICE("����"),
	RETAILEDPRICE("���ۼ�"),
	RECENTPURPRICE("�������"),
	RECENTRETAILEDPRICE("������ۼ�");

	public final String value;

	private FindCommodityType(String value) {
		this.value = value;
	}
}
