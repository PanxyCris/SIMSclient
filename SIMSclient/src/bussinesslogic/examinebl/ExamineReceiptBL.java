package bussinesslogic.examinebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogic.accountbillbl.ReceiptBillTransition;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindUserType;
import dataservice.accountbilldataservice.ReceiptBillDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import po.FinancialBill.ReceiptBillPO;
import po.messagepo.MessageBillPO;
import rmi.RemoteHelper;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class ExamineReceiptBL implements ExamineBLService<ReceiptBillVO>{

	private ReceiptBillDataService service;
	private MessageDataService messageService;
	private UserDataService userService;
	ReceiptBillTransition tansition;

	public ExamineReceiptBL() {
		service = RemoteHelper.getInstance().getReceiptDataService();
		userService = RemoteHelper.getInstance().getUserDataService();
		messageService = RemoteHelper.getInstance().getMessageDataService();
		tansition = new ReceiptBillTransition();
	}

	@Override
	public ResultMessage updateBill(ReceiptBillVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.updateReceiptBill(tansition.VOtoPO(vo));
	}

	@Override
	public ResultMessage passBills(ArrayList<ReceiptBillVO> vos) throws RemoteException {
		// TODO Auto-generated method stub
		for(ReceiptBillVO vo:vos){
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
	public ResultMessage notPassBills(ArrayList<ReceiptBillVO> vos) throws RemoteException {
		// TODO Auto-generated method stub
		for(ReceiptBillVO vo:vos){
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
	public ArrayList<ReceiptBillVO> getCommitedBills() throws RemoteException {
		ArrayList<ReceiptBillVO> committed = new ArrayList<>();
		ArrayList<ReceiptBillPO> purchaseList = service.showReceiptBill();
		for(ReceiptBillPO po:purchaseList)
			if(po.getBillState()==BillState.COMMITED)
				committed.add(tansition.POtoVO(po));
		return committed;
	}

	@Override
	public ArrayList<ReceiptBillVO> find(String info, FindBillType type) throws RemoteException {
		ArrayList<ReceiptBillVO> committed = new ArrayList<>();
		ArrayList<ReceiptBillPO> purchaseList = service.findReceiptBill(info, FindAccountBillType.getType(type.value));
		for(ReceiptBillPO po:purchaseList)
			if(po.getBillState()==BillState.COMMITED)
				committed.add(tansition.POtoVO(po));
		return committed;
	}



}
