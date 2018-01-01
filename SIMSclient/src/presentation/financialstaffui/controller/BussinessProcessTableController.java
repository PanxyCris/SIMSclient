package presentation.financialstaffui.controller;

import java.rmi.RemoteException;
import dataenum.BillType;
import dataenum.Remind;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class BussinessProcessTableController extends ViewTableController{

	@FXML
	ChoiceBox<String> receiptChoice;

	@FXML
	public void chooseReceipt() throws Exception{
		if(receiptChoice.getValue()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"��ѡ����Ҫ�鿴�ĵ���");
			warning.showAndWait();
		}
		else{
		BillType type = BillType.getType(receiptChoice.getValue());
		switch(type){
		case PURCHASEBILL:changeStage("ExaminePurchaseBillUI",user,null,null);break;
		case INVENTORYBILL:changeStage("ExamineInventoryBillUI",user,null,null);break;
		case SALESBILL:changeStage("ExamineSakesBillUI",user,null,null);break;
		case SKD:changeStage("ExaminePaymentBillUI",user,null,null);break;
		case XJFYD:changeStage("ExamineReceiveBillUI",user,null,null);break;
		default:break;
		}
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
