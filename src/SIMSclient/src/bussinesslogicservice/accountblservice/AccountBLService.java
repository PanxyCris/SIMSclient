package SIMSclient.src.bussinesslogicservice.accountblservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountVO;

public interface AccountBLService {

	public AccountVO find(String message);//message是用户查找ID时输入的信息，经过逻辑处理后返回一个AccountVO对象

	public ResultMessage newBuild();//新建一个账户,返回一个AccountPO对象

	public ResultMessage delete(AccountVO accountVO);//删除

	public ResultMessage modify(String name);//修改

	public ArrayList<AccountVO> getAccountList(); //接口改一下，用于返回一个list

}
