package bussinesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.memberbl.MemberInfo;
import bussinesslogicservice.accountblservice.AccountBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;
import vo.AccountVO;
import vo.FinancialBill.AccountListVO;
import vo.FinancialBill.FinancialDocVO;
import vo.FinancialBill.PaymentBillVO;
import vo.FinancialBill.ReceiptBillVO;

/**
 * 
 * @author ���Ӳ�
 * @version 2017-12-10
 */
public class AccountBL implements AccountBLService{

	private static AccountBL accountBL=new AccountBL();
	ResultMessage resultMessage = null;
	
	public AccountBL getInstance(){
		return accountBL;
	}
	
	AccountDataService accountDataService;
	AccountTransition accountTransition;
	AccountVO accountVO;
	AccountPO accountPO; 
	
	FindAccountType findAccountType;
	
	

	
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
			accountPOs=accountDataService.findAccount(message,findType);
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
		
		accountPO=new AccountPO("","",0.0);
		
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
			
			accountPO.setId(id);
			accountPO.setName(name);
			accountPO.setMoney(m);
					
			try {
				resultMessage=accountDataService.insertAccount(accountPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		}
		return resultMessage.SUCCESS;
	}

/**
 * �ж������account�Ƿ�Ϸ�
 * @author ���Ӳ�
 * @param accountVO Ϊ��������޸ĵ�account����
 * 
 */
	@Override
	public ResultMessage judgeLegal(AccountVO accountVO) {
		String id=accountVO.getId();
		String name=accountVO.getName();
		String money=accountVO.getMoney();
		
		//id���ַ�����Ϊ0~9
		for (int i = 0; i < id.length(); i++) {
			if(!('0'<= id.charAt(i) && id.charAt(i) <='9')){
				return resultMessage.ILLEAGLINPUTDATA;
			}
		}
		
		//accountName�������пո�
		for (int i = 0; i < name.length(); i++) {
			if(32 == name.charAt(i)){
				return resultMessage.ILLEGALINPUTNAME;
			}
		}
		
		//money����Ϊ����
		if(Double.valueOf(money)<0){
			return resultMessage.ILLEAGLINPUTDATA;
		}
		
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
		try {
			accountPOs=accountDataService.showAccount();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(!accountPOs.isEmpty()){
			for (int i = 0; i < accountVOs.size(); i++) {
				accountVO.setId(accountPOs.get(i).getId());
				accountVO.setName(accountPOs.get(i).getName());
				accountVO.setMoney(Double.toString(accountPOs.get(i).getMoney()));
				accountVOs.add(accountVO);
			}
		}
		return accountVOs;
	}

/**
 * 
 * �������ˣ��޸������˻����޸Ŀͻ���Ӧ��Ӧ������
 * @author ���Ӳ�
 * @param financialDocVO	���տ����ĸ������ӵ�������˻����б�ת�˽���б������
 *  
 * 
 */
	@Override
	public ResultMessage enterItem(FinancialDocVO financialDocVO,BillType billType) {
		//waiting for coding
		
		ArrayList<String> accountID=new ArrayList<>();
		ArrayList<Double> accountMoney=new ArrayList<>();
		String memberID="";
		
		if(billType.equals(billType.SKD)){
			ReceiptBillVO receiptBillVO = (ReceiptBillVO)financialDocVO;
			ArrayList<AccountListVO> accountVOs = receiptBillVO.getAccountListVOs();
			for (int i = 0; i < accountVOs.size(); i++) {
				accountID.add(accountVOs.get(i).getAccountID());
				accountMoney.add(Double.valueOf(accountVOs.get(i).getMoney()));
			}
			memberID=receiptBillVO.getCustomerID();
		}
		if(billType.equals(billType.XJFYD)){
			PaymentBillVO paymentBillVO=(PaymentBillVO)financialDocVO;
			accountID.add(paymentBillVO.getAccountID());
			accountMoney.add(Double.valueOf(paymentBillVO.getTotal()));
			memberID=paymentBillVO.getCustomerID();
		}
		
		
		
		return resultMessage.SUCCESS;
		
	}

/**
 * @author ���Ӳ�
 */
	@Override
	public ResultMessage saveChange(ArrayList<AccountVO> accountVOs) {
			accountPO=new AccountPO("", "",0.0);
		for (AccountVO accountVO : accountVOs) {
			accountPO=accountTransition.VOtoPO(accountVO);
			try {
				accountDataService.updateAccount(accountPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return resultMessage.SUCCESS;
	}

}
