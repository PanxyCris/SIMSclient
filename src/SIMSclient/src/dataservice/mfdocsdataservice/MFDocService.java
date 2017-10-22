package SIMSclient.src.dataservice.mfdocsdataservice;

import SIMSclient.src.po.BillPO;
import SIMSclient.src.po.makefinancialdoc.FinancialDocPO;
import SIMSclient.src.po.makefinancialdoc.SKDPO;
import SIMSclient.src.po.makefinancialdoc.XJFYDPO;

public interface MFDocService {
	
	public SKDPO newBuildSKD();//�½�
	
	public XJFYDPO newBuildXJFYD();
	
	public boolean delete(FinancialDocPO financialDocPO);//ɾ��
	
	public SKDPO modifySKD();//�޸�
	
	public XJFYDPO modifyXJFYD();
	
	public SKDPO recordSKD(BillPO billPO);//����
	
	public XJFYDPO recordXJFYD(BillPO billPO);
	
	
}
