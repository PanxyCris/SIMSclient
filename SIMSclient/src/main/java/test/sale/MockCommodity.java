package test.sale;

import bussinesslogic.commoditybl.CommodityBL;

/**     
*  
* @author Lijie 
* @date 2018��1��12��    
*/
public class MockCommodity extends CommodityBL  {

	String ID;
	String type;
	

	public MockCommodity(String ID, String type){
		this.ID = ID;
		this.type = type;
	}
	
	public String getID(String name){
		return ID;
	}
	
	public String getType(String name){
		return type;
	}
}
