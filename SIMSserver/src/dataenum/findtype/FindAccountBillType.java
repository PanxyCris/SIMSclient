package dataenum.findtype;
/**     
*  
* @author Lijie 
* @date 2017��12��14��    
*/
public enum FindAccountBillType {
	PAYMENTBILL("���"),RECEIPTBILL("�տ");

	public final String value;

	FindAccountBillType(String value) {
		this.value = value;
	}
}
