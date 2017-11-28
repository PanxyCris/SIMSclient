package SIMSserver.src.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.AccountPO;
import SIMSclient.src.po.makefinancialdoc.FinancialDocPO;
import SIMSclient.src.po.table.BusinessHistorySchedulePO;
import SIMSclient.src.po.table.SaleSchedulePO;
import SIMSclient.src.po.table.StatementOfOperationPO;
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
import SIMSserver.src.po.CommodityPO;
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


}
