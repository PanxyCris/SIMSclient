package bussinesslogicservice.utilityblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.commoditypo.CommodityPO;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;

public interface UtilityBLService {

	public boolean isPrintLegal(ArrayList<String> list);

	/**
	 * ͨ���û���Ϣ�õ����û���������Ϣ
	 * 
	 * @param user
	 * @return
	 */
	public ArrayList<MessageVO> getMessage(UserVO user);

	/**
	 * �жϸ��û��Ƿ�ӵ��������Ϣ
	 * 
	 * @param user
	 * @return
	 */
	public boolean hasMessage(UserVO user);

	/**
	 * ����Ʒ���ٵ�ʱ�����ж�һ���Ƿ�ﵽ����ֵ
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public void warningMessage(CommodityPO po) throws RemoteException;

	public void saveMessage(MessageVO message) throws RemoteException;

}
