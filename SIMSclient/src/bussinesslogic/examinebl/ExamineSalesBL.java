package bussinesslogic.examinebl;

import java.rmi.RemoteException;

import java.util.ArrayList;
import bussinesslogic.salesbl.SalesTransition;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindSalesType;
import dataenum.findtype.FindUserType;
import dataservice.messagedataservice.MessageDataService;
import dataservice.salesdataservice.SalesDataService;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import po.messagepo.MessageBillPO;
import po.sales.SalesPO;
import rmi.RemoteHelper;
import vo.billvo.salesbillvo.SalesVO;

/**
*
* @author Lijie
* @date 2017Äê12ÔÂ17ÈÕ
*/
public class ExamineSalesBL implements ExamineBLService<SalesVO> {
	private SalesDataService service;
	private MessageDataService messageService;
	private UserDataService userService;

	public ExamineSalesBL() {
		service = RemoteHelper.getInstance().getSalesDataService();
		userService = RemoteHelper.getInstance().getUserDataService();
		messageService = RemoteHelper.getInstance().getMessageDataService();
	}

	@Override
	public ResultMessage updateBill(SalesVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return service.updateSale(SalesTransition.VOtoPO(vo));
	}

	@Override
	public ResultMessage passBills(ArrayList<SalesVO> vos) throws RemoteException {
		// TODO Auto-generated method stub
		for(SalesVO vo:vos){
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
	public ResultMessage notPassBills(ArrayList<SalesVO> vos) throws RemoteException {
		// TODO Auto-generated method stub
		for(SalesVO vo:vos){
			vo.setState(BillState.SUCCESS);
			UserPO user = userService.findUser(vo.getOperator(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(user.getName()+"("+user.getID()+")",
					vo.getId(),vo.getType(),ResultMessage.FAIL);
			ResultMessage result = messageService.save(message);
			if(result!=ResultMessage.FAIL)
				return result;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<SalesVO> getCommitedBills() throws RemoteException {
		ArrayList<SalesVO> committed = new ArrayList<>();
		ArrayList<SalesPO> purchaseList = service.showSale();
		for(SalesPO po:purchaseList)
			if(po.getState()==BillState.COMMITED)
				committed.add(SalesTransition.POtoVO(po));
		return committed;
	}

	@Override
	public ArrayList<SalesVO> find(String info, FindBillType type) throws RemoteException {
		ArrayList<SalesVO> committed = new ArrayList<>();
		ArrayList<SalesPO> purchaseList = service.findSale(info, FindSalesType.getType(type.value));
		for(SalesPO po:purchaseList)
			if(po.getState()==BillState.COMMITED)
				committed.add(SalesTransition.POtoVO(po));
		return committed;
	}

}
