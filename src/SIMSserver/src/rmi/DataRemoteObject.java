package SIMSserver.src.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import SIMSserver.src.data.accountdata.AccountDataServiceMySqlImpl;
import SIMSserver.src.data.billdata.BillData;
import SIMSserver.src.dataenum.BillState;
import SIMSserver.src.dataenum.BillType;
import SIMSserver.src.dataenum.PromotionType;
import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataenum.findtype.FindAccountType;
import SIMSserver.src.dataenum.findtype.FindCommodityType;
import SIMSserver.src.dataenum.findtype.FindMemberType;
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
import SIMSserver.src.po.AccountPO;
import SIMSserver.src.po.MemberPO;
import SIMSserver.src.po.PersistObject;
import SIMSserver.src.po.PromotionPO;
import SIMSserver.src.po.PurchasePO;
import SIMSserver.src.po.SalesPO;
import SIMSserver.src.po.commodity.CommodityPO;
import SIMSserver.src.po.makefinancialdoc.FinancialDocPO;
import SIMSserver.src.po.makefinancialdoc.PaymentBillPO;
import SIMSserver.src.po.makefinancialdoc.ReceiptBillPO;
import SIMSserver.src.po.table.BusinessHistorySchedulePO;
import SIMSserver.src.po.table.SaleSchedulePO;
import SIMSserver.src.po.table.StatementOfOperationPO;

/**
 * 
 * @author 王灿灿
 * @version 2017-11-28
 */

/**
 * 
 * @ClassName: DataRemoteObject
 * @Description: 数据层的增删改查等通用操作
 * @author lijie
 * @date 2017年12月3日 下午7:00:46
 *
 */
public class DataRemoteObject<PO extends PersistObject> extends UnicastRemoteObject implements CommonDataService<PO> {

	private static final long serialVersionUID = 4029039744279087114L;
	

	protected DataRemoteObject() throws RemoteException {
		
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
	public PO find(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(PersistObject po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(PersistObject po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PO> show() throws RemoteException {
		return null;
	}

		
}
