package SIMSserver.src.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.AccountPO;
import SIMSclient.src.po.PersistObject;
import SIMSclient.src.po.makefinancialdoc.FinancialDocPO;
import SIMSclient.src.po.table.BusinessHistorySchedulePO;
import SIMSclient.src.po.table.SaleSchedulePO;
import SIMSclient.src.po.table.StatementOfOperationPO;
import SIMSclient.src.vo.AccountVO;
import SIMSclient.src.vo.PromotionVO;
import SIMSclient.src.vo.commodity.CommodityVO;
import SIMSclient.src.vo.member.MemberVO;
import SIMSclient.src.vo.purchase.PurchaseVO;
import SIMSclient.src.vo.sale.SalesAddVO;
import SIMSclient.src.vo.sale.SalesVO;
import SIMSserver.src.data.accountdata.AccountDataServiceMySqlImpl;
import SIMSserver.src.data.billdata.BillData;
import SIMSserver.src.dataservice.accountdataservice.AccountDataService;
import SIMSserver.src.dataservice.billdataservice.BillDataService;
import SIMSserver.src.dataservice.checktabledataservice.businessHistoryScheduleDataService;
import SIMSserver.src.dataservice.checktabledataservice.saleScheduleDataService;
import SIMSserver.src.dataservice.checktabledataservice.statementOfOperationDataService;
import SIMSserver.src.dataservice.commoditydataservice.CommodityDataService;
import SIMSserver.src.dataservice.memberdataservice.MemberDataService;
import SIMSserver.src.dataservice.mfdocsdataservice.skddataservice;
import SIMSserver.src.dataservice.mfdocsdataservice.xjfyddataservice;
import SIMSserver.src.dataservice.promotiondataservice.PromotionDataService;
import SIMSserver.src.dataservice.purchasedataservice.PurchaseDataService;
import SIMSserver.src.dataservice.salesdataservice.SalesDataService;
import SIMSserver.src.po.BillPO;
import SIMSserver.src.po.BillPO.BillState;
import SIMSserver.src.po.BillPO.BillType;
import SIMSserver.src.po.commodity.CommodityPO;
import SIMSserver.src.po.SalesPO;
import SIMSserver.src.po.makefinancialdoc.SKDPO;
import SIMSserver.src.po.makefinancialdoc.XJFYDPO;


/**
 * 
 * @author Íõ²Ó²Ó
 * @version 2017-11-28
 * 
 *
 */
