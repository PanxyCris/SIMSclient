package bussinesslogicservice.utilityblservice;

import java.util.*;

import dataenum.BillType;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;

public interface UtilityBLService {

	public boolean isPrintLegal(ArrayList<String> list);

	public String generateID(BillType billType);
    /**
     * 通过用户信息得到该用户的最新信息
     * @param user
     * @return
     */
	public ArrayList<MessageVO> getMessage(UserVO user);
   /**
    * 判断给用户是否拥有最新信息
    * @param user
    * @return
    */
	public boolean hasMessage(UserVO user);

}
