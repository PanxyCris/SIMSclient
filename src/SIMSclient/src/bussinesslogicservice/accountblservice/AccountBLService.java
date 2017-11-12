package SIMSclient.src.bussinesslogicservice.accountblservice;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.vo.AccountVO;

public interface AccountBLService {
	
	public AccountVO find(String message);//message是用户查找ID时输入的信息，经过逻辑处理后返回一个AccountVO对象
	
	public ResultMessage newBuild();//新建一个账户,返回一个AccountPO对象
	
	public ResultMessage delete(AccountVO accountVO);//删除
	
	public ResultMessage modify(String name);//修改
	
}