public class DataRemoteObject extends UnicastRemoteObject implements AccountDataService,BillDataService,businessHistoryScheduleDataService,saleScheduleDataService,statementOfOperationDataService
,CommodityDataService,MemberDataService,skddataservice,xjfyddataservice,PromotionDataService,PurchaseDataService,SalesDataService{

	
	private static final long serialVersionUID = 4029039744279087114L;
	private AccountDataService accountDataService;
	private BillDataService billDataService;
	private businessHistoryScheduleDataService businessHistoryScheduleDataService;
	private saleScheduleDataService saleScheduleDataService;
	private statementOfOperationDataService statementOfOperationDataService;
	private CommodityDataService commodityDataService;
	private MemberDataService memberDataService;
	private skddataservice skddataservice;
	private xjfyddataservice xjfyddataservice;
	private PromotionDataService promotionDataService;
	private PurchaseDataService purchaseDataService;
	private SalesDataService salesDataService;
	
	protected DataRemoteObject() throws RemoteException {
		accountDataService=new AccountDataServiceMySqlImpl();
		billDataService=new BillData();
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
	public String getSaleID() {
		return null;
	}

	@Override
	public String getBackID() {
		return null;
	}

	@Override
	public void addCommodities(CommodityVO item) {
	}

	@Override
	public MemberVO getMember() {
		return null;
	}

	@Override
	public SalesVO submit(SalesAddVO Info) {
		return null;
	}

	@Override
	public SalesVO save(SalesAddVO Info) {
		return null;
	}

	@Override
	public String getPurchaseID() {
		return null;
	}

	@Override
	public String getPurBackID() {
		return null;
	}

	@Override
	public CommodityVO getCommodityByID(int ID) {
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getCommodityPromotionListByID(int commodityID) {
		return null;
	}

	@Override
	public PurchaseVO submit(PurchaseVO Info) {
		return null;
	}

	@Override
	public PurchaseVO save(PurchaseVO Info) {
		return null;
	}

	@Override
	public void endSales() {
	}

	@Override
	public ResultMessage newBuild(XJFYDPO xjfydPO) {
		return null;
	}

	@Override
	public ResultMessage modify(XJFYDPO xjfydPO) {
		return null;
	}

	@Override
	public ResultMessage delete(XJFYDPO xjfydPO) {
		return null;
	}

	@Override
	public ResultMessage commit(XJFYDPO xjfydPO) {
		return null;
	}

	@Override
	public ResultMessage newBuild(SKDPO skdPO) {
		return null;
	}

	@Override
	public ResultMessage modify(SKDPO skdPO) {
		return null;
	}

	@Override
	public ResultMessage delete(SKDPO skdPO) {
		return null;
	}

	@Override
	public ResultMessage commit(SKDPO skdPO) {
		return null;
	}

	@Override
	public String getID() {
		return null;
	}

	@Override
	public ArrayList<MemberVO> show() {
		return null;
	}

	@Override
	public ArrayList<MemberVO> fuzzySearch(String keyword) {
		return null;
	}

	@Override
	public MemberVO exactSearch(String ID) {
		return null;
	}

	@Override
	public ResultMessage add() {
		return null;
	}

	@Override
	public ResultMessage update() {
		return null;
	}

	@Override
	public ResultMessage delete() {
		return null;
	}

	@Override
	public void setID(int id) {
	}

	@Override
	public void setName(String name) {
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void setModel(String model) {
	}

	@Override
	public String getModel() {
		return null;
	}

	@Override
	public void setClassification(String classification) {
	}

	@Override
	public String getClassification() {
		return null;
	}

	@Override
	public void setNumber(int number) {
	}

	@Override
	public int getNumber() {
		return 0;
	}

	@Override
	public void setPurPrice(double purPrice) {
	}

	@Override
	public double getPurPrice() {
		return 0;
	}

	@Override
	public void setRetailedPrice(double retailedPrice) {
	}

	@Override
	public double getRetailedPrice() {
		return 0;
	}

	@Override
	public void setRecentPurPrice(double recentPurPrice) {
	}

	@Override
	public double getRecentPurPrice() {
		return 0;
	}

	@Override
	public void setRecentRetailedPrice(double recentRetailedPrice) {
	}

	@Override
	public double getRecentRetailedPrice() {
		return 0;
	}

	@Override
	public void setWarmingValue(int warmingValue) {
	}

	@Override
	public int getWarmingValue() {
		return 0;
	}

	@Override
	public void insert(CommodityPO po) throws RemoteException {
	}

	@Override
	public void delelte(CommodityPO po) throws RemoteException {
	}

	@Override
	public void update(CommodityPO po) throws RemoteException {
	}

	@Override
	public void find(CommodityPO po) throws RemoteException {
	}

	@Override
	public void giftInventoryReceiptsMaking(BillPO po) throws RemoteException {
	}

	@Override
	public void lossAndRevenueInventoryReceiptsMaking(BillPO po) throws RemoteException {
	}

	@Override
	public void warningInventoryReceiptsMaking(BillPO po) throws RemoteException {
	}

	@Override
	public void init() throws RemoteException {
	}

	@Override
	public void finish() throws RemoteException {
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
	public ResultMessage newBuild(AccountVO accountVO) {
		return null;
	}

	@Override
	public ResultMessage delete(String name) {
		return null;
	}

	@Override
	public ResultMessage modifyName(String preName, String targetName) {
		return null;
	}

	@Override
	public ArrayList<AccountPO> getAccountList() {
		return null;
	}

	@Override
	public ResultMessage enterItem(ArrayList<String> name, ArrayList<String> transferAmount) {
		return null;
	}


}
