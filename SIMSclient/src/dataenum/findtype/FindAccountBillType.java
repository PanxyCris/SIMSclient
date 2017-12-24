package dataenum.findtype;
/**     
*  
* @author Lijie 
* @date 2017年12月14日    
*/
public enum FindAccountBillType {
	PAYMENTBILL("付款单"),RECEIPTBILL("收款单");

	public final String value;

	FindAccountBillType(String value) {
		this.value = value;
	}
}
