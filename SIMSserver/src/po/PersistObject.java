package po;

import java.text.SimpleDateFormat;
import java.util.Date;

/**     
*  
* @author Lijie 
* @date 2017��12��2��    
*/
public class PersistObject {
	private static final long serialVersionUID = 1L;
	protected String date;
	protected String id;
	
	
	public PersistObject() {
		
	}
	
	/*
	 *�Զ����ɵ��ݱ�ź����� 
	 */
	public PersistObject(String id) {
		this.id = id;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		date = sdf.format(new Date());
	}

	public void setID(String id) {
		this.id = id;
	}
	public String getID(){
		return id;
	}

	public String getDate() {
		return this.date;
	}

}
