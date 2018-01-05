package test.purchase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.purchasebl.PurchaseController;
import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import dataenum.findtype.FindSalesType;
import vo.billvo.purchasebillvo.PurchaseVO;


/**     
*  
* @author Lijie 
* @date 2018年1月5日    
*/
public class testType {

	private PurchaseBLService service;
	private PurchaseVO vo;
	
	public testType() {
		service = new PurchaseController();
	}
	
	@Before
	public void init() throws Exception {
//		vo = new PurchaseVO("JHD-20171218-00002", "王灿灿", Warehouse.WAREHOUSE2,"王灿灿", commodities, note, sum, BillType.PURCHASEBILL, BillState.COMMITED);
	}
	
	@Test
	public void test() throws Exception {
//		System.out.println(service.getPurchaseID());
		
		
		assertEquals("JHD-20180105-00001", service.getPurchaseID());
	}
}
