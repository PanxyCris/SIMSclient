package SIMSclient.src.vo;


/**
 * 
* @ClassName: ValueObject 
* @Description: ���ݶ��� 
 */
public class ValueObject {

	public String id;
	public String date;
	
	@Override
	public String toString() {
		return "[ID=" + this.id + "]";
	}
}
