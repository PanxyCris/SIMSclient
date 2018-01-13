package bussinesslogicservice.examineblservice;
/**
*  �����ӿ�
* @author Lijie
* @date 2017��12��17��
*/

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import vo.billvo.BillVO;

public interface ExamineBLService<B extends BillVO> {

	public ResultMessage updateBill(B vo) throws RemoteException;

	public ResultMessage passBills(ArrayList<B> vos) throws RemoteException;

	public ResultMessage notPassBills(ArrayList<B> vos) throws RemoteException;

	public ArrayList<B> getCommitedBills() throws RemoteException;

	public ArrayList<B> find(String info, FindBillType type) throws RemoteException;// ���ύ�ĵ���

}
