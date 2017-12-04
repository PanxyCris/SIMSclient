package SIMSclient.src.presentation.financialstaffui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PaymentMakeBillUI extends MakeReceiptUI{
	@FXML
	Label idLabel;
	@FXML
	TextField accountField;
	@FXML
	TextField sumField;
	@FXML
	Label operatorLabel;

	@FXML
	TableView table;
	@FXML
	TableColumn tableItem;
	@FXML
	TableColumn tableMoney;
	@FXML
	TableColumn tableDescription;

	@FXML
	TextField itemField;
	@FXML
	TextField moneyField;
	@FXML
	TextArea descriptionArea;

	@FXML
	public void insert(){

	}

	@FXML
	public void save(){

	}

	@FXML
	public void cancel(){

	}

	@FXML
	public void checkBefore(){

	}

	public void start() throws Exception {
		   changeStage("PaymentMakeBillUI","PaymentMakeBillUI.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        operatorLabel.setText(user.getName());
	}
}
