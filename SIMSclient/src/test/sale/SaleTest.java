package test.sale;

import static org.junit.Assert.*;

import org.junit.Test;

import bussinesslogic.salesbl.SalesController;

/**     
*  
* @author Lijie 
* @date 2018Äê1ÔÂ12ÈÕ    
*/
public class SaleTest {

	@Test
	public void test() {
		MockCommodity commodity1 = new MockCommodity("a1", "SQQ");
		MockCommodity commodity2 = new MockCommodity("a2", "RRE");

		SalesController contoll = new SalesController();
		assertEquals(200.0 , 200.0);
	}

}
