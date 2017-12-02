package SIMSclient.src.dataservice.accountdataservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.AccountPO;
import SIMSclient.src.vo.AccountVO;
import SIMSserver.src.po.BillPO;

/**
 * 
 * @author 王灿灿
 * @version 2017-12-1
 */
public interface AccountDataService {
	
	public ArrayList<AccountPO> find(String message);//message是用户查找ID时输入的信息,经过数据层逻辑处理后返回AccountPOList
	
	public ResultMessage newBuild(AccountVO accountVO);//新建一个账户
	
	public ResultMessage delete(String name);//删除
	
	public ResultMessage modify(String preName,String targetName);//修改账户名
	
	public ArrayList<AccountPO> getAccountList();  //改了一下接口，返回一个账户list
	
	public ResultMessage enterItem(BillP); //收款单、付款单 入账
}
