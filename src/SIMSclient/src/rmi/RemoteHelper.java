package SIMSclient.src.rmi;

import java.rmi.Remote;

import SIMSclient.src.dataservice.accountdataservice.AccountDataService;
import SIMSclient.src.dataservice.billdataservice.BillDataService;
import SIMSclient.src.dataservice.checktabledataservice.businessHistoryScheduleDataService;
import SIMSclient.src.dataservice.checktabledataservice.saleScheduleDataService;
import SIMSclient.src.dataservice.checktabledataservice.statementOfOperationDataService;
import SIMSclient.src.dataservice.commoditydataservice.ClassificationDataService;
import SIMSclient.src.dataservice.commoditydataservice.CommodityDataService;
import SIMSclient.src.dataservice.memberdataservice.MemberDataService;
import SIMSclient.src.dataservice.mfdocsdataservice.skddataservice;
import SIMSclient.src.dataservice.mfdocsdataservice.xjfyddataservice;
import SIMSclient.src.dataservice.promotiondataservice.PromotionDataService;
import SIMSclient.src.dataservice.salesdataservice.SalesDataService;
import SIMSclient.src.dataservice.setupaccountdataservice.SetUpAccountDataService;
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
	
	public RemoteHelper getInstance(){
		
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
	
	public businessHistoryScheduleDataService getbusinessHistoryScheduleDataService(){
		return (businessHistoryScheduleDataService)remote;
	}
	
	public saleScheduleDataService getsaleScheduleDataService(){
		return (saleScheduleDataService)remote;
	}
	
	public statementOfOperationDataService getstatementOfOperationDataService(){
		return (statementOfOperationDataService)remote;
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
	
	public skddataservice getskddataservice(){
		return (skddataservice)remote;
	}
	
	public xjfyddataservice getxjfyddataservice(){
		return (xjfyddataservice)remote;
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
