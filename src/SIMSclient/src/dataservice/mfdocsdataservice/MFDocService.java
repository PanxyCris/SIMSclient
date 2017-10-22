package SIMSclient.src.dataservice.mfdocsdataservice;

import SIMSclient.src.po.BillPO;
import SIMSclient.src.po.makefinancialdoc.FinancialDocPO;
import SIMSclient.src.po.makefinancialdoc.SKDPO;
import SIMSclient.src.po.makefinancialdoc.XJFYDPO;

public interface MFDocService {
	
	public SKDPO newBuildSKD();//新建
	
	public XJFYDPO newBuildXJFYD();
	
	public boolean delete(FinancialDocPO financialDocPO);//删除
	
	public SKDPO modifySKD();//修改
	
	public XJFYDPO modifyXJFYD();
	
	public SKDPO recordSKD(BillPO billPO);//入账
	
	public XJFYDPO recordXJFYD(BillPO billPO);
	
	
}
