package presentation.financialstaffui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogic.tablebl.BusinessHistoryScheduleInventoryBL;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.BillType;
import dataenum.Remind;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCellInteger;
import presentation.generalmanagerui.controller.BussinessProcessTableController;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;
import vo.uservo.UserVO;

public class CheckInventoryBillController extends BussinessProcessTableController{

	    BusinessHistoryScheduleBLService<InventoryBillVO> service = new BusinessHistoryScheduleInventoryBL();
	    ObservableList<InventoryBillVO> list = FXCollections.observableArrayList();
	    ObservableList<GiftVO> giftList = FXCollections.observableArrayList();
		public static final Remind remind = Remind.BILL;
		InventoryBillVO inv;

		@FXML
		DatePicker startPicker;
		@FXML
		DatePicker endPicker;

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
		TableColumn<InventoryBillVO,CheckBox> tableRed;

		@FXML
		TableView<GiftVO> giftTable;
		@FXML
		TableColumn<GiftVO,String> tableName;
		TableColumn<GiftVO,Integer> tableNumber;

		@FXML
		public void red(){
			ArrayList<InventoryBillVO> result = new ArrayList<>();
			for(int i=0;i<list.size();i++)
				if(list.get(i).getRed().isSelected())
					result.add(list.get(i));
			list.addAll(service.writeOff(result));
             table.setItems(list);
		}

		@FXML
		public void redCopy(){
			ArrayList<InventoryBillVO> result = new ArrayList<>();
			for(int i=0;i<list.size();i++)
				if(list.get(i).getRed().isSelected())
					result.add(list.get(i));
			ArrayList<InventoryBillVO> copy = service.writeOffAndCopy(result);
            list.clear();
			list.addAll(copy);
			table.setItems(list);
			table.setEditable(true);
			giftList.clear();
			giftTable.setItems(giftList);
			giftTable.setEditable(true);
            edit();
		}

		@FXML
		public void printout(){
			ArrayList<InventoryBillVO> result = new ArrayList<>();
			result.addAll(list);
			service.exportReport(result);
		}

		@FXML
		public void siftTime(){
			list.clear();
			ArrayList<InventoryBillVO> siftList = service.siftTime(startPicker.getValue(), endPicker.getValue());
			list.addAll(siftList);
			table.setItems(list);
		}

		@FXML
		public void fresh(){
			list.addAll(service.show());
			table.setItems(list);
		}

		public void initData(UserVO user){
			this.user = user;
			manageInit();
			fresh();
		}


		public void manageInit(){
			tableID.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,String>("id"));
			tableType.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,String>("typeString"));
			tableOperator.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,String>("operator"));
			tableNote.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,String>("note"));
			tableRed.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,CheckBox>("red"));
			tableName.setCellValueFactory(
	                new PropertyValueFactory<GiftVO,String>("name"));
			tableNumber.setCellValueFactory(
	                new PropertyValueFactory<GiftVO,Integer>("number"));
			checkInit();
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



}
