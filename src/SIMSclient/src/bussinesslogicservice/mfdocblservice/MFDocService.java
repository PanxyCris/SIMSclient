package SIMSclient.src.bussinesslogicservice.mfdocblservice;

import SIMSclient.src.vo.bill.BillVO;
import SIMSclient.src.vo.makefinancialdoc.FinancialDocVO;
import SIMSclient.src.vo.makefinancialdoc.SKDVO;
import SIMSclient.src.vo.makefinancialdoc.XJFYDVO;

public interface MFDocService {
	
	public SKDVO newBuildSKD();//新建
	
	public XJFYDVO newBuildXJFYD();
	
	public boolean delete(FinancialDocVO financialDocVO);//删除
	
	public SKDVO modifySKD();//修改
	
	public XJFYDVO modifyXJFYD();
	
	public SKDVO recordSKD(BillVO billVO);//入账
	
	public XJFYDVO recordXJFYD(BillVO billVO);
	
}
