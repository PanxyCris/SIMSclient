package bussinesslogic.examinebl;

import java.rmi.RemoteException;

import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillBL;
import bussinesslogic.salesbl.SalesTransition;
import bussinesslogic.utilitybl.UtilityBL;
import bussinesslogicservice.examineblservice.ExamineBLService;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindCommodityType;
import dataenum.findtype.FindMemberType;
import dataenum.findtype.FindSalesType;
import dataenum.findtype.FindUserType;
import dataservice.billdataservice.BillDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.messagedataservice.MessageDataService;
import dataservice.salesdataservice.SalesDataService;
import dataservice.userdataservice.UserDataService;
import po.MemberPO;
import po.UserPO;
import po.commodity.CommodityPO;
import po.inventorybillpo.InventoryBillPO;
import po.messagepo.MessageBillPO;
import po.sales.SalesPO;
import rmi.RemoteHelper;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;

/**
*
* @author 潘星宇
* @date 2017年12月26日
*/
public class ExamineSalesBL implements ExamineBLService<SalesVO> {
	private SalesDataService service;
	private MessageDataService messageService;
	private UserDataService userService;
	private CommodityDataService commodityService;
	private MemberDataService memberService;
	private UtilityBLService utilityService;
	private InventoryBillBL inventoryBL;

	public ExamineSalesBL() {
		service = RemoteHelper.getInstance().getSalesDataService();
		userService = RemoteHelper.getInstance().getUserDataService();
		messageService = RemoteHelper.getInstance().getMessageDataService();
		commodityService = RemoteHelper.getInstance().getCommodityDataService();
		memberService = RemoteHelper.getInstance().getMemeberDataService();
		utilityService = new UtilityBL();
		inventoryBL = new InventoryBillBL();
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

			String memberID = vo.getRetailerID();
			MemberPO member = memberService.findMember(memberID, FindMemberType.ID).get(0);
			if(vo.getType() == BillType.SALESBILL)
                member.setReceivable(member.getReceivable()+vo.getAfterPrice());
			else
				member.setPayable(member.getPayable()+vo.getAfterPrice());
            for(CommodityItemVO item:vo.getCommodity()){
            	CommodityPO commodity = commodityService.findCommodity(item.getId(), FindCommodityType.ID).get(0);
            	if(vo.getType() == BillType.SALESBILL){
            	    commodity.setNumner(commodity.getNumber()-item.getNumber());
            	    utilityService.warningMessage(commodity);
            	}
            	else
            		commodity.setNumner(commodity.getNumber()+item.getNumber());
            	commodityService.updateCommodity(commodity);
            }

            InventoryBillVO inventory = new InventoryBillVO(inventoryBL.getId(BillType.INVENTORYGIFTBILL),vo.getGifts(),
            		vo.getOperator(),BillType.INVENTORYGIFTBILL,BillState.COMMITED,vo.getId()+"的赠品提交");
            inventoryBL.submit(inventory);

            vo.setState(BillState.SUCCESS);
            updateBill(vo);
			UserPO user = userService.findUser(vo.getOperator(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(messageService.getMessageID(),user.getID(),false,user.getName()+"("+user.getID()+")",
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
			vo.setState(BillState.FAIL);
			updateBill(vo);
			UserPO user = userService.findUser(vo.getOperator(), FindUserType.NAME).get(0);
			MessageBillPO message = new MessageBillPO(messageService.getMessageID(),user.getID(),false,user.getName()+"("+user.getID()+")",
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
