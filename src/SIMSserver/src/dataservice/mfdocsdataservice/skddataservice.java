package SIMSserver.src.dataservice.mfdocsdataservice;

import SIMSclient.src.ResultMessage;
import SIMSserver.src.po.makefinancialdoc.SKDPO;

/**  
* ��˵��   
*  
* @author ****  
* @date 2017��11��12��    
*/
public interface skddataservice {

public ResultMessage newBuild(SKDPO skdPO);
	
	public ResultMessage modify(SKDPO skdPO);
	
	public ResultMessage delete(SKDPO skdPO);
	
	public SKDPO find(String message);
	
	public ResultMessage commit(SKDPO skdPO);
	
}
