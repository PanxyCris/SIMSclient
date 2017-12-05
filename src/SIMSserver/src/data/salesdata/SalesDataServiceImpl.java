package SIMSserver.src.data.salesdata;

import java.util.ArrayList;

import SIMSserver.src.po.SalesPO;

public class SalesDataServiceImpl {

	public void insert(SalesPO po) throws Exception {
		Sales sale = new Sales();
		sale.insert(po);
	}
	
	public void delete(String id) throws Exception {
		Sales sale = new Sales();
		sale.delete(id);
	}
	
	public void update(SalesPO po) throws Exception {
		
	}
	
	public ArrayList<SalesPO> finds() throws Exception {
		return null;
	}
	
	public ArrayList<SalesPO> find(String keyword) throws Exception {
		return null;
	}
} 

