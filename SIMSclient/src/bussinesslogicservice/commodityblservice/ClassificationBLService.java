package bussinesslogicservice.commodityblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import po.ClassificationVPO;


public interface ClassificationBLService {
	
	public String getID();
	
	public ResultMessage insert(ClassificationVPO vo);
	
	public void delete(ClassificationVPO vo);
	
	public ResultMessage update(ClassificationVPO vo);
	
	public ArrayList<ClassificationVPO> show();
	
	public ArrayList<String> showName();
	
	public ClassificationVPO getClass(String name);
	
	public ClassificationVPO getRoot();
	
}
