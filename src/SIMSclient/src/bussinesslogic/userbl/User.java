package SIMSclient.src.bussinesslogic.userbl;
/**     
*  
* @author Lijie 
* @date 2017��11��26��    
*/

import SIMSclient.src.IOHelper;
import SIMSclient.src.dataservice.userdataservice.UserDataService;
import SIMSclient.src.po.UserPO;

public class User {

	private UserDataService userData;
	private UserPO currentUser; //��ǰ�û�
	private IOHelper<UserPO> userName;  
	private IOHelper<UserPO> userInfo;
	
	static {
		
	}
	
}
