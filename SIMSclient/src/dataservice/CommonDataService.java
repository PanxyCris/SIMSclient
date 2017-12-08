package dataservice;

import java.rmi.RemoteException;

import java.util.ArrayList;

import dataenum.ResultMessage;
import po.PersistObject;


/**
*  ͨ�õ����ݲ�ӿڣ��������ݵ���ɾ�Ĳ�
* @author Lijie
* @date 2017��12��2��
*/
public interface CommonDataService<PO extends PersistObject> extends DataService<PO> {

	public ResultMessage insert(PO po) throws RemoteException;
	public ResultMessage delete(String ID) throws RemoteException;
	public ResultMessage update(PO po) throws RemoteException;
	public ArrayList<PO> show() throws RemoteException;
}
