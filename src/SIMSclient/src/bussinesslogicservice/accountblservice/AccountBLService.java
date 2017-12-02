package SIMSclient.src.bussinesslogicservice.accountblservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountVO;
import SIMSclient.src.vo.bill.BillVO;


/**
 *
 * @author 王灿灿
 * @version 2017-12-1
 *
 */
public interface AccountBLService {

	public ArrayList<AccountVO> find(String message);//message是用户查找ID时输入的信息，经过逻辑处理后返回一个AccountVO对象

	public ResultMessage newBuild(String name,String money);//新建一个账户,返回一个AccountPO对象

	public ResultMessage delete(String name);//删除

	public ResultMessage modifyName(String preName,String targetName);//修改账户名

	public ArrayList<AccountVO> getAccountList();  //改了一下接口，返回一个账户list
	
	public ResultMessage enterItem(BillVO billVO); //收款单、付款单 入账


}
