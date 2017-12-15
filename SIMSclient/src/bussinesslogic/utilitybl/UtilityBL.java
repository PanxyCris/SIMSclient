package bussinesslogic.utilitybl;

import java.sql.Date;
import java.util.ArrayList;

import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillType;

public class UtilityBL implements UtilityBLService{

	private static UtilityBL utilityBL = new UtilityBL();
	public static UtilityBL getInstance(){
		return utilityBL;
	}

	public UtilityBLService getUtilityBLService(){
		return (UtilityBLService)utilityBL;
	}

	@Override
	public boolean isPrintLegal(ArrayList<String> list) {
		return false;
	}

	@Override
	public String generateID(BillType billType) {
		String id="";
		
		String type=billType.prefix;
		
		
		
		return id;
	}
	
	
	
}
