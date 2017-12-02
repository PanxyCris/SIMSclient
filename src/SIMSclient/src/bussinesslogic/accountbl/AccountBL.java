package SIMSclient.src.bussinesslogic.accountbl;

import java.util.ArrayList;

import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataservice.accountdataservice.AccountDataService;
import SIMSclient.src.po.AccountPO;
import SIMSclient.src.vo.AccountVO;
import SIMSclient.src.vo.makefinancialdoc.FinancialDocVO;

/**
 * 
 * @author ���Ӳ�
 * @version 2017-12-2
 *
 */
public class AccountBL implements AccountBLService{
	
	private static AccountBL accountBL=new AccountBL();
	ResultMessage resultMessage = null;
	
	public AccountBL getInstance(){
		return accountBL;
	}
	
	AccountDataService accountDataService;
	AccountVO accountVO = new AccountVO("", "");
	AccountPO accountPO = new AccountPO("", ""); 
	

/**
 * @author ���Ӳ�
 * @param messageΪ��������
 * 
 */
	@Override
	public ArrayList<AccountVO> find(String message) {
		
		ArrayList<AccountVO> accountVOs=new ArrayList<>();
		ArrayList<AccountPO> accountPOs=new ArrayList<>();
		accountPOs=accountDataService.find(message);
		
//		if (accountPOs.isEmpty()) {
//			System.out.println(ResultMessage.NOTFOUND);
//		}
		
		for (int i = 0; i < accountPOs.size(); i++) {
			accountVO.setMoney(accountPOs.get(i).getMoney());
			accountVO.setName(accountPOs.get(i).getName());
			accountVOs.add(accountVO);
		}
		
		return accountVOs;
	}

/**
 * @author ���Ӳ�
 * @param name,money��Ϊ��ui�õ��Ĳ���
 */
	@Override
	public ResultMessage newBuild(String name,String money) {
		
		double m = Double.valueOf(money);
		
		boolean judge=true;
		if (!find(name).isEmpty()) {
			judge=false;
			return resultMessage.ILLEGALINPUTNAME;
		}
		if(0 > m || Double.MAX_VALUE < m){
			judge=false;
			return resultMessage.ILLEAGLINPUTDATA;
		}
		if(judge){
			
			accountVO.setName(name);
			accountVO.setMoney(money);
			
			resultMessage=accountDataService.newBuild(accountVO);
			
		}
		return resultMessage.SUCCESS;
	}

/**
 * @author ���Ӳ�
 * @param nameΪ��ɾ���˻�����
 * 
 */
	@Override
	public ResultMessage delete(String name) {
		
		return accountDataService.delete(name);//��ɾ���߼�����data��
	}

/**
 * @author ���Ӳ�
 * @param preNameΪ�޸�ǰ���ƣ�targetNameΪ���޸ĳɵ�����
 * 
 */
	@Override
	public ResultMessage modifyName(String preName,String targetName) {
		
		return accountDataService.modifyName(preName, targetName);
		
	}

/**
 * 
 * @author ���Ӳ�
 * �õ���ǰ�������������˻�������
 * 
 */
	@Override
	public ArrayList<AccountVO> getAccountList() {
		ArrayList<AccountPO> accountPOs=new ArrayList<>();
		ArrayList<AccountVO> accountVOs=new ArrayList<>();
		accountPOs=accountDataService.getAccountList();
		if(!accountPOs.isEmpty()){
			for (int i = 0; i < accountVOs.size(); i++) {
				accountVO.setName(accountPOs.get(i).getName());
				accountVO.setMoney(accountPOs.get(i).getMoney());
				accountVOs.add(accountVO);
			}
		}
		return accountVOs;
	}

/**
 * 
 * @author ���Ӳ�
 * @param financialDocVO	���տ����ĸ������ӵ�������˻����б�ת�˽���б������
 *  
 * 
 */
	@Override
	public ResultMessage enterItem(FinancialDocVO financialDocVO) {
		
		ArrayList<String> nameList=financialDocVO.getAccountName();
		ArrayList<String> moneyList=financialDocVO.getMoney();
		
		return accountDataService.enterItem(nameList, moneyList);
	}

}
