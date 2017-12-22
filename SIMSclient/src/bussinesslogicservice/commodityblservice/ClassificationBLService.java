package bussinesslogicservice.commodityblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;

import vo.commodityvo.ClassificationVO;

public interface ClassificationBLService {

	public String getID();

	public ResultMessage insert(ClassificationVO vo);

	public void delete(ClassificationVO vo);

	public ResultMessage update(ClassificationVO vo);

	public ArrayList<ClassificationVO> show();

	public ArrayList<String> getAllChildrenClass();//返回所有无子节点或者子节点为分类的分类

	public ClassificationVO getClass(String name);

	public ClassificationVO getRoot();

}
