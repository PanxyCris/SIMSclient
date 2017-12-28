package bussinesslogic.examinebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogic.billbl.inventory.InventoryTransition;
import bussinesslogic.utilitybl.UtilityBL;
import bussinesslogicservice.examineblservice.ExamineBLService;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindCommodityType;
import dataenum.findtype.FindInventoryBillType;
import dataenum.findtype.FindUserType;
import dataservice.billdataservice.BillDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import po.commodity.CommodityPO;
import po.inventorybillpo.InventoryBillPO;
import po.messagepo.MessageBillPO;
import rmi.RemoteHelper;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;

public class ExamineInventoryBL implements ExamineBLService<InventoryBillVO>{

	private BillDataService service;
	private MessageDataService messageService;
	private UserDataService userService;
	private CommodityDataService commodityService;
	private UtilityBLService utilityService;
	InventoryTransition transition;


	public ExamineInventoryBL() {
		service = RemoteHelper.getInstance().getBilldataService();
		userService = RemoteHelper.getInstance().getUserDataService();
		messageService = RemoteHelper.getInstance().getMessageDataService();
		commodityService = RemoteHelper.getInstance().getCommodityDataService();
		utilityService = new UtilityBL();
		transition = new InventoryTransition();
	}



	@Override
	public ResultMessage updateBill(InventoryBillVO vo) throws RemoteException {
		return service.updateInventoryBill(transition.VOtoPO(vo));
	}

	@Override
	public ResultMessage passBills(ArrayList<InventoryBillVO> vos) throws RemoteException {
		for(InventoryBillVO vo : vos){

            for(GiftVO gift:vo.getGifts()){
            	CommodityPO commodity = commodityService.findCommodity(gift.getName(), FindCommodityType.NAME).get(0);

            	switch(vo.getType()){
            	    case INVENTORYGIFTBILL:commodity.setNumner(commodity.getNumber()-gift.getNumber());
            	                           utilityService.warningMessage(commodity);break;
            	    case INVENTORYLOSSBILL:commodity.setNumner(commodity.getNumber()-gift.getNumber());
                                           utilityService.warningMessage(commodity);break;
            	    case INVENTORYREVENUEBILL:commodity.setNumner(commodity.getNumber()+gift.getNumber());break;
            	    case INVENTORYWARNINGBILL:commodity.setWarningValue(gift.getNumber());
            	                              utilityService.warningMessage(commodity);break;
            		default:break;
            	}
            	commodityService.updateCommodity(commodity);
            }

			vo.setState(BillState.SUCCESS);
			updateBill(vo);
			UserPO user = userService.findUser(vo.getOperator(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(user.getName()+"("+user.getID()+")",
					vo.getId(),vo.getType(),ResultMessage.SUCCESS);
			ResultMessage result = messageService.save(message,user);
			if(result!=ResultMessage.SUCCESS)
				return result;
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<InventoryBillVO> vos) throws RemoteException {

		for(InventoryBillVO vo : vos){
			vo.setState(BillState.FAIL);
			updateBill(vo);
			UserPO user = userService.findUser(vo.getOperator(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(user.getName()+"("+user.getID()+")",
					vo.getId(),vo.getType(),ResultMessage.FAIL);
			ResultMessage result = messageService.save(message,user);
			if(result!=ResultMessage.SUCCESS)
				return result;
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<InventoryBillVO> getCommitedBills() throws RemoteException {
		ArrayList<InventoryBillVO> committed = new ArrayList<>();
		ArrayList<InventoryBillPO> inventoryList = service.showInventoryBill();
		for(InventoryBillPO po:inventoryList)
			if(po.getBillState()==BillState.COMMITED)
				committed.add(transition.POtoVO(po));
		return committed;
	}

	@Override
	public ArrayList<InventoryBillVO> find(String info, FindBillType type) throws RemoteException {
		ArrayList<InventoryBillVO> committed = new ArrayList<>();
		ArrayList<InventoryBillPO> inventoryList = service.findInventoryBill(info, FindInventoryBillType.getType(type.value));
		for(InventoryBillPO po:inventoryList)
			if(po.getBillState()==BillState.COMMITED)
				committed.add(transition.POtoVO(po));
		return committed;
	}


}
