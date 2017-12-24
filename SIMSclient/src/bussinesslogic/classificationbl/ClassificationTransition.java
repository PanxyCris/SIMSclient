package bussinesslogic.classificationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.classificationdataservice.ClassificationDataService;
import po.ClassificationPO;
import vo.commodityvo.ClassificationVO;

public class ClassificationTransition {
	
	ClassificationDataService classificationDataService;
	ClassificationVO classificationVO;
	ClassificationPO classificationPO;
	
	public ClassificationPO VOtoPO(ClassificationVO classificationVO){
		String id=classificationVO.getID();
		String name=classificationVO.getName();
		Boolean b=classificationVO.getB();
		String fatherName=classificationVO.getFather().getName();
		ArrayList<String> childrenName=new ArrayList<>();
		ArrayList<ClassificationVO> classificationVOs=classificationVO.getChildren();
		for (int i = 0; i < classificationVOs.size(); i++) {
			childrenName.add(classificationVOs.get(i).getName());
		}
		classificationPO=new ClassificationPO(id, name, b, fatherName, childrenName);
		
		return classificationPO;
	}
	
	public ClassificationVO POtoVO(ClassificationPO classificationPO){
		String id=classificationPO.getId();
		String name=classificationPO.getName();
		Boolean b=classificationPO.getB();
		try {
			ArrayList<ClassificationPO> cPo=classificationDataService.findClassification(name);
			for (int i = 0; i < cPo; i++) {
				
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		
		
		return classificationVO;
	}
	
}
