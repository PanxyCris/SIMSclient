package dataenum;
/**     
*  
* @author Lijie 
* @date 2017��12��2��    
*/
public enum MemberLevel {

	LEVEL1("һ��"),
	LEVEL2("����"),
	LEVEL3("����"),
	LEVEL4("�ļ�"),
	LEVEL5("�弶");
	
	public final String value;
	
	MemberLevel(String value) {
		this.value = value;
	}
}
