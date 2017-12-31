package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;

import dataenum.BillType;
import dataenum.Remind;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class BussinessProcessTableController extends FinanceTableController{

	@FXML
	ChoiceBox<String> receiptChoice;

	@FXML
	public void chooseReceipt() throws Exception{
		BillType type = BillType.getType(receiptChoice.getValue());
		switch(type){
		case PURCHASEBILL:changeStage("CheckPurchaseBillUI",user,null);break;
		case INVENTORYBILL:changeStage("CheckInventoryBillUI",user,null);break;
		case SALESBILL:changeStage("CheckSakesBillUI",user,null);break;
		case SKD:changeStage("CheckPaymentBillUI",user,null);break;
		case XJFYD:changeStage("CheckReceiveBillUI",user,null);break;
		default:break;
		}
	}

	public void initData(UserVO user) throws Exception {
           this.user = user;
           choiceInit();
	}


	public void choiceInit() throws RemoteException{
		receiptChoice.setItems(FXCollections.observableArrayList(BillType.PURCHASEBILL.value,BillType.INVENTORYBILL.value,
				BillType.SALESBILL.value,BillType.SKD.value,BillType.XJFYD.value));
	}
}
