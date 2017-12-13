package po;

import java.io.Serializable;

/**
 * 
* @ClassName: PromotionPO 
* @author lijie 
* @date 2017��12��13�� ����5:31:20 
*
 */
public class PromotionPO implements Serializable{

	private static final long serialVersionUID = -1444427916106388960L;
	private String id;
	private String beginDate;
	private String endDate;
	

	public PromotionPO(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}
