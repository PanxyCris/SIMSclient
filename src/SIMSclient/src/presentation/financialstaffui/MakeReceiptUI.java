package SIMSclient.src.presentation.financialstaffui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class MakeReceiptUI extends FinancialStaffUI implements Initializable{

	@FXML
	ChoiceBox<String> receiptChoice;
	@FXML
	public void chooseReceipt() throws Exception{
		String value = receiptChoice.getValue();
		switch(value){
		case "�տ":new ReceiveMakeBillUI().start();break;
		case "���":new PaymentMakeBillUI().start();break;
		}
	}

	public void start() throws Exception {
		   changeStage("MakeReceiptUI","MakeReceiptUI.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		receiptChoice.setItems(FXCollections.observableArrayList("���","�տ"));

	}

}
