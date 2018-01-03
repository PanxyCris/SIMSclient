package presentation.financialstaffui.controller;

import java.util.ArrayList;
import bussiness_stub.ReceiptBillBLService_Stub;
import bussiness_stub.UtilityBLService_Stub;
import bussinesslogic.accountbillbl.ReceiptBillController;
import bussinesslogic.utilitybl.UtilityBL;
import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.common.EditingCellChoice;
import vo.billvo.financialbillvo.AccountListVO;
import vo.billvo.financialbillvo.ReceiptBillVO;
import vo.uservo.UserVO;


public class ReceiveMakeBillController extends MakeReceiptController {


	ReceiptBillBLService service = new ReceiptBillController();
	ObservableList<AccountListVO> list = FXCollections.observableArrayList();

	@FXML
	Label idLabel;
	@FXML
	ComboBox<String> memberChoice;
	@FXML
	Label sumLabel;
	@FXML
	Label operatorLabel;
	@FXML
	TextArea receiptArea;

	@FXML
	TableView<AccountListVO> table;
	@FXML
	TableColumn<AccountListVO,String> tableAccount;
	@FXML
	TableColumn<AccountListVO,Double> tableMoney;
	@FXML
	TableColumn<AccountListVO,String> tableDescription;
	@FXML
	TableColumn<AccountListVO,String> tableDelete;

	@FXML
	ComboBox<String> accountChoice;
	@FXML
	TextField moneyField;
	@FXML
	TextArea noteArea;

	@FXML
	public void insert(){
		if(accountChoice.getValue()==null||moneyField.getText()==null||noteArea.getText()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"请填写好所有的信息");
			warning.showAndWait();
		}
		else{
	 AccountListVO vo = new  AccountListVO(accountChoice.getValue(), Double.parseDouble(moneyField.getText()), noteArea.getText());
        list.add(vo);table.setItems(list);
	   double result = Double.parseDouble(sumLabel.getText())+Double.parseDouble(moneyField.getText());
	   sumLabel.setText(String.valueOf(result));
       }
	}

	@FXML
	public void save(){
		ArrayList<AccountListVO> accountList = new ArrayList<>();
		accountList.addAll(list);
         ReceiptBillVO vo = new ReceiptBillVO(idLabel.getText(),operatorLabel.getText(),memberChoice.getValue(),
        		            BillType.XJFYD,BillState.DRAFT,accountList,Double.parseDouble(sumLabel.getText()),receiptArea.getText());
         ResultMessage message = service.save(vo);
         if(message == ResultMessage.SUCCESS){
             printInfo(ResultMessage.SAVED);
             try {
				fresh();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             }
         else
      	   printWrong(message);
	}

	@FXML
	public void submit(){
		ArrayList<AccountListVO> accountList = new ArrayList<>();
		accountList.addAll(list);
         ReceiptBillVO vo = new ReceiptBillVO(idLabel.getText(),operatorLabel.getText(),memberChoice.getValue(),
        		            BillType.XJFYD,BillState.COMMITED,accountList,Double.parseDouble(sumLabel.getText()),receiptArea.getText());
         ResultMessage message = service.commit(vo);
         if(message == ResultMessage.SUCCESS){
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
	}

	@FXML
	public void checkBefore() throws Exception{
          changeStage("ReceiveCheckBillUI",user,null,null);
	}

	public void initData(UserVO user,ReceiptBillVO bill) throws Exception {
		   this.user = user;
		   this.rec = bill;
			if(bill == null){
				UtilityBLService utilityService = new UtilityBL();
				idLabel.setText(utilityService.generateID(BillType.SKD));
			    sumLabel.setText("0");
				operatorLabel.setText(readUser().getName());
				}
				else{
					idLabel.setText(bill.getId());
					sumLabel.setText(String.valueOf(bill.getTotal()));
					list.addAll(bill.getAccountListVOs());
					table.setItems(list);
					operatorLabel.setText(bill.getUserID());

				}
			    choiceInit();
				if(rec != null){
		             memberChoice.setValue(rec.getCustomerID());
		        }
		         accountChoice.setValue(null);
		         noteArea.setText(null);

				edit();
				manageInit();
	}

	public void choiceInit(){
		accountChoice.setItems(FXCollections.observableArrayList(service.getAccountList()));
		memberChoice.setItems(FXCollections.observableArrayList(service.getCustomerList()));
	}



	public void edit(){

		ObservableList<String> accountList = FXCollections.observableArrayList();
        accountList.addAll(service.getAccountList());

		Callback<TableColumn<AccountListVO, String>,
            TableCell<AccountListVO, String>> cellFactory
                = (TableColumn<AccountListVO, String> p) -> new EditingCell<AccountListVO>();
        Callback<TableColumn<AccountListVO, String>,
            TableCell<AccountListVO, String>> cellFactoryChoice
                = (TableColumn<AccountListVO, String> p) -> new EditingCellChoice<AccountListVO>(accountList);

        tableAccount.setCellFactory(cellFactoryChoice);
        tableAccount.setOnEditCommit(
             (CellEditEvent<AccountListVO, String> t) -> {
    	               ((AccountListVO) t.getTableView().getItems().get(
    	                        t.getTablePosition().getRow())
    	                        ).setAccountID(t.getNewValue());
            });


        tableDescription.setCellFactory(cellFactory);
        tableDescription.setOnEditCommit(
            (CellEditEvent<AccountListVO, String> t) -> {
	               ((AccountListVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNote(t.getNewValue());
        });
	}



	public void manageInit(){
		tableAccount.setCellValueFactory(
                new PropertyValueFactory<AccountListVO,String>("accountID"));
        tableMoney.setCellValueFactory(
                new PropertyValueFactory<AccountListVO,Double>("money"));
        tableDescription.setCellValueFactory(
                new PropertyValueFactory<AccountListVO,String>("note"));
        deleteInit();
	}

	public void deleteInit(){
		tableDelete.setCellFactory((col) -> {
            TableCell<AccountListVO, String> cell = new TableCell<AccountListVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	AccountListVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            list.remove(clickedItem);
                            table.setItems(list);
                            double tmp = clickedItem.getMoney();
                            double result = Double.parseDouble(sumLabel.getText())-tmp;
                            sumLabel.setText(String.valueOf(result));
                        });
                    }
                }

            };
            return cell;
        });
	}




}
