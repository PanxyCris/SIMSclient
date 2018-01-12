package dataenum.findtype;
/**     
*  
* @author Lijie 
* @date 2017��12��14��    
*/
public enum FindAccountBillType {
	CUSTOMER("�ͻ�"),OPERATOR("����Ա"),BILLID("���ݱ��");

	public final String value;

	FindAccountBillType(String value) {
		this.value = value;
	}
	
	public FindAccountBillType getType(String value){
		switch(value){
		case "���ݱ��":return BILLID;
		case "�ͻ�":return CUSTOMER;
		default:return OPERATOR;
		}	
	}
}

