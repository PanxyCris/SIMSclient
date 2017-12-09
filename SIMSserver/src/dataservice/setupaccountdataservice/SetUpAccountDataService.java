package dataservice.setupaccountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataservice.CommonDataService;
import po.AccountBookPO;

/**
 * 
* @ClassName: SetUpAccountDataService 
* @Description: 期初建账 ,只有增加，查看和显示
* @author lijie 
* @date 2017年12月3日 上午11:10:47 
*
 */
public interface SetUpAccountDataService extends CommonDataService<AccountBookPO> {
	public static final String NAME = "AccountBookData";
    public ResultMessage insert(AccountBookPO po) throws RemoteException;
	public ArrayList<AccountBookPO> show() throws RemoteException;
}
