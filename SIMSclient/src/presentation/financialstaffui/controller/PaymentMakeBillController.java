package presentation.financialstaffui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.accountbillbl.PaymentBillController;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import javafx.application.Platform;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.financialstaffui.PaymentCheckBillUI;
import presentation.remindui.RemindExistUI;
import presentation.remindui.RemindPrintUI;
import vo.UserVO;
import vo.FinancialBill.EntryVO;
import vo.FinancialBill.PaymentBillVO;

public class PaymentMakeBillController extends MakeReceiptController {

	PaymentBillBLService service = new PaymentBillController();
	ObservableList<EntryVO> list = FXCollections.observableArrayList();
	@FXML
	Label idLabel;
	@FXML
	TextField accountField;
	@FXML
	TextField memberField;
	@FXML
	Label sumLabel;
	@FXML
	Label operatorLabel;

	@FXML
	TableView<EntryVO> table;
	@FXML
	TableColumn<EntryVO,String> tableItem;
	@FXML
	TableColumn<EntryVO,String> tableMoney;
	@FXML
	TableColumn<EntryVO,String> tableDescription;
	@FXML
	TableColumn<EntryVO,String> tableDelete;

	@FXML
	TextField itemField;
	@FXML
	TextField moneyField;
	@FXML
	TextArea descriptionArea;

	@FXML
	public void insert(){
		 EntryVO vo = new EntryVO(itemField.getText(), moneyField.getText(), descriptionArea.getText());
	        ResultMessage message = service.judgeLegal(moneyField.getText());
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        case EXISTED:new RemindExistUI().start(remind,true);break;
	    	        case SUCCESS:list.add(vo);table.setItems(list);
	    	                     int result = Integer.parseInt(sumLabel.getText())+Integer.parseInt(moneyField.getText());
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
         PaymentBillVO vo = new PaymentBillVO(idLabel.getText(),operatorLabel.getText(),memberField.getText(),
        		            accountField.getText(),entryList,sumLabel.getText(),BillType.XJFYD,BillState.DRAFT);
         service.save(vo);
	}

	@FXML
	public void submit(){
		ArrayList<EntryVO> entryList = new ArrayList<>();
		entryList.addAll(list);
         PaymentBillVO vo = new PaymentBillVO(idLabel.getText(),operatorLabel.getText(),memberField.getText(),
        		            accountField.getText(),entryList,sumLabel.getText(),BillType.XJFYD,BillState.COMMITED);
         service.commit(vo);
	}

	@FXML
	public void fresh(){
		 accountField.setText(null);
         memberField.setText(null);
         itemField.setText(null);
         moneyField.setText(null);
         descriptionArea.setText(null);
	}

	@FXML
	public void checkBefore() throws Exception{
          //  new PaymentCheckBillUI().start();
	}

	public void initData(UserVO user,PaymentBillVO bill) throws Exception {
		   this.user = user;

			if(bill == null){
				    idLabel.setText(service.);
			    sumLabel.setText("0");
				operatorLabel.setText(user.getName());
				}
				else{
					idLabel.setText(bill.getId());
					sumLabel.setText(bill.getTotal());
					list.addAll(bill.getEntryListVO());
					table.setItems(list);
					operatorLabel.setText(bill.getUserID());

				}
				fresh();
				edit();
				manageInit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void edit(){
		Callback<TableColumn<EntryVO, String>,
            TableCell<EntryVO, String>> cellFactory
                = (TableColumn<EntryVO, String> p) -> new EditingCell<EntryVO>();

        tableItem.setCellFactory(cellFactory);
        tableItem.setOnEditCommit(
            (CellEditEvent<EntryVO, String> t) -> {
            	String tmp = t.getOldValue();
               ((EntryVO) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEntryName(t.getNewValue());
               EntryVO newVO = ((EntryVO) t.getTableView().getItems().get(
                        t.getTablePosition().getRow()));
               if(update(newVO)){
                   ((EntryVO)t.getTableView().getItems().get(
  	                        t.getTablePosition().getRow())
  	                        ).setEntryName(tmp);
               }

        });

        tableMoney.setCellFactory(cellFactory);
        tableMoney.setOnEditCommit(
            (CellEditEvent<EntryVO, String> t) -> {
            	String tmp = t.getOldValue();
	               ((EntryVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setTransferAmount(t.getNewValue());
	               EntryVO newVO = ((EntryVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow()));
	               if(!update(newVO))
	                	  (t.getTableView().getItems().get(
	  	                        t.getTablePosition().getRow())
	  	                        ).setTransferAmount(tmp);
	               else{
	            	   String newTmp = newVO.getTransferAmount();
	            	   int result = Integer.parseInt(sumLabel.getText())-Integer.parseInt(tmp)+Integer.parseInt(newTmp);
	            	   sumLabel.setText(String.valueOf(result));
	               }
        });

        tableDescription.setCellFactory(cellFactory);
        tableDescription.setOnEditCommit(
            (CellEditEvent<EntryVO, String> t) -> {
            	String tmp = t.getOldValue();
	               ((EntryVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNote(t.getNewValue());
	               EntryVO newVO = ((EntryVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow()));
	               if(!update(newVO))
	                	  (t.getTableView().getItems().get(
	  	                        t.getTablePosition().getRow())
	  	                        ).setNote(tmp);
        });
	}

	public boolean update(EntryVO vo){
		 ResultMessage message = service.judgeLegal(vo.getTransferAmount());
		 Boolean result = message == ResultMessage.SUCCESS?true:false;
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        case SUCCESS:break;
	    	        default:break;
	    	        }
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
	     return result;
	}

	public void manageInit(){
		tableItem.setCellValueFactory(
                new PropertyValueFactory<EntryVO,String>("entryName"));
        tableMoney.setCellValueFactory(
                new PropertyValueFactory<EntryVO,String>("transferAmount"));
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
                            int tmp = Integer.parseInt(clickedItem.getTransferAmount());
                            int result = Integer.parseInt(sumLabel.getText())-tmp;
                            sumLabel.setText(String.valueOf(result));
                        });
                    }
                }

            };
            return cell;
        });
	}



}
