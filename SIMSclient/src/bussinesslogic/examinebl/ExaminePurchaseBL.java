package bussinesslogic.examinebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogic.purchasebl.PurchaseTransition;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindSalesType;
import dataenum.findtype.FindUserType;
import dataservice.messagedataservice.MessageDataService;
import dataservice.purchasedataservice.PurchaseDataService;
import dataservice.userdataservice.UserDataService;
import po.PurchasePO;
import po.UserPO;
import po.messagepo.MessageBillPO;
import rmi.RemoteHelper;
import vo.billvo.purchasebillvo.PurchaseVO;

public class ExaminePurchaseBL implements ExamineBLService<PurchaseVO>{

	private PurchaseDataService service;
	private MessageDataService messageService;
	private UserDataService userService;

	public ExaminePurchaseBL() {
		service = RemoteHelper.getInstance().getPurchaseDataService();
		userService = RemoteHelper.getInstance().getUserDataService();
		messageService = RemoteHelper.getInstance().getMessageDataService();
	}

	@Override
	public ResultMessage updateBill(PurchaseVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.updatePurchase(PurchaseTransition.VOtoPO(vo));
	}

	@Override
	public ResultMessage passBills(ArrayList<PurchaseVO> vos) throws RemoteException {

		for(PurchaseVO vo : vos){
			vo.setState(BillState.SUCCESS);
			UserPO user = userService.findUser(vo.getOperator(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(user.getName()+"("+user.getID()+")",
					vo.getId(),vo.getType(),ResultMessage.SUCCESS);
			ResultMessage result = messageService.save(message);
			if(result!=ResultMessage.SUCCESS)
				return result;
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<PurchaseVO> vos) throws RemoteException {
		// TODO Auto-generated method stub
		for(PurchaseVO vo : vos){
			vo.setState(BillState.FAIL);
			UserPO user = userService.findUser(vo.getOperator(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(user.getName()+"("+user.getID()+")",
					vo.getId(),vo.getType(),ResultMessage.FAIL);
			ResultMessage result = messageService.save(message);
			if(result!=ResultMessage.SUCCESS)
				return result;
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PurchaseVO> getCommitedBills() throws RemoteException {
		ArrayList<PurchaseVO> committed = new ArrayList<>();
		ArrayList<PurchasePO> purchaseList = service.showPurchase();
		for(PurchasePO po:purchaseList)
			if(po.getState()==BillState.COMMITED)
				committed.add(PurchaseTransition.POtoVO(po));
		return committed;
	}

	@Override
	public ArrayList<PurchaseVO> find(String info, FindBillType type) throws RemoteException {
		ArrayList<PurchaseVO> committed = new ArrayList<>();
		ArrayList<PurchasePO> purchaseList = service.findPurchase(info, FindSalesType.getType(type.value));
		for(PurchasePO po:purchaseList)
			if(po.getState()==BillState.COMMITED)
				committed.add(PurchaseTransition.POtoVO(po));
		return committed;
	}


}
