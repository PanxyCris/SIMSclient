package SIMSclient.src.dataenum;
/**     
*  
* @author Lijie 
* @date 2017��12��3��    
*/
public enum PromotionType {

	LEVEL_PROMOTION("�ȼ�����"),
	PRICEPACKS("�ؼ۰�"),
	SUM_PROMOTION("�ܼ۴���");
	
	public final String value;
	PromotionType(String value) {
		this.value = value;
	}
}
