package vo.billvo.inventorybillvo;

import dataenum.BillState;

import dataenum.BillType;
import vo.billvo.BillVO;

public class InventoryBillVO extends BillVO{

     protected String name;
     protected Integer number;

	public InventoryBillVO(String id,String name,Integer number,BillType billType, BillState billState,String note) {
		super(id,billType, billState,note);
		this.name = name;
		this.number = number;
	}

	public String getName(){
		return name;
	}

	public Integer getNumber(){
		return number;
	}

	public void setNumber(Integer number){
		this.number = number;
	}


}
