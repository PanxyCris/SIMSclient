package dataenum.findtype;
/**
*
* @author Lijie
* @date 2017��12��2��
*/
public enum FindCommodityType {

	ID("ID"),
	NAME("��Ʒ����"),
	MODEL("�ͺ�"),
	CLASSIFICATION("����"),
	NUMBER("�������"),
	PURPRICE("����"),
	RETAILEDPRICE("���ۼ�"),
	RECENTPURPRICE("�������"),
	RECENTRETAILEDPRICE("������ۼ�"),
	WARMINGVALUE("����ֵ");

	public final String value;

     FindCommodityType(String value) {
		this.value = value;
	}

     public static FindCommodityType getType(String value){
    	 switch(value){
    	 case "ID":return ID;
    	 case "��Ʒ����":return NAME;
    	 case "�ͺ�":return MODEL;
    	 case "����":return CLASSIFICATION;
    	 case "�������":return NUMBER;
    	 case "����":return PURPRICE;
    	 case "���ۼ�":return RETAILEDPRICE;
    	 case "�������":return RECENTPURPRICE;
    	 case "������ۼ�":return RECENTRETAILEDPRICE;
    	 default:return WARMINGVALUE;
    	 }
     }
}
