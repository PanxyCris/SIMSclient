package bussinesslogic;
/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ1ÈÕ    
*/

import java.util.ArrayList;

import po.commodity.CommodityItemPO;
import vo.commodity.CommodityItemVO;

public class CommodityItemTran {

	public static ArrayList<CommodityItemPO> VOtoPO(ArrayList<CommodityItemVO> vo) {
		ArrayList<CommodityItemPO> itemPO = new ArrayList<>();
		for(CommodityItemVO c : vo) {
			CommodityItemPO po = new CommodityItemPO();
			itemPO.add(po);
		}
		return itemPO;
	}
	
	public static ArrayList<CommodityItemVO> POtoVO(ArrayList<CommodityItemPO> po) {
		ArrayList<CommodityItemVO> itemVO = new ArrayList<>();
		for(CommodityItemPO c : po) {
			CommodityItemVO vo = new CommodityItemVO();
			itemVO.add(vo);
		}
		return itemVO;
	}
}
