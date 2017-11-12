package SIMSserver.src.dataservice.mfdocsdataservice;

import SIMSclient.src.ResultMessage;
import SIMSserver.src.po.makefinancialdoc.SKDPO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年11月12日    
*/
public interface skddataservice {

public ResultMessage newBuild(SKDPO skdPO);
	
	public ResultMessage modify(SKDPO skdPO);
	
	public ResultMessage delete(SKDPO skdPO);
	
	public SKDPO find(String message);
	
	public ResultMessage commit(SKDPO skdPO);
	
}
