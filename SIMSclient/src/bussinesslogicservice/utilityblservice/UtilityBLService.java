package bussinesslogicservice.utilityblservice;

import java.util.*;

import dataenum.BillType;

public interface UtilityBLService {

	public boolean isPrintLegal(ArrayList<String> list);
	
	public String generateID(BillType billType,int number);

}
