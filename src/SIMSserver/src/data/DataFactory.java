package SIMSserver.src.data;
/**     
*  ���ݹ���
* @author Lijie 
* @date 2017��12��2��    
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
