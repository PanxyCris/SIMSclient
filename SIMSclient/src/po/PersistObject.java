package SIMSclient.src.po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
* @ClassName: PersistObject 
* @Description: �־û�����PO�Ĺ�������
* @author lijie
* @date 2017��11��28�� ����8:21:54 
*
 */
public class PersistObject implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String date;
	protected String id;
	
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
