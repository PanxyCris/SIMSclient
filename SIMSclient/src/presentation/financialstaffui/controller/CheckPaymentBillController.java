package presentation.financialstaffui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogic.tablebl.BusinessHistorySchedulePaymentBL;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.generalmanagerui.controller.BussinessProcessTableController;
import presentation.remindui.RemindPrintUI;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.uservo.UserVO;

public class CheckPaymentBillController extends BussinessProcessTableController{

	BusinessHistoryScheduleBLService<PaymentBillVO> service = new BusinessHistorySchedulePaymentBL();
	ObservableList<PaymentBillVO> list = FXCollections.observableArrayList();
	ObservableList<EntryVO> entryList = FXCollections.observableArrayList();
	PaymentBillVO bill;

	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

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
	TableColumn<PaymentBillVO,CheckBox> tableRed;

	@FXML
	TableView<EntryVO> itemList;
	@FXML
	TableColumn<EntryVO,String> tableItem;
	@FXML
	TableColumn<EntryVO,Double> tableMoney;
	@FXML
	TableColumn<EntryVO,String> tableNote;

	@FXML
	public void printout(){
		ArrayList<PaymentBillVO> result = new ArrayList<>();
		result.addAll(list);
		service.exportReport(result);
	}

	@FXML
	public void siftTime(){
		list.clear();
		ArrayList<PaymentBillVO> siftList = service.siftTime(startPicker.getValue(), endPicker.getValue());
		list.addAll(siftList);
		table.setItems(list);
	}

	@FXML
	public void red(){
		ArrayList<PaymentBillVO> result = new ArrayList<>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getRed().isSelected())
				result.add(list.get(i));
		list.addAll(service.writeOff(result));

	}

	@FXML
	public void redCopy(){
		ArrayList<PaymentBillVO> result = new ArrayList<>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<PaymentBillVO> copy = service.writeOffAndCopy(result);
        list.clear();
		list.addAll(copy);
		table.setItems(list);
		table.setEditable(true);
		entryList.clear();
		itemList.setItems(entryList);
        itemList.setEditable(true);
	}


	@FXML
	public void find(){

		ArrayList<PaymentBillVO> list = service.sift(findingField.getText(),FindSaleScheduleType.getType(findChoice.getValue()));
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



	public void initData(UserVO user) throws RemoteException {
		this.user = user;
		list.addAll(service.show());
		table.setItems(list);
		manageInit();
		listInit();
		findChoice.setItems(FXCollections.observableArrayList(FindSaleScheduleType.OPERATOR.value));
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
		tableRed.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,CheckBox>("red"));
		checkInit();
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



	public void listInit(){
		tableItem.setCellValueFactory(
                new PropertyValueFactory<EntryVO,String>("entryName"));
        tableMoney.setCellValueFactory(
                new PropertyValueFactory<EntryVO,Double>("transferAmount"));
        tableNote.setCellValueFactory(
                new PropertyValueFactory<EntryVO,String>("note"));
	}


}
