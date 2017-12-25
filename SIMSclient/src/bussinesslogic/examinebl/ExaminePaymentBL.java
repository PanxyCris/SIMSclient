package bussinesslogic.examinebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogic.accountbillbl.PaymentBillTransition;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindUserType;
import dataservice.accountbilldataservice.PaymentBillDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import po.FinancialBill.PaymentBillPO;
import po.messagepo.MessageBillPO;
import rmi.RemoteHelper;
import vo.billvo.financialbillvo.PaymentBillVO;

public class ExaminePaymentBL implements ExamineBLService<PaymentBillVO>{


	private PaymentBillDataService service;
	private MessageDataService messageService;
	private UserDataService userService;
	PaymentBillTransition tansition;

	public ExaminePaymentBL() {
		service = RemoteHelper.getInstance().getPaymentDataService();
		userService = RemoteHelper.getInstance().getUserDataService();
		messageService = RemoteHelper.getInstance().getMessageDataService();
		tansition = new PaymentBillTransition();
	}

	@Override
	public ResultMessage updateBill(PaymentBillVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.updatePaymentBill(tansition.VOtoPO(vo));
	}

	@Override
	public ResultMessage passBills(ArrayList<PaymentBillVO> vos) throws RemoteException {
		// TODO Auto-generated method stub
		for(PaymentBillVO vo:vos){
			vo.setState(BillState.SUCCESS);
			UserPO user = userService.findUser(vo.getUserID(), FindUserType.ID).get(0);
			MessageBillPO message = new MessageBillPO(user.getName()+"("+user.getID()+")",
					vo.getId(),vo.getType(),ResultMessage.SUCCESS);
			ResultMessage result = messageService.save(message,user);
			if(result!=ResultMessage.SUCCESS)
				return result;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<PaymentBillVO> vos) throws RemoteException {
		// TODO Auto-generated method stub
		for(PaymentBillVO vo:vos){
			vo.setState(BillState.FAIL);
			UserPO user = userService.findUser(vo.getUserID(), FindUserType.ID).get(0);
			MessageBillPO message = new MessageBillPO(user.getName()+"("+user.getID()+")",
					vo.getId(),vo.getType(),ResultMessage.FAIL);
			ResultMessage result = messageService.save(message,user);
			if(result!=ResultMessage.SUCCESS)
				return result;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PaymentBillVO> getCommitedBills() throws RemoteException {
		ArrayList<PaymentBillVO> committed = new ArrayList<>();
		ArrayList<PaymentBillPO> purchaseList = service.showPaymentBill();
		for(PaymentBillPO po:purchaseList)
			if(po.getBillState()==BillState.COMMITED)
				committed.add(tansition.POtoVO(po));
		return committed;
	}

	@Override
	public ArrayList<PaymentBillVO> find(String info, FindBillType type) throws RemoteException {
		ArrayList<PaymentBillVO> committed = new ArrayList<>();
		ArrayList<PaymentBillPO> purchaseList = service.findPaymentBill(info, FindAccountBillType.getType(type.value));
		for(PaymentBillPO po:purchaseList)
			if(po.getBillState()==BillState.COMMITED)
				committed.add(tansition.POtoVO(po));
		return committed;
	}



}
