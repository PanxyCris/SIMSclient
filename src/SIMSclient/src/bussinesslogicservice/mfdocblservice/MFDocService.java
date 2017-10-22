package SIMSclient.src.bussinesslogicservice.mfdocblservice;

import SIMSclient.src.vo.bill.BillVO;
import SIMSclient.src.vo.makefinancialdoc.FinancialDocVO;
import SIMSclient.src.vo.makefinancialdoc.SKDVO;
import SIMSclient.src.vo.makefinancialdoc.XJFYDVO;

public interface MFDocService {
	
	public SKDVO newBuildSKD();//�½�
	
	public XJFYDVO newBuildXJFYD();
	
	public boolean delete(FinancialDocVO financialDocVO);//ɾ��
	
	public SKDVO modifySKD();//�޸�
	
	public XJFYDVO modifyXJFYD();
	
	public SKDVO recordSKD(BillVO billVO);//����
	
	public XJFYDVO recordXJFYD(BillVO billVO);
	
}
