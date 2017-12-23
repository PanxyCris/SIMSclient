package bussinesslogic.utilitybl;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillType;

public class UtilityBL implements UtilityBLService{

	private static final int BILLIDNUMBERLENGTH=5;//���ݱ���е�����Ŀ���Ե��ַ�������
	
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
	public String generateID(BillType billType) {//numberΪ��������Ŀǰ�����͵��ݵ���Ŀ
		String id="";
		
		String type=billType.prefix;
				
		Date date=new Date();
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
		
		String now=simpleDateFormat.format(date);
		
		
		
		String num=Integer.toString(1);//how to get current bills number?
		
		
		
		int numLength=num.length();
		for (int i = 0; i < BILLIDNUMBERLENGTH-numLength; i++) {
			num="0"+num;
		}
		
		id=type+"-"+now+"-"+num;
		
		return id;
	}
	
	
	
}
