package presentation.generalmanagerui.controller;

import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.Remind;
import dataenum.ResultMessage;
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
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.remindui.RemindPrintUI;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;
import vo.uservo.UserVO;

public class ExamineInventoryBillController extends ExamineBillController{

	    ExamineBLService<InventoryBillVO> service = new ExamineBillController();
	    ObservableList<InventoryBillVO> list = FXCollections.observableArrayList();
	    ObservableList<GiftVO> giftList = FXCollections.observableArrayList();
		public static final Remind remind = Remind.BILL;

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
		TableColumn<InventoryBillVO,String> tableNote;
		@FXML
		TableColumn<InventoryBillVO,String> tableCheck;
		@FXML
		TableColumn<InventoryBillVO,Boolean> tablePass;

		@FXML
		TableView<GiftVO> giftTable;
		@FXML
		TableColumn<GiftVO,String> tableName;
		TableColumn<GiftVO,Integer> tableNumber;

		@FXML
		public void find(){
			ArrayList<InventoryBillVO> list = service.find(findingField.getText(),FindInventoryBillType.getType(findChoice.getValue()));
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
		public void fresh(){
			list.addAll(service.show());
			table.setItems(list);
		}

		@FXML
		public void success(){
            ArrayList<InventoryBillVO>
		}

		@FXML
		public void fail(){

		}

		public void initData(UserVO user,BillType type){
			this.user = user;
			this.bill = type;
			choiceInit();
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

			tableNote.setCellValueFactory(
	                new PropertyValueFactory<InventoryBillVO,String>("note"));
			tableName.setCellValueFactory(
	                new PropertyValueFactory<GiftVO,String>("name"));
			tableNumber.setCellValueFactory(
	                new PropertyValueFactory<GiftVO,Integer>("number"));
			checkInit();
			passInit();
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

	                        });
	                    }
	                }

	            };
	            return cell;
	        });

		}

		public void passInit(){

			tablePass.setCellFactory((col) -> {
	            TableCell<InventoryBillVO, Boolean> cell = new TableCell<InventoryBillVO, Boolean>() {
	            	  @Override
	                  public void updateItem(Boolean item, boolean empty) {
	                      super.updateItem(item, empty);
	                      this.setText(null);
	                      this.setGraphic(null);
	                      if (!empty) {
	                          CheckBox checkBox = new CheckBox();
	                          this.setGraphic(checkBox);
	                      }
	                  }

	              };
	              return cell;
	          });

		}



}
