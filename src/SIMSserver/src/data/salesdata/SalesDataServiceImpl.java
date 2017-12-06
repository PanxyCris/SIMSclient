package SIMSserver.src.data.salesdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataservice.salesdataservice.SalesDataService;
import SIMSserver.src.po.SalesPO;

public class SalesDataServiceImpl extends UnicastRemoteObject implements SalesDataService{
	private static final long serialVersionUID = 1L;
	Sales sale = new Sales();

	protected SalesDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage createTable() throws RemoteException {
		try {
			sale.createTable();;
			return ResultMessage.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	@Override
	public ResultMessage insert(SalesPO po) throws RemoteException {
		try {
			sale.insert(po);
			return ResultMessage.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(SalesPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<SalesPO> show() throws RemoteException {
		return null;
	}


	@Override
	public void init() throws RemoteException {
	}

	@Override
	public String getID() throws RemoteException {
		return null;
	}

	@Override
	public SalesPO find(String ID) throws RemoteException {
		try {
			return sale.find(ID);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getSaleID() throws RemoteException {
		return null;
	}

	@Override
	public String getSaleBackID() throws RemoteException {
		return null;
	}

	
} 

