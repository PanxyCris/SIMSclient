package dataenum.findtype;
/**     
*  
* @author Lijie 
* @date 2017��12��3��    
*/
public enum FindAccountType {

	ID("�˻�ID"),
	NAME("�˻�����"),
	MONEY("�˻����");
	
	public final String value;

	FindAccountType(String value) {
		this.value = value;
	}
}
