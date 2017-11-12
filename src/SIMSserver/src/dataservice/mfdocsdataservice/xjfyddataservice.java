package SIMSserver.src.dataservice.mfdocsdataservice;

import SIMSclient.src.ResultMessage;
import SIMSserver.src.po.makefinancialdoc.XJFYDPO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年11月12日    
*/
public interface xjfyddataservice {

public ResultMessage newBuild(XJFYDPO xjfydPO);
	
	public ResultMessage modify(XJFYDPO xjfydPO);
	
	public ResultMessage delete(XJFYDPO xjfydPO);
	
	public XJFYDPO find(String message);
	
	public ResultMessage commit(XJFYDPO xjfydPO);
}
