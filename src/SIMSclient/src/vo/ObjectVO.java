package SIMSclient.src.vo;

public class ObjectVO {

	public String ID;
	public String date;
	
	
	
	/**
	 * @param iD
	 * @param date
	 */
	public ObjectVO(String iD, String date) {
		super();
		ID = iD;
		this.date = date;
	}



	@Override
	public String toString() {
		return "[ID=" + ID + ", Date= " + date + "]";
	}
}
