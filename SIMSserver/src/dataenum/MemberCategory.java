package dataenum;
/**     
*  
* @author Lijie 
* @date 2017��12��2��    
*/
public enum MemberCategory {

	RETAILER("������"),
	SUPPLIER("������"),
	BOTH("������&������");
	
	public final String value;

	MemberCategory(String value) {
		this.value = value;
	}
	
}
