package dataenum.findtype;
/**     
*  
* @author Lijie 
* @date 2017��12��9��    
*/
public enum FindSalesType {

	ID("���ݱ��"),
	CLIENT("�ͻ�"),
	OPERATOR("����Ա"),
	SALEMAN("ҵ��Ա"),
	SUM("�ܶ�");
	
	public final String value;
	
	FindSalesType(String value) {
		this.value = value;
	}
}
