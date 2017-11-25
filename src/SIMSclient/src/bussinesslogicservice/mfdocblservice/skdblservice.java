package SIMSclient.src.bussinesslogicservice.mfdocblservice;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.makefinancialdoc.SKDVO;

public interface skdblservice {
	
	public ResultMessage newBuild(SKDVO skdVO);
	
	public ResultMessage modify(SKDVO skdVO);
	
	public ResultMessage delete(SKDVO skdVO);
	
	public SKDVO find(String message);
	
	public ResultMessage commit(SKDVO skdVO);
	
}
