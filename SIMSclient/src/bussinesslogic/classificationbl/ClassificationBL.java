package bussinesslogic.classificationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.commodityblservice.ClassificationBLService;
import dataenum.ResultMessage;
import dataservice.classificationdataservice.ClassificationDataService;
import po.ClassificationVPO;
import rmi.RemoteHelper;

public class ClassificationBL implements ClassificationBLService {

	private ClassificationDataService classificationDataService;

	public ClassificationBL() {
		classificationDataService=RemoteHelper.getInstance().getClassificationDataService();
	}

	@Override
	public String getID() {//用于生成新创建的商品分类的id
		try {
			return classificationDataService.getId();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<String> showName() {
		nameList=new ArrayList<>();
		ClassificationVPO root=getRoot();
		addName(root);
		return nameList;
	}

	@Override
	public ResultMessage insert(ClassificationVPO vpo) {
		try {
			return classificationDataService.insertClassification(vpo);
		} catch (RemoteException e) {
			e.printStackTrace();

		}
		return ResultMessage.FAIL;
	}

	@Override
	public void delete(ClassificationVPO vpo) {
		String id=vpo.getName();
		try {
			classificationDataService.deleteClassification(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultMessage update(ClassificationVPO vpo) {
		try {
			return classificationDataService.updateClassification(vpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ClassificationVPO getClass(String name) {
		try {
			return classificationDataService.findClassification(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ClassificationVPO getRoot() {
		try {
			ClassificationVPO root = classificationDataService.getRoot();
//		    addChildren(root);
			return root;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	static ArrayList<String> nameList=null;

	public void addName(ClassificationVPO classificationVPO){
		ArrayList<ClassificationVPO> childrenVPOs=classificationVPO.getChildren();
		nameList.add(classificationVPO.getName());
		if(childrenVPOs!=null||classificationVPO.getB()==false){
		for (int i = 0; i < childrenVPOs.size(); i++) {
			addName(childrenVPOs.get(i));
			}
		}
	}

	public void addChildren(ClassificationVPO vpo) throws RemoteException{
		ArrayList<ClassificationVPO> children = new ArrayList<>();
		for(ClassificationVPO po:classificationDataService.show()){
		  if(po.getFather()!=null)
			if(po.getFather().equals(vpo.getName()))
				children.add(po);
		}
		if(children!=null){
		vpo.setChildren(children);
		for(ClassificationVPO child:vpo.getChildren())
			addChildren(child);
		}
	}

}
