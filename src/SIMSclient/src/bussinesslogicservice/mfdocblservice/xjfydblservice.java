package SIMSclient.src.bussinesslogicservice.mfdocblservice;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.vo.makefinancialdoc.XJFYDVO;

public interface xjfydblservice {

	public ResultMessage newBuild(XJFYDVO xjfydVO);
	
	public ResultMessage modify(XJFYDVO xjfydVO);
	
	public ResultMessage delete(XJFYDVO xjfydVO);
	
	public XJFYDVO find(String message);
	
	public ResultMessage commit(XJFYDVO xjfydVO);
	
}
