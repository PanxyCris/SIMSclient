package SIMSclient.src.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.BillPO;

/*
 * ���������ݲ㸸��
 * �������ݵ���ɾ�Ĳ�
 */
public interface DataService<PO extends BillPO> extends Remote{

	/*��ʼ�����ݲ�ӿ�*/
	public void init() throws RemoteException;
	
	public String getID() throws RemoteException;
	
	
	/*
	 * ������PO����ɾ��
	 */
	public ResultMessage insert(PO po) throws RemoteException;
	
	public ResultMessage delete(String ID) throws RemoteException;
	
	public ResultMessage update(PO po) throws RemoteException;
	
	public PO find(String ID) throws RemoteException;
	
	public ArrayList<PO> show() throws RemoteException;
}

