package bussinesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.findtype.FindAccountType;
import SIMSclient.src.dataservice.accountdataservice.AccountDataService;
import SIMSclient.src.po.AccountPO;
import SIMSclient.src.po.PersistObject;
import SIMSclient.src.vo.AccountVO;
import SIMSclient.src.vo.makefinancialdoc.FinancialDocVO;
import SIMSclient.src.vo.makefinancialdoc.PaymentBillVO;

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
	AccountTransition accountTransition;
	FindAccountType findAccountType;
	AccountVO accountVO;
	AccountPO accountPO; 
	PersistObject po;
	

	
/**
 * @author ���Ӳ�
 * @param messageΪ��������
 * 
 */
	@Override
	public ArrayList<AccountVO> find(String message,FindAccountType findType) {
		
		accountVO=new AccountVO("","","");
		
		ArrayList<AccountVO> accountVOs=new ArrayList<>();
		ArrayList<AccountPO> accountPOs=new ArrayList<>();
		try {
			accountPOs=accountDataService.find(message,findType);
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
		for (int i = 0; i < accountPOs.size(); i++) {
			accountVO=accountTransition.POtoVO(accountPO);
			accountVOs.add(accountVO);
		}
		
		return accountVOs;
	}

/**
 * @author ���Ӳ�
 * @param name,money��Ϊ��ui�õ��Ĳ���
 */
	@Override
	public ResultMessage newBuild(String id,String name,String money) {
		
		accountPO=new AccountPO("","","");
		
		double m = Double.valueOf(money);
		
		boolean judge=true;
		if (!find(id,findAccountType.ID).isEmpty()) {
			judge=false;
			return resultMessage.ILLEGALINPUTNAME;
		}
		if(0 > m || Double.MAX_VALUE < m){
			judge=false;
			return resultMessage.ILLEAGLINPUTDATA;
		}
		if(judge){
			
			accountPO.setID(id);
			accountPO.setName(name);
			accountPO.setMoney(money);
			
			po=accountPO;
			
			resultMessage=accountDataService.newBuild(po);
			
		}
		return resultMessage.SUCCESS;
	}

/**
 * @author ���Ӳ�
 * @param accountVO Ϊ��������޸ĵ�account����
 * 
 */
	@Override
	public ResultMessage judgeLegal(AccountVO accountVO) {
		String name=accountVO.getName();
		return resultMessage.SUCCESS;
	}

/**
 * 
 * @author ���Ӳ�
 * �õ���ǰ�������������˻�������
 * 
 */
	@Override
	public ArrayList<AccountVO> getAccountList() {
		
		accountVO=new AccountVO("","","");
		
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
		//waiting for coding
		return resultMessage.SUCCESS;
		
	}

/**
 * @author ���Ӳ�
 */
	@Override
	public ResultMessage saveChange(ArrayList<AccountVO> accountVOs) {
			accountPO=new AccountPO("", "", "");
			ArrayList<PersistObject> persistObjects = new ArrayList<>();	
		for (AccountVO accountVO : accountVOs) {
			accountPO=accountTransition.VOtoPO(accountVO);
			persistObjects.add((PersistObject)accountPO);
		}
		return accountDataService.saveChange(persistObjects);
	}

}
