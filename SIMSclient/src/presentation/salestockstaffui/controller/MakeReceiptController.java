package presentation.salestockstaffui.controller;

import java.net.URL;

import java.rmi.RemoteException;
import java.util.ResourceBundle;

import dataenum.BillType;
import dataenum.Remind;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class MakeReceiptController extends SaleStockStaffController implements Initializable {

	public static final Remind remind = Remind.BILL;
	@FXML
	ChoiceBox<String> receiptChoice;

	@FXML
	public void chooseReceipt() throws Exception{
		BillType type = BillType.getType(receiptChoice.getValue());
		switch(type){
		case PURCHASEBILL:changeStage("PurchaseMakeBillUI",user,type,null,null);break;
		case PURCHASEBACKBILL:changeStage("PurchaseMakeBillUI",user,type,null,null);break;
		case SALESBILL:changeStage("SakesMakeBillUI",user,type,null,null);break;
		case SALESBACKBILL:changeStage("SalesMakeBillUI",user,type,null,null);break;
		default:break;
		}
	}

	public void initData(UserVO user) throws Exception {
           this.user = user;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			choiceInit();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void choiceInit() throws RemoteException{
		receiptChoice.setItems(FXCollections.observableArrayList(BillType.PURCHASEBILL.value,BillType.PURCHASEBACKBILL.value,
				BillType.SALESBILL.value,BillType.SALESBACKBILL.value));
	}

}
