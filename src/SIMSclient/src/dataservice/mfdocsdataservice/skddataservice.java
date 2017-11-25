package SIMSclient.src.dataservice.mfdocsdataservice;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSserver.src.po.makefinancialdoc.SKDPO;

public interface skddataservice {
	
	public ResultMessage newBuild(SKDPO skdPO);
	
	public ResultMessage modify(SKDPO skdPO);
	
	public ResultMessage delete(SKDPO skdPO);
	
	public SKDPO find(String message);
	
	public ResultMessage commit(SKDPO skdPO);
	
}
