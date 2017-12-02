package SIMSclient.src.vo;


/**
 * 
* @ClassName: ValueObject 
* @Description: 数据对象 
 */
public class ValueObject {

	public String id;
	public String date;
	
	@Override
	public String toString() {
		return "[ID=" + this.id + "]";
	}
}
