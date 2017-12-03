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
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijie
 * @date 2017年12月3日 下午7:00:46
 *
 */
public class DataRemoteObject extends UnicastRemoteObject
		implements AccountDataService, BillDataService, BusinessHistoryScheduleDataService, SaleScheduleDataService,
		StatementOfOperationDataService, CommodityDataService, MemberDataService, ReceiptDataService,
		PaymentBillDataService, PromotionDataService, PurchaseDataService, SalesDataService {

	private static final long serialVersionUID = 4029039744279087114L;
	private AccountDataService accountDataService;
	private BillDataService billDataService;
	private BusinessHistoryScheduleDataService businessHistoryScheduleDataService;
	private SaleScheduleDataService saleScheduleDataService;
	private StatementOfOperationDataService statementOfOperationDataService;
	private CommodityDataService commodityDataService;
	private MemberDataService memberDataService;
	private ReceiptDataService receiptDataService;
	private PaymentBillDataService paymentBillDataService;
	private PromotionDataService promotionDataService;
	private PurchaseDataService purchaseDataService;
	private SalesDataService salesDataService;

	protected DataRemoteObject() throws RemoteException {
		accountDataService = new AccountDataServiceMySqlImpl();
		billDataService = new BillData();
	}

	@Override
	public ResultMessage insert(AccountPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(AccountPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<AccountPO> show() throws RemoteException {
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
	public ResultMessage insert(BusinessHistorySchedulePO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(BusinessHistorySchedulePO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(SaleSchedulePO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(SaleSchedulePO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(StatementOfOperationPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(StatementOfOperationPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(CommodityPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(CommodityPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(MemberPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(MemberPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(ReceiptBillPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(ReceiptBillPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(PaymentBillPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(PaymentBillPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(PromotionPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(PromotionPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(PurchasePO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(PurchasePO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(SalesPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(SalesPO po) throws RemoteException {
		return null;
	}

	@Override
	public SalesPO find(String ID) throws RemoteException {
		return null;
	}

	@Override
	public String getSaleID() throws RemoteException {
		return null;
	}

	@Override
	public String getSaleBackID() throws RemoteException {
		return null;
	}

	@Override
	public String getPurchaseID() throws RemoteException {
		return null;
	}

	@Override
	public String getPurchaseBackID() throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionPO> show(PromotionType type) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<ReceiptBillPO> show(BillType type) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<MemberPO> find(String keyword, FindMemberType type) throws RemoteException {
		return null;
	}

	@Override
	public String getID(String fatherID) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<String> getAllID() throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<CommodityPO> find(String keywords, FindCommodityType type) throws RemoteException {
		return null;
	}

	@Override
	public void viewRport(StatementOfOperationPO statementOfOperationPO) {
	}

	@Override
	public void viewReport(SaleSchedulePO saleSchedulePO) {
	}

	@Override
	public FinancialDocPO viewReport(BusinessHistorySchedulePO businessHistorySchedulePO) {
		return null;
	}

	@Override
	public void exportReport() {
	}

	@Override
	public void writeOff() {
	}

	@Override
	public void writeOffAndCopy(PersistObject billPO) {
	}

	@Override
	public Date getDate() {
		return null;
	}

	@Override
	public BillType getType() {
		return null;
	}

	@Override
	public BillState getState() {
		return null;
	}

	@Override
	public ArrayList<AccountPO> find(String keywords, FindAccountType type) throws RemoteException {
		return null;
	}

	
}
