package SIMSserver.src.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import SIMSserver.src.data.accountdata.AccountDataServiceMySqlImpl;
import SIMSserver.src.data.billdata.BillData;
import SIMSserver.src.data.userdata.UserDataServiceImpl;
import SIMSserver.src.dataenum.BillState;
import SIMSserver.src.dataenum.BillType;
import SIMSserver.src.dataenum.PromotionType;
import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataenum.findtype.FindAccountType;
import SIMSserver.src.dataenum.findtype.FindCommodityType;
import SIMSserver.src.dataenum.findtype.FindMemberType;
import SIMSserver.src.dataenum.findtype.FindUserType;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.dataservice.accountdataservice.AccountDataService;
import SIMSserver.src.dataservice.billdataservice.BillDataService;
import SIMSserver.src.dataservice.checktabledataservice.BusinessHistoryScheduleDataService;
import SIMSserver.src.dataservice.checktabledataservice.SaleScheduleDataService;
import SIMSserver.src.dataservice.checktabledataservice.StatementOfOperationDataService;
import SIMSserver.src.dataservice.commoditydataservice.CommodityDataService;
import SIMSserver.src.dataservice.memberdataservice.MemberDataService;
import SIMSserver.src.dataservice.mfdocsdataservice.PaymentBillDataService;
import SIMSserver.src.dataservice.mfdocsdataservice.ReceiptDataService;
import SIMSserver.src.dataservice.promotiondataservice.PromotionDataService;
import SIMSserver.src.dataservice.purchasedataservice.PurchaseDataService;
import SIMSserver.src.dataservice.salesdataservice.SalesDataService;
import SIMSserver.src.dataservice.userdataservice.UserDataService;
import SIMSserver.src.po.AccountPO;
import SIMSserver.src.po.MemberPO;
import SIMSserver.src.po.PersistObject;
import SIMSserver.src.po.PromotionPO;
import SIMSserver.src.po.PurchasePO;
import SIMSserver.src.po.SalesPO;
import SIMSserver.src.po.UserPO;
import SIMSserver.src.po.commodity.CommodityPO;
import SIMSserver.src.po.makefinancialdoc.FinancialDocPO;
import SIMSserver.src.po.makefinancialdoc.PaymentBillPO;
import SIMSserver.src.po.makefinancialdoc.ReceiptBillPO;
import SIMSserver.src.po.table.BusinessHistorySchedulePO;
import SIMSserver.src.po.table.SaleSchedulePO;
import SIMSserver.src.po.table.StatementOfOperationPO;

/**
 *
 * @author ���Ӳ�
 * @version 2017-11-28
 */

/**
 *
 * @ClassName: DataRemoteObject
 * @Description: ���ݲ����ɾ�Ĳ��ͨ�ò���
 * @author lijie
 * @date 2017��12��3�� ����7:00:46
 *
 */
public class DataRemoteObject extends UnicastRemoteObject implements UserDataService {

	private static final long serialVersionUID = 4029039744279087114L;

	private UserDataService user;

	public DataRemoteObject() throws RemoteException {

		user = new UserDataServiceImpl();
	}


	@Override
	public ResultMessage insert(UserPO po) throws RemoteException {
		return user.insert(po);
	}


	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return user.delete(ID);
	}


	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
		return user.update(po);
	}


	@Override
	public ArrayList<UserPO> show() throws RemoteException {
		return user.show();
	}


	@Override
	public ResultMessage createTable() throws RemoteException {
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
	public boolean login(String id, String password) throws RemoteException {
		return user.login(id, password);
	}


	@Override
	public ArrayList<UserPO> find(String info, FindUserType type) throws RemoteException {
		return user.find(info, type);
	}

}