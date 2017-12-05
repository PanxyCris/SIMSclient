package SIMSserver.src.data;
/**     
*  数据工厂
* @author Lijie 
* @date 2017年12月2日    
*/

import java.rmi.RemoteException;

import SIMSserver.src.data.accountdata.AccountData;
import SIMSserver.src.dataservice.DataService;
import SIMSserver.src.dataservice.accountdataservice.AccountDataService;
import SIMSserver.src.po.PersistObject;

public class DataFactory {

	public static DataService<PersistObject> createDataService(String name) throws RemoteException{
		switch(name) {
		case AccountDataService.NAME:
			return new AccountData();
		}
	}
}
