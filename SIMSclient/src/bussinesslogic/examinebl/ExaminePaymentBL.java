package bussinesslogic.examinebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.accountbillbl.PaymentBillTransition;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataenum.findtype.FindAccountType;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindMemberType;
import dataenum.findtype.FindUserType;
import dataservice.accountbilldataservice.PaymentBillDataService;
import dataservice.accountdataservice.AccountDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.AccountPO;
import po.MemberPO;
import po.UserPO;
import po.FinancialBill.PaymentBillPO;
import po.messagepo.MessageBillPO;
import rmi.RemoteHelper;
import vo.billvo.financialbillvo.PaymentBillVO;

/**
 * ���������ҵ���߼���
 *
 * @author ������ 2017-12-25
 */
public class ExaminePaymentBL implements ExamineBLService<PaymentBillVO> {

	private PaymentBillDataService service;
	private MessageDataService messageService;
	private UserDataService userService;
	private AccountDataService accountService;
	private MemberDataService memberService;
	PaymentBillTransition tansition;

	public ExaminePaymentBL() {
		service = RemoteHelper.getInstance().getPaymentDataService();
		userService = RemoteHelper.getInstance().getUserDataService();
		messageService = RemoteHelper.getInstance().getMessageDataService();
		accountService = RemoteHelper.getInstance().getAccountDataService();
		memberService = RemoteHelper.getInstance().getMemeberDataService();
		tansition = new PaymentBillTransition();
	}

	@Override
	public ResultMessage updateBill(PaymentBillVO vo) throws RemoteException {
		return service.updatePaymentBill(tansition.VOtoPO(vo));
	}

	@Override
	public ResultMessage passBills(ArrayList<PaymentBillVO> vos) throws RemoteException {
		for (PaymentBillVO vo : vos) {
			// �Ի�ԱӦ��Ӧ����Ϣ���޸�
			MemberPO member = memberService.findMember(vo.getCustomerID(), FindMemberType.ID).get(0);
			member.setReceivable(member.getReceivable() - vo.getTotal());
			memberService.updateMember(member);
			String accountID = "";
			for (int i = 0; i < vo.getAccountID().length(); i++)
				if (vo.getAccountID().charAt(i) == ' ') {
					accountID = vo.getAccountID().substring(0, i);
					break;
				}
			// ���˻���Ϣ���޸�
			AccountPO account = accountService.findAccount(accountID, FindAccountType.ID).get(0);
			account.setMoney(account.getMoney() + vo.getTotal());
			accountService.updateAccount(account);

			vo.setState(BillState.SUCCESS);
			updateBill(vo);
			// ֪ͨ�û�
			UserPO user = userService.findUser(vo.getUserID(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(messageService.getMessageID(), user.getID(), false,
					user.getName() + "(" + user.getID() + ")", vo.getId(), vo.getType(), ResultMessage.SUCCESS);
			ResultMessage result = messageService.save(message);
			if (result != ResultMessage.SUCCESS)
				return result;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<PaymentBillVO> vos) throws RemoteException {
		for (PaymentBillVO vo : vos) {
			vo.setState(BillState.FAIL);
			updateBill(vo);
			UserPO user = userService.findUser(vo.getUserID(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(messageService.getMessageID(), user.getID(), false,
					user.getName() + "(" + user.getID() + ")", vo.getId(), vo.getType(), ResultMessage.FAIL);
			ResultMessage result = messageService.save(message);
			if (result != ResultMessage.SUCCESS)
				return result;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PaymentBillVO> getCommitedBills() throws RemoteException {
		ArrayList<PaymentBillVO> committed = new ArrayList<>();
		ArrayList<PaymentBillPO> purchaseList = service.showPaymentBill();
		for (PaymentBillPO po : purchaseList)
			if (po.getBillState() == BillState.COMMITED)
				committed.add(tansition.POtoVO(po));
		return committed;
	}

	@Override
	public ArrayList<PaymentBillVO> find(String info, FindBillType type) throws RemoteException {
		ArrayList<PaymentBillVO> committed = new ArrayList<>();
		ArrayList<PaymentBillPO> purchaseList = service.findPaymentBill(info, FindAccountBillType.getType(type.value));
		for (PaymentBillPO po : purchaseList)
			if (po.getBillState() == BillState.COMMITED)
				committed.add(tansition.POtoVO(po));
		return committed;
	}

}
