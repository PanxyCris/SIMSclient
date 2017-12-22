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

	public ArrayList<String> getAllChildrenClass();//�����������ӽڵ�����ӽڵ�Ϊ����ķ���

	public ClassificationVO getClass(String name);

	public ClassificationVO getRoot();

}
