package SIMSclient.src.presentation.financialstaffui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.skdbl.SKDBL;
import SIMSclient.src.bussinesslogicservice.mfdocblservice.skdblservice;
import SIMSclient.src.dataenum.findtype.FindAccountType;
import SIMSclient.src.vo.AccountVO;
import SIMSclient.src.vo.makefinancialdoc.EntryListVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PaymentMakeBillUI extends MakeReceiptUI{
	skdblservice service = SKDBL.getInstance().getSKDBLService();
	ObservableList<EntryListVO> list = FXCollections.observableArrayList();
	@FXML
	Label idLabel;
	@FXML
	TextField accountField;
	@FXML
	TextField sumField;
	@FXML
	Label operatorLabel;

	@FXML
	TableView<EntryListVO> table;
	@FXML
	TableColumn<EntryListVO,String> tableItem;
	@FXML
	TableColumn<EntryListVO,String> tableMoney;
	@FXML
	TableColumn<EntryListVO,String> tableDescription;
	@FXML
	TableColumn<EntryListVO,String> tableDelete;

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
	public void fresh(){
		 accountField.setText(null);
         sumField.setText(null);
         itemField.setText(null);
         moneyField.setText(null);
         descriptionArea.setText(null);
	}

	@FXML
	public void checkBefore(){

	}

	public void start() throws Exception {
		   changeStage("PaymentMakeBillUI","PaymentMakeBillUI.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idLabel.setText(service.);
		fresh();
        operatorLabel.setText(user.getName());
	}

	public void manageInit(){
		tableItem.setCellValueFactory(
                new PropertyValueFactory<EntryListVO,String>("entryName"));
        tableMoney.setCellValueFactory(
                new PropertyValueFactory<EntryListVO,String>("transferAmount"));
        tableDescription.setCellValueFactory(
                new PropertyValueFactory<EntryListVO,String>("note"));
        deleteInit();
	}

	public void deleteInit(){
		tableDelete.setCellFactory((col) -> {
            TableCell<EntryListVO, String> cell = new TableCell<EntryListVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("É¾³ý");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	EntryListVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            list.remove(clickedItem);
                            table.setItems(list);
                        });
                    }
                }

            };
            return cell;
        });
	}


}
