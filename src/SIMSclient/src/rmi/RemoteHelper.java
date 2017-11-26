package SIMSclient.src.rmi;

import java.rmi.Remote;

import SIMSclient.src.dataservice.accountdataservice.AccountDataService;
import SIMSclient.src.dataservice.billdataservice.BillDataService;
import SIMSclient.src.dataservice.checktabledataservice.businessHistoryScheduleDataService;
import SIMSclient.src.dataservice.checktabledataservice.saleScheduleDataService;
import SIMSclient.src.dataservice.checktabledataservice.statementOfOperationDataService;
import SIMSclient.src.dataservice.commoditydataservice.ClassificationDataService;
import SIMSclient.src.dataservice.commoditydataservice.CommodityDataService;
import SIMSclient.src.dataservice.datafactoryservice.DataFactoryService;

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
	
	public DataFactoryService
}
