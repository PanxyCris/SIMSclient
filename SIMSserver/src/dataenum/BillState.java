package dataenum;
/**     
*  
* @author Lijie 
* @date 2017��12��2��    
*/
public enum BillState {


	DRAFT("�ݸ�״̬"), COMMITED("���ύ״̬"), SUCCESS("�����ɹ�"), FAIL("����ʧ��");

	public final String value;

	BillState(String value) {
		this.value = value;
	}
}
