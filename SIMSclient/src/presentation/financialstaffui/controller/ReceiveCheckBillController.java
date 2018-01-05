package presentation.financialstaffui.controller;

import java.util.ArrayList;
import java.util.Optional;

import bussinesslogic.accountbillbl.ReceiptBillController;
import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.billvo.financialbillvo.AccountListVO;
import vo.billvo.financialbillvo.ReceiptBillVO;
import vo.uservo.UserVO;


public class ReceiveCheckBillController extends FinancialStaffController{

	ReceiptBillBLService service = new ReceiptBillController();
	ObservableList<ReceiptBillVO> list = FXCollections.observableArrayList();
	ObservableList<AccountListVO> accountVOList = FXCollections.observableArrayList();

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;


	@FXML
	TableView<ReceiptBillVO> table;
	@FXML
	TableColumn<ReceiptBillVO,String> tableID;
	@FXML
	TableColumn<ReceiptBillVO,String> tableMember;
	@FXML
	TableColumn<ReceiptBillVO,Double> tableSum;
	@FXML
	TableColumn<ReceiptBillVO,String> tableOperator;
	@FXML
	TableColumn<ReceiptBillVO,String> tableRemark;
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

	@FXML
	public void find(){
		if(findingField.getText()==null||findChoice.getValue()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"请填写好查询信息");
			warning.showAndWait();
		}else{
		ArrayList<ReceiptBillVO> list = service.find(findingField.getText(),FindAccountBillType.getType(findChoice.getValue()));
	       if(list==null){
	    	   Alert error = new Alert(Alert.AlertType.WARNING,ResultMessage.NOTFOUND.value);
               error.showAndWait();
	       }
	       else{
	    	   table.getItems().clear();
	    	   table.getItems().addAll(list);
	       }
		}
	}



	public void initData(UserVO user) {
		this.user = user;
		list.addAll(service.show());
		table.setItems(list);
		manageInit();
		listInit();
		findChoice.setItems(FXCollections.observableArrayList(FindAccountBillType.BILLID.value,FindAccountBillType.CUSTOMER.value,
				FindAccountBillType.OPERATOR.value));
	}

	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("id"));
		tableMember.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("customer"));
		tableSum.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,Double>("total"));
		tableOperator.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("userID"));
		tableRemark.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("note"));
		tableState.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("stateString"));
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
                        Button delBtn = new Button("查看转账列表");
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
                    if (!empty&&this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT){
                        Button delBtn = new Button("提交");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	ReceiptBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                        	clickedItem.setState(BillState.COMMITED);
                        	ResultMessage message = service.commit(clickedItem);
                            if(message == ResultMessage.SUCCESS){
                           	 this.getTableView().getItems().get(this.getIndex()).setState(BillState.COMMITED);
                                printInfo(ResultMessage.COMMITED);
                                try {
									fresh();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                            }
                            else
                         	   printWrong(message);
                        });
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
                    if (!empty&&(this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT
                    		||this.getTableView().getItems().get(this.getIndex()).getState()== BillState.FAIL)) {
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
                    if (!empty&&(this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT
                    		||this.getTableView().getItems().get(this.getIndex()).getState()== BillState.FAIL)) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	ReceiptBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                        	 try {
	                            	Alert alert = new Alert(AlertType.CONFIRMATION);
	                            	alert.setContentText("确认删除？");
	                            	Optional<ButtonType> result = alert.showAndWait();
	                            	if (result.get() == ButtonType.OK){
	                            		service.delete(clickedItem);
	                            		  list.remove(clickedItem);
	      	                              table.setItems(list);
	                            	}
								} catch (Exception e) {
									e.printStackTrace();
								}

                        });
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
