package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogic.examinebl.ExamineInventoryBL;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.Remind;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindInventoryBillType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCellInteger;
import presentation.remindui.RemindPrintUI;
import vo.accountvo.AccountVO;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;
import vo.uservo.UserVO;

public class ExamineInventoryBillController extends ExamineBillController{

	    ExamineBLService<InventoryBillVO> service = new ExamineInventoryBL();
	    ObservableList<InventoryBillVO> list = FXCollections.observableArrayList();
	    ObservableList<GiftVO> giftList = FXCollections.observableArrayList();
		public static final Remind remind = Remind.BILL;
		InventoryBillVO inv;

		@FXML
		ChoiceBox<String> findChoice;
		@FXML
		TextField findingField;

		@FXML
		TableView<InventoryBillVO> table;
		@FXML
		TableColumn<InventoryBillVO,String> tableID;
		@FXML
		TableColumn<InventoryBillVO,String> tableType;
		@FXML
		TableColumn<InventoryBillVO,String> tableOperator;
		@FXML
		TableColumn<InventoryBillVO,String> tableNote;
		@FXML
		TableColumn<InventoryBillVO,String> tableCheck;
		@FXML
		TableColumn<InventoryBillVO,CheckBox> tablePass;

		@FXML
		TableView<GiftVO> giftTable;
		@FXML
		TableColumn<GiftVO,String> tableName;
		TableColumn<GiftVO,Integer> tableNumber;

		@FXML
		public void find() throws RemoteException{
			ArrayList<InventoryBillVO> list = service.find(findingField.getText(),FindBillType.getType(findChoice.getValue()));
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

		@FXML
		public void fresh() throws RemoteException{
			list.addAll(service.getCommitedBills());
			table.setItems(list);
		}

		@FXML
		public void success() throws RemoteException{
            ArrayList<InventoryBillVO> choiceList = new ArrayList<>();
            for(int i=0;i<list.size();i++)
            	if(list.get(i).getBox().isSelected()){
            		choiceList.add(list.get(i));
            		list.remove(i);
            		}
            service.passBills(choiceList);
		}

		@FXML
		public void fail() throws RemoteException{
			ArrayList<InventoryBillVO> choiceList = new ArrayList<>();
            for(int i=0;i<list.size();i++)
            	if(list.get(i).getBox().isSelected()){
            		choiceList.add(list.get(i));
            		list.remove(i);
            		}
            service.notPassBills(choiceList);
		}

		public void initData(UserVO user,BillType type) throws RemoteException{
			this.user = user;
			this.billType = type;
			choiceInit();
			edit();
			manageInit();
			fresh();
		}

		public void choiceInit(){
			findChoice.setItems(FXCollections.observableArrayList(FindInventoryBillType.ID.value,FindInventoryBillType.NAME.value,
					FindInventoryBillType.TYPE.value));
		}


		public void manageInit(){
			tableID.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,String>("id"));
			tableType.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,String>("typeString"));
			tableOperator.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,String>("operator"));
            tablePass.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,CheckBox>("box"));
			tableNote.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,String>("note"));
			tableName.setCellValueFactory(
	                new PropertyValueFactory<GiftVO,String>("name"));
			tableNumber.setCellValueFactory(
	                new PropertyValueFactory<GiftVO,Integer>("number"));
			checkInit();
		}

		public void edit(){
		    Callback<TableColumn<GiftVO, Integer>,
			    TableCell<GiftVO, Integer>> cellFactoryInteger
			        = (TableColumn<GiftVO, Integer> p) -> new EditingCellInteger<GiftVO>();

		    tableNumber.setCellFactory(cellFactoryInteger);
		    tableNumber.setOnEditCommit(
		            (CellEditEvent<GiftVO, Integer> t) -> {
		                ((GiftVO) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setNumber(t.getNewValue());
                      giftList.set(t.getTablePosition().getRow(),  ((GiftVO) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ));
                      ArrayList<GiftVO> tmpGifts = new ArrayList<>();
                      tmpGifts.addAll(giftList);
                      inv.setGifts(tmpGifts);
                      try {
						service.updateBill(inv);
					} catch (RemoteException e) {
						e.printStackTrace();
					}

		        });

		}


		public void checkInit(){

			tableCheck.setCellFactory((col) -> {
	            TableCell<InventoryBillVO, String> cell = new TableCell<InventoryBillVO, String>() {

	                @Override
	                public void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    this.setText(null);
	                    this.setGraphic(null);

	                    if (!empty) {
	                        Button delBtn = new Button("查看商品列表");
	                        this.setGraphic(delBtn);
	                        delBtn.setOnMouseClicked((me) -> {
	                        	InventoryBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
	                            giftList.clear();
	                            giftList.addAll(clickedItem.getGifts());
	                            giftTable.setItems(giftList);
                                inv = clickedItem;
	                        });
	                    }
	                }

	            };
	            return cell;
	        });

		}

}
