package SIMSclient.src.dataenum.findtype;
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
}
