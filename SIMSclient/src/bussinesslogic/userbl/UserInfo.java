package bussinesslogic.userbl;

import dataenum.UserRole;
import po.UserPO;

/**     
*  
* @author Lijie 
* @date 2017��12��11��    
*/
public class UserInfo {
	private UserPO po;

	public String getOperator() {
		return po.getName();
	}
	
	public UserRole getRole() {
		return po.getRole();
	}
}
