package bussinesslogicservice.commodityblservice;
import java.util.ArrayList;


import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import vo.commodityvo.ClassificationVO;
import vo.commodityvo.CommodityVO;

public interface CommodityBLService{

	public String getID() throws Exception;

	public ResultMessage insert(CommodityVO vo) throws Exception;

	public void delete(CommodityVO vo) throws Exception;

	public ResultMessage update(CommodityVO vo) throws Exception;

	public ArrayList<CommodityVO> find(String info,FindCommodityType properties) throws Exception;

	public ArrayList<CommodityVO> show() throws Exception;

	public ArrayList<String> getIDandName() throws Exception;

	public ClassificationVO getClass(String name) throws Exception;

	public ArrayList<String> getAllChildrenClass() throws Exception;//�����������ӽڵ�����ӽڵ�Ϊ��Ʒ�ķ������ƣ����ô�ID

	public void stock() throws Exception;   //����̵�
}
