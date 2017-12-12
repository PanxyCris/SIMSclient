package presentation.salestockstaffui;

import java.net.URL;
import java.util.ResourceBundle;

import dataenum.BillType;
import dataenum.Remind;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class MakeReceiptUI extends SaleStockStaffUI implements Initializable{

	public static final Remind remind = Remind.BILL;
	@FXML
	ChoiceBox<String> receiptChoice;
	@FXML
	public void chooseReceipt() throws Exception{
		BillType type = BillType.getType(receiptChoice.getValue());
		switch(type){
		case PURCHASEBILL:new PurchaseMakeBillUI().start(type);break;
		case PURCHASEBACKBILL:new PurchaseMakeBillUI().start(type);break;
		case SALESBILL:
		case SALESBACKBILL:
		default:break;
		}
	}

	public void start() throws Exception {
		   changeStage("MakeReceiptUI","MakeReceiptUI.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		receiptChoice.setItems(FXCollections.observableArrayList(BillType.PURCHASEBILL.value,BillType.PURCHASEBACKBILL.value,
				BillType.SALESBILL.value,BillType.SALESBACKBILL.value));
	}

}
