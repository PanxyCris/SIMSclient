package bussinesslogic.memberbl;

import java.rmi.RemoteException;

import bussinesslogicservice.salesblservice.Sale_MemberInfo;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ11ÈÕ    
*/
public class MemberInfo implements Sale_MemberInfo{

	@Override
	public String getMember(String id) throws RemoteException {
		return null;
	}

	@Override
	public String getSaleMan(String id) throws RemoteException {
		return null;
	}

	@Override
	public void changePayable(String memberID, double afterPrice) throws RemoteException {
	}

	@Override
	public boolean isLimit(String memberID, double money) throws RemoteException {
		return false;
	}

}
