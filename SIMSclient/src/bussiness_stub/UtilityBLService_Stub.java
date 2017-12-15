package bussiness_stub;

import java.util.ArrayList;

import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillType;

public class UtilityBLService_Stub implements UtilityBLService {

	@Override
	public boolean isPrintLegal(ArrayList<String> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String generateID(BillType billType) {
		// TODO Auto-generated method stub
		return "15615156";
	}

}
