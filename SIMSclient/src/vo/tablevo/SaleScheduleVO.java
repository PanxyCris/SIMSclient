package vo.tablevo;

import java.time.LocalDate;
import dataenum.Warehouse;

public class SaleScheduleVO {

	private LocalDate date;//ʱ��
	private String name;//��Ʒ��
	private String customer;//�ͻ�
	private String clerkID;//ҵ��Ա
	private Warehouse warehouse;
	private String warehouseString;//�ֿ�

	public SaleScheduleVO(LocalDate d,String name,String cu,String cl,Warehouse w){
		this.date = d;
		this.name = name;
		customer = cu;
		clerkID = cl;
		warehouse =w;
		warehouseString = w.value;
	}

	public LocalDate getDate() {
		return date;
	}


	public String getCustomer() {
		return customer;
	}

	public String getClerkID() {
		return clerkID;
	}


	public Warehouse getWarehouse() {
		return warehouse;
	}


	public String getWarehouseString() {
		return warehouseString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
