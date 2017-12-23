package bussinesslogicservice.utilityblservice;

import java.util.*;

import dataenum.BillType;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;

public interface UtilityBLService {

	public boolean isPrintLegal(ArrayList<String> list);

	public String generateID(BillType billType);

	public ArrayList<MessageVO> getMessage(UserVO user);

	public boolean hasMessage(UserVO user);

}
