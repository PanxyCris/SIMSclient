package presentation.financialstaffui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import bussiness_stub.PaymentBillBLService_Stub;
import bussiness_stub.ReceiptBillBLService_Stub;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import dataenum.BillState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.UserVO;
import vo.FinancialBill.AccountListVO;
import vo.FinancialBill.EntryVO;
import vo.FinancialBill.PaymentBillVO;
import vo.FinancialBill.ReceiptBillVO;

public class ReceiveCheckBillController extends FinancialStaffController implements Initializable{

	ReceiptBillBLService service = new ReceiptBillBLService_Stub();
	ObservableList<ReceiptBillVO> list = FXCollections.observableArrayList();
	ObservableList<AccountListVO> accountVOList = FXCollections.observableArrayList();
	@FXML
	TableView<ReceiptBillVO> table;
	@FXML
	TableColumn<ReceiptBillVO,String> tableID;
	@FXML
	TableColumn<ReceiptBillVO,String> tableMember;
	@FXML
	TableColumn<ReceiptBillVO,String> tableSum;
	@FXML
	TableColumn<ReceiptBillVO,String> tableOperator;
	@FXML
	TableColumn<ReceiptBillVO,String> tableCheck;
	@FXML
	TableColumn<ReceiptBillVO,String> tableState;
	@FXML
	TableColumn<ReceiptBillVO,String> tableSubmit;
	@FXML
	TableColumn<ReceiptBillVO,String> tableRedo;
	@FXML
	TableColumn<ReceiptBillVO,String> tableDelete;


	@FXML
	TableView<AccountListVO> accountList;
	@FXML
	TableColumn<AccountListVO,String> tableAccount;
	@FXML
	TableColumn<AccountListVO,String> tableMoney;
	@FXML
	TableColumn<AccountListVO,String> tableDescription;


	@FXML
	public void makeReceiveBill() throws Exception{
         changeStage("ReceiveMakeBillUI",user,null,null);
	}


	public void initData(UserVO user) {
		this.user = user;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.addAll(service.find());
		table.setItems(list);
		manageInit();
		listInit();
	}


	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("docID"));
		tableMember.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("customerID"));
		tableSum.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("total"));
		tableOperator.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("userID"));
		tableState.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("billStateString"));
		checkInit();
		submitInit();
		redoInit();
        deleteInit();
	}

	public void checkInit(){

		tableCheck.setCellFactory((col) -> {
            TableCell<ReceiptBillVO, String> cell = new TableCell<ReceiptBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("查看商品列表");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	ReceiptBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            accountVOList.clear();
                            accountVOList.addAll(clickedItem.getAccountListVOs());
                            accountList.setItems(accountVOList);

                        });
                    }
                }

            };
            return cell;
        });

	}

	public void submitInit(){

		tableSubmit.setCellFactory((col) -> {
            TableCell<ReceiptBillVO, String> cell = new TableCell<ReceiptBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
              for(int i=0;i< this.getTableView().getItems().size();i++){
                   BillState clickedState = this.getTableView().getItems().get(i).getBillState();
                    if (!empty&&clickedState == BillState.DRAFT) {
                        Button delBtn = new Button("提交");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	ReceiptBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
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
            TableCell<ReceiptBillVO, String> cell = new TableCell<ReceiptBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    for(int i=0;i< this.getTableView().getItems().size();i++){
                   BillState clickedState = this.getTableView().getItems().get(i).getBillState();
                    if (!empty&&(clickedState == BillState.DRAFT||clickedState == BillState.FAIL)) {
                        Button delBtn = new Button("重做");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	ReceiptBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            try {
								changeStage("ReceiveMakeBillUI",user,null,clickedItem);
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
            TableCell<ReceiptBillVO, String> cell = new TableCell<ReceiptBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    for(int i=0;i< this.getTableView().getItems().size();i++){
                    BillState clickedState = this.getTableView().getItems().get(i).getBillState();
                    if (!empty&&(clickedState == BillState.DRAFT||clickedState == BillState.FAIL)) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	ReceiptBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
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
		tableAccount.setCellValueFactory(
                new PropertyValueFactory<AccountListVO,String>("accountID"));
        tableMoney.setCellValueFactory(
                new PropertyValueFactory<AccountListVO,String>("money"));
        tableDescription.setCellValueFactory(
                new PropertyValueFactory<AccountListVO,String>("note"));
	}


}
