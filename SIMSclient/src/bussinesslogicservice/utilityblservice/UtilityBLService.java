package bussinesslogicservice.utilityblservice;

import java.util.*;

import dataenum.BillType;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;

public interface UtilityBLService {

	public boolean isPrintLegal(ArrayList<String> list);

	public String generateID(BillType billType);
    /**
     * ͨ���û���Ϣ�õ����û���������Ϣ
     * @param user
     * @return
     */
	public ArrayList<MessageVO> getMessage(UserVO user);
   /**
    * �жϸ��û��Ƿ�ӵ��������Ϣ
    * @param user
    * @return
    */
	public boolean hasMessage(UserVO user);

}
