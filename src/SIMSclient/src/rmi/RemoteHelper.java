package SIMSclient.src.rmi;

import java.rmi.Remote;

import SIMSclient.src.dataservice.accountbilldataservice.PaymentBillDataService;
import SIMSclient.src.dataservice.accountbilldataservice.ReceiptDataService;
import SIMSclient.src.dataservice.accountbookdataservice.SetUpAccountDataService;
import SIMSclient.src.dataservice.accountdataservice.AccountDataService;
import SIMSclient.src.dataservice.billdataservice.BillDataService;
import SIMSclient.src.dataservice.checktabledataservice.BusinessHistoryScheduleDataService;
import SIMSclient.src.dataservice.checktabledataservice.SaleScheduleDataService;
import SIMSclient.src.dataservice.checktabledataservice.StatementOfOperationDataService;
import SIMSclient.src.dataservice.classificationdataservice.ClassificationDataService;
import SIMSclient.src.dataservice.commoditydataservice.CommodityDataService;
import SIMSclient.src.dataservice.memberdataservice.MemberDataService;
import SIMSclient.src.dataservice.promotiondataservice.PromotionDataService;
import SIMSclient.src.dataservice.salesdataservice.SalesDataService;
import SIMSclient.src.dataservice.userdataservice.UserDataService;

/**
 *
 * @author Íõ²Ó²Ó
 * @version 2017-11-26
 *
 */

public class RemoteHelper {

	private Remote remote;

	private static RemoteHelper remoteHelper=new RemoteHelper();

	public static RemoteHelper getInstance(){

		return remoteHelper;

	}

	private RemoteHelper(){
	}

	public void setRemote(Remote remote){
		this.remote=remote;
	}

	public AccountDataService getAccountDataService(){
		return (AccountDataService)remote;
	}

	public BillDataService getBilldataService(){
		return (BillDataService)remote;
	}

	public BusinessHistoryScheduleDataService getbusinessHistoryScheduleDataService(){
		return (BusinessHistoryScheduleDataService)remote;
	}

	public SaleScheduleDataService getsaleScheduleDataService(){
		return (SaleScheduleDataService)remote;
	}

	public StatementOfOperationDataService getstatementOfOperationDataService(){
		return (StatementOfOperationDataService)remote;
	}

	public ClassificationDataService getClassificationDataService(){
		return (ClassificationDataService)remote;
	}

	public CommodityDataService getCommodityDataService(){
		return (CommodityDataService)remote;
	}

	public MemberDataService getMemeberDataService(){
		return (MemberDataService)remote;
	}

	public ReceiptDataService getReceiptDataService(){
		return (ReceiptDataService)remote;
	}

	public PaymentBillDataService getPaymentDataService(){
		return (PaymentBillDataService)remote;
	}

	public PromotionDataService getPromotionDataService(){
		return (PromotionDataService)remote;
	}

	public SalesDataService getSalesDataService(){
		return (SalesDataService)remote;
	}

	public SetUpAccountDataService getSetUpAccountDataService(){
		return (SetUpAccountDataService)remote;
	}

	public UserDataService getuserDataService(){
		return (UserDataService)remote;
	}
}
