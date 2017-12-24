package presentation.financialstaffui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import bussiness_stub.PaymentBillBLService_Stub;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.remindui.RemindPrintUI;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;
import vo.uservo.UserVO;

public class PaymentCheckBillController extends FinancialStaffController implements Initializable{

	PaymentBillBLService service = new PaymentBillBLService_Stub();
	ObservableList<PaymentBillVO> list = FXCollections.observableArrayList();
	ObservableList<EntryVO> entryList = FXCollections.observableArrayList();

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	TableView<PaymentBillVO> table;
	@FXML
	TableColumn<PaymentBillVO,String> tableID;
	@FXML
	TableColumn<PaymentBillVO,String> tableAccount;
	@FXML
	TableColumn<PaymentBillVO,Double> tableSum;
	@FXML
	TableColumn<PaymentBillVO,String> tableOperator;
	@FXML
	TableColumn<PaymentBillVO,String> tableRemark;
	@FXML
	TableColumn<PaymentBillVO,String> tableCheck;
	@FXML
	TableColumn<PaymentBillVO,String> tableState;
	@FXML
	TableColumn<PaymentBillVO,String> tableSubmit;
	@FXML
	TableColumn<PaymentBillVO,String> tableRedo;
	@FXML
	TableColumn<PaymentBillVO,String> tableDelete;


	@FXML
	TableView<EntryVO> itemList;
	@FXML
	TableColumn<EntryVO,String> tableItem;
	@FXML
	TableColumn<EntryVO,Double> tableMoney;
	@FXML
	TableColumn<EntryVO,String> tableNote;


	@FXML
	public void makePaymentBill() throws Exception{
         changeStage("PaymentMakeBillUI",user,null,null);
	}

	@FXML
	public void find(){

		ArrayList<PaymentBillVO> list = service.find(findingField.getText(),FindAccountBillType.getType(findChoice.getValue()));
	       if(list==null){
	    	   Platform.runLater(new Runnable() {
		    	    public void run() {
		    	        try {
		    	        	new RemindPrintUI().start(ResultMessage.ILLEAGLINPUTDATA);
						} catch (Exception e) {
							e.printStackTrace();
						}
		    	    }
		    	});
	       }
	       else{
	    	   table.getItems().clear();
	    	   table.getItems().addAll(list);
	       }

	}


	public void initData(UserVO user) {
		this.user = user;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.addAll(service.show());
		table.setItems(list);
		manageInit();
		listInit();
		findChoice.setItems(FXCollections.observableArrayList(FindAccountBillType.BILLID.value,FindAccountBillType.CUSTOMER.value,
				FindAccountBillType.OPERATOR.value));

	}


	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,String>("id"));
		tableAccount.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,String>("accountID"));
		tableSum.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,Double>("total"));
		tableOperator.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,String>("userID"));
		tableRemark.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,String>("note"));
		tableState.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,String>("stateString"));
		checkInit();
		submitInit();
		redoInit();
        deleteInit();
	}

	public void checkInit(){

		tableCheck.setCellFactory((col) -> {
            TableCell<PaymentBillVO, String> cell = new TableCell<PaymentBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("查看商品列表");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PaymentBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            entryList.clear();
                            entryList.addAll(clickedItem.getEntryListVO());
                            itemList.setItems(entryList);

                        });
                    }
                }

            };
            return cell;
        });

	}

	public void submitInit(){

		tableSubmit.setCellFactory((col) -> {
            TableCell<PaymentBillVO, String> cell = new TableCell<PaymentBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
              for(int i=0;i< this.getTableView().getItems().size();i++){
                   BillState clickedState = this.getTableView().getItems().get(i).getState();
                    if (!empty&&clickedState == BillState.DRAFT) {
                        Button delBtn = new Button("提交");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PaymentBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            service.commit(clickedItem);
                        });
                    }
                  }
                }

            };
            return cell;
        });

	}

	public void redoInit(){

		tableRedo.setCellFactory((col) -> {
            TableCell<PaymentBillVO, String> cell = new TableCell<PaymentBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    for(int i=0;i< this.getTableView().getItems().size();i++){
                   BillState clickedState = this.getTableView().getItems().get(i).getState();
                    if (!empty&&(clickedState == BillState.DRAFT||clickedState == BillState.FAIL)) {
                        Button delBtn = new Button("重做");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PaymentBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            try {
								changeStage("PaymentMakeBillUI",user,clickedItem,null);
							} catch (Exception e) {
								e.printStackTrace();
							}
                        });
                    }
                    }
                }

            };
            return cell;
        });


	}


	public void deleteInit(){
		tableDelete.setCellFactory((col) -> {
            TableCell<PaymentBillVO, String> cell = new TableCell<PaymentBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    for(int i=0;i< this.getTableView().getItems().size();i++){
                    BillState clickedState = this.getTableView().getItems().get(i).getState();
                    if (!empty&&(clickedState == BillState.DRAFT||clickedState == BillState.FAIL)) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PaymentBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                        	service.delete(clickedItem);
                            list.remove(clickedItem);
                            table.setItems(list);

                        });
                    }
                }
              }
            };
            return cell;
        });
	}

	public void listInit(){
		tableItem.setCellValueFactory(
                new PropertyValueFactory<EntryVO,String>("entryName"));
        tableMoney.setCellValueFactory(
                new PropertyValueFactory<EntryVO,Double>("transferAmount"));
        tableNote.setCellValueFactory(
                new PropertyValueFactory<EntryVO,String>("note"));
	}





}
