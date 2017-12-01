package SIMSclient.src.bussinesslogicservice.accountblservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountVO;


/**
 * 
 * @author 王灿灿
 * @version 2017-12-1
 *
 */
public interface AccountBLService {
	
	public ArrayList<AccountVO> find(String message);//message是用户查找ID时输入的信息，经过逻辑处理后返回一个AccountVO对象
	
	public ResultMessage newBuild(String name,double money);//新建一个账户,返回一个AccountPO对象
	
	public ResultMessage delete(AccountVO accountVO);//删除
	
	public ResultMessage modify(String name);//修改
	
}
