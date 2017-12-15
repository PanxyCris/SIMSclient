package presentation.financialstaffui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussiness_stub.PaymentBillBLService_Stub;
import bussiness_stub.ReceiptBillBLService_Stub;
import bussiness_stub.UtilityBLService_Stub;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import presentation.remindui.RemindExistUI;
import presentation.remindui.RemindPrintUI;
import vo.UserVO;
import vo.FinancialBill.AccountListVO;
import vo.FinancialBill.EntryVO;
import vo.FinancialBill.PaymentBillVO;
import vo.FinancialBill.ReceiptBillVO;

public class ReceiveMakeBillController extends MakeReceiptController {


	ReceiptBillBLService service = new ReceiptBillBLService_Stub();
	ObservableList<AccountListVO> list = FXCollections.observableArrayList();
	UserVO user;
	ReceiptBillVO bill;


	@FXML
	Label idLabel;
	@FXML
	ChoiceBox<String> memberChoice;
	@FXML
	Label sumLabel;
	@FXML
	Label operatorLabel;

	@FXML
	TableView<AccountListVO> table;
	@FXML
	TableColumn<AccountListVO,String> tableAccount;
	@FXML
	TableColumn<AccountListVO,String> tableMoney;
	@FXML
	TableColumn<AccountListVO,String> tableDescription;
	@FXML
	TableColumn<AccountListVO,String> tableDelete;

	@FXML
	ChoiceBox<String> accountChoice;
	@FXML
	TextField moneyField;
	@FXML
	TextArea noteArea;

	@FXML
	public void insert(){
		 AccountListVO vo = new  AccountListVO(accountChoice.getValue(), moneyField.getText(), noteArea.getText());
	        ResultMessage message = service.judgeLegal(moneyField.getText());
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        case EXISTED:new RemindExistUI().start(remind,true);break;
	    	        case SUCCESS:list.add(vo);table.setItems(list);
	    	                     double result = Double.parseDouble(sumLabel.getText())+Double.parseDouble(moneyField.getText());
	    	                     sumLabel.setText(String.valueOf(result));break;
	    	        default:break;
	    	        }
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
	}

	@FXML
	public void save(){
		ArrayList<AccountListVO> accountList = new ArrayList<>();
		accountList.addAll(list);
         ReceiptBillVO vo = new ReceiptBillVO(idLabel.getText(),operatorLabel.getText(),memberChoice.getValue(),
        		            BillType.XJFYD,BillState.DRAFT,accountList,sumLabel.getText());
         service.save(vo);
	}

	@FXML
	public void submit(){
		ArrayList<AccountListVO> accountList = new ArrayList<>();
		accountList.addAll(list);
         ReceiptBillVO vo = new ReceiptBillVO(idLabel.getText(),operatorLabel.getText(),memberChoice.getValue(),
        		            BillType.XJFYD,BillState.COMMITED,accountList,sumLabel.getText());
         service.commit(vo);
	}

	@FXML
	public void fresh(){
		if(bill != null){
             memberChoice.setValue(bill.getCustomerID());
        }
         accountChoice.setValue(null);
         noteArea.setText(null);
	}

	@FXML
	public void checkBefore() throws Exception{
          changeStage("ReceiveCheckBillUI",user,null,null);
	}

	public void initData(UserVO user,ReceiptBillVO bill) throws Exception {
		   this.user = user;
		   this.bill = bill;
			if(bill == null){
				UtilityBLService utilityService = new UtilityBLService_Stub();
				idLabel.setText(utilityService.generateID(BillType.SKD));
			    sumLabel.setText("0");
				operatorLabel.setText(user.getName());
				}
				else{
					idLabel.setText(bill.getDocID());
					sumLabel.setText(bill.getTotal());
					list.addAll(bill.getAccountListVOs());
					table.setItems(list);
					operatorLabel.setText(bill.getUserID());

				}
			    choiceInit();
				fresh();

				edit();
				manageInit();
	}

	public void choiceInit(){


		ArrayList<String> accountID = new ArrayList<>();
		for(int i=0;i<service.getAccountList().size();i++)
			accountID.add(service.getAccountList().get(i).getId());
		accountChoice.setItems(FXCollections.observableArrayList(accountID));

		ArrayList<String> memberID = new ArrayList<>();
		for(int i=0;i<service.getCustomerList().size();i++)
			memberID.add(service.getCustomerList().get(i).getID());
		memberChoice.setItems(FXCollections.observableArrayList(memberID));
	}



	public void edit(){

		ObservableList<String> accountList = FXCollections.observableArrayList();
		for(int i=0;i<service.getAccountList().size();i++)
		accountList.add(service.getAccountList().get(i).getId());

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
                new PropertyValueFactory<AccountListVO,String>("money"));
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
                        Button delBtn = new Button("É¾³ý");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	AccountListVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            list.remove(clickedItem);
                            table.setItems(list);
                            double tmp = Double.parseDouble(clickedItem.getMoney());
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
