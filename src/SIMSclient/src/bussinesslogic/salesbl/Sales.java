package SIMSclient.src.bussinesslogic.salesbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import SIMSclient.src.po.BillPO.BillType;
import SIMSclient.src.po.sales.SalesPO;
import SIMSclient.src.vo.sale.CommodityItemVO;
import SIMSclient.src.vo.sale.SalesVO;
import SIMSclient.src.dataservice.salesdataservice.SalesDataService;

public class Sales {

	private SalesPO po;
	private BillType type;
	private String ID;
	private ArrayList<String> commodityNames = new ArrayList<>();  
	private ArrayList<Integer> commodityNumber = new ArrayList<>();
	private SalesList list = new SalesList();
	private SalesDataService saleData;
	
	public Sales() {
		
	}
	
	public String getSaleID() throws RemoteException {
        this.type = BillType.SALESBILL;
        this.ID = this.saleData.getSaleID();
        return this.ID;
    }

    public String getSaleBackID() throws RemoteException {
        this.type = BillType.SALESBACKBILL;
        this.ID = this.saleData.getSaleBackID();
        return this.ID;
    }
    
    public void addCommodities(CommodityItemVO vo) throws RemoteException {
        SalesLineItem item = new SalesLineItem(vo.name, vo.number, vo.price, vo.remark);
        this.list.add(item);
        this.commodityNames.add(vo.name);
        this.commodityNumber.add(vo.number);
    }
    
    public SalesVO save() {
		return null;
    	
    }
    
    public SalesVO submit() {
		return null;
    	
    }
}
