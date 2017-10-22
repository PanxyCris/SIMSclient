package SIMSclient.src.bussinesslogic.accountbl;

import SIMSclient.src.po.AccountPO;
import SIMSclient.src.vo.AccountVO;

public interface AccountBLService {
	
	public AccountPO check(String message);//message是用户查找ID时输入的信息，经过逻辑处理后返回一个AccountPO对象
	
	public boolean newBuild(AccountVO accountVO);//新建一个账户,返回bool信息
	
	public boolean delete(AccountVO accountVO);//删除
	
	public boolean modify(String name);//修改
	
}