package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import dataenum.BillType;
import dataenum.Remind;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class ExamineBillController extends GeneralManagerController {
	
	@FXML
	protected ChoiceBox<String> receiptChoice;

	@FXML
	public void chooseReceipt() throws Exception{
		BillType type = BillType.getType(receiptChoice.getValue());
		switch(type){
		case PURCHASEBILL:changeStage("ExaminePurchaseBillUI",user,type);break;
		case INVENTORYBILL:changeStage("ExamineInventoryBillUI",user,type);break;
		case SALESBILL:changeStage("ExamineSalesBillUI",user,type);break;
		case SKD:changeStage("ExaminePaymentBillUI",user,type);break;
		case XJFYD:changeStage("ExamineReceiveBillUI",user,type);break;
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
