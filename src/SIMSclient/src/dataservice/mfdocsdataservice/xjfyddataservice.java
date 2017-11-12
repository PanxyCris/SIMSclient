package SIMSclient.src.dataservice.mfdocsdataservice;

import SIMSclient.src.ResultMessage;
import SIMSserver.src.po.makefinancialdoc.XJFYDPO;

public interface xjfyddataservice {
	public ResultMessage newBuild(XJFYDPO xjfydPO);
	
	public ResultMessage modify(XJFYDPO xjfydPO);
	
	public ResultMessage delete(XJFYDPO xjfydPO);
	
	public XJFYDPO find(String message);
	
	public ResultMessage commit(XJFYDPO xjfydPO);
	
}
