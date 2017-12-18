package presentation.financialstaffui.controller;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

import bussiness_stub.PaymentBillBLService_Stub;
import bussiness_stub.UtilityBLService_Stub;
import bussinesslogic.accountbillbl.PaymentBillController;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
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
import presentation.financialstaffui.PaymentCheckBillUI;
import presentation.remindui.RemindExistUI;
import presentation.remindui.RemindPrintUI;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;
import vo.uservo.UserVO;

public class PaymentMakeBillController extends MakeReceiptController {

	PaymentBillBLService service = new PaymentBillBLService_Stub();
	ObservableList<EntryVO> list = FXCollections.observableArrayList();
	UserVO user;
	PaymentBillVO bill;

	@FXML
	Label idLabel;
	@FXML
	ChoiceBox<String> accountChoice;
	@FXML
	ChoiceBox<String> memberChoice;
	@FXML
	Label sumLabel;
	@FXML
	Label operatorLabel;
	@FXML
	TextArea receiptArea;

	@FXML
	TableView<EntryVO> table;
	@FXML
	TableColumn<EntryVO,String> tableItem;
	@FXML
	TableColumn<EntryVO,Double> tableMoney;
	@FXML
	TableColumn<EntryVO,String> tableDescription;
	@FXML
	TableColumn<EntryVO,String> tableDelete;

	@FXML
	TextField itemField;
	@FXML
	TextField moneyField;
	@FXML
	TextArea noteArea;

	@FXML
	public void insert(){
		 EntryVO vo = new EntryVO(itemField.getText(), Double.parseDouble(moneyField.getText()), noteArea.getText());
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
		ArrayList<EntryVO> entryList = new ArrayList<>();
		entryList.addAll(list);
         PaymentBillVO vo = new PaymentBillVO(idLabel.getText(),operatorLabel.getText(),memberChoice.getValue(),
        		            accountChoice.getValue(),entryList,Double.parseDouble(sumLabel.getText()),BillType.XJFYD,BillState.DRAFT,receiptArea.getText());
         service.save(vo);
	}

	@FXML
	public void submit(){
		ArrayList<EntryVO> entryList = new ArrayList<>();
		entryList.addAll(list);
		PaymentBillVO vo = new PaymentBillVO(idLabel.getText(),operatorLabel.getText(),memberChoice.getValue(),
		            accountChoice.getValue(),entryList,Double.parseDouble(sumLabel.getText()),BillType.XJFYD,BillState.COMMITED,receiptArea.getText());
        service.save(vo);
	}

	@FXML
	public void fresh(){
		if(bill != null){
        	 accountChoice.setValue(bill.getAccountID());
             memberChoice.setValue(bill.getCustomerID());
             receiptArea.setText(bill.getNote());
        }
         itemField.setText(null);
         noteArea.setText(null);
         receiptArea.setText(null);
	}

	@FXML
	public void checkBefore() throws Exception{
          changeStage("PaymentCheckBillUI",user,null,null);
	}

	public void initData(UserVO user,PaymentBillVO bill) throws Exception {
		   this.user = user;
		   this.bill = bill;
			if(bill == null){
				UtilityBLService utilityService = new UtilityBLService_Stub();
				idLabel.setText(utilityService.generateID(BillType.XJFYD));
			    sumLabel.setText("0");
				operatorLabel.setText(user.getName());
				}
				else{
					idLabel.setText(bill.getId());
					sumLabel.setText(String.valueOf(bill.getTotal()));
					list.addAll(bill.getEntryListVO());
					table.setItems(list);
					operatorLabel.setText(bill.getUserID());

				}
			    choiceInit();
				fresh();

				edit();
				manageInit();
	}

	public void choiceInit(){
		accountChoice.setItems(FXCollections.observableArrayList(service.getAccountList()));
		memberChoice.setItems(FXCollections.observableArrayList(service.getCustomerList()));
		if(bill!=null){
			accountChoice.setValue(bill.getAccountID());
			memberChoice.setValue(bill.getCustomerID());
		}
	}



	public void edit(){
		Callback<TableColumn<EntryVO, String>,
            TableCell<EntryVO, String>> cellFactory
                = (TableColumn<EntryVO, String> p) -> new EditingCell<EntryVO>();

        tableItem.setCellFactory(cellFactory);
        tableItem.setOnEditCommit(
            (CellEditEvent<EntryVO, String> t) -> {
               ((EntryVO) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEntryName(t.getNewValue());
        });

        tableDescription.setCellFactory(cellFactory);
        tableDescription.setOnEditCommit(
            (CellEditEvent<EntryVO, String> t) -> {
	               ((EntryVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNote(t.getNewValue());
        });
	}


	public void manageInit(){
		tableItem.setCellValueFactory(
                new PropertyValueFactory<EntryVO,String>("entryName"));
        tableMoney.setCellValueFactory(
                new PropertyValueFactory<EntryVO,Double>("transferAmount"));
        tableDescription.setCellValueFactory(
                new PropertyValueFactory<EntryVO,String>("note"));
        deleteInit();
	}

	public void deleteInit(){
		tableDelete.setCellFactory((col) -> {
            TableCell<EntryVO, String> cell = new TableCell<EntryVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("É¾³ý");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	EntryVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            list.remove(clickedItem);
                            table.setItems(list);
                            double tmp = clickedItem.getTransferAmount();
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
