package presentation.inventorymanagerui.controller;

import java.util.ArrayList;
import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Remind;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

public class CheckReceiptController extends InventoryManagerController{

    InventoryBillBLService service = new InventoryBillController();
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
	TableColumn<InventoryBillVO,String> tableOperator;
	@FXML
	TableColumn<InventoryBillVO,String> tableNote;
	@FXML
	TableColumn<InventoryBillVO,String> tableState;
	@FXML
	TableColumn<InventoryBillVO,String> tableCheck;
	@FXML
	TableColumn<InventoryBillVO,String> tableSubmit;
	@FXML
	TableColumn<InventoryBillVO,String> tableRedo;
	@FXML
	TableColumn<InventoryBillVO,String> tableDelete;

	@FXML
	TableView<GiftVO> giftTable;
	@FXML
	TableColumn<GiftVO,String> tableName;
	TableColumn<GiftVO,Integer> tableNumber;

	@FXML
	public void makeInventoryReceipt() throws Exception{
		changeStage("MakeReceiptUI",user,type,inv);
	}

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

	public void initData(UserVO user,BillType type){
		this.user = user;
		this.type = type;
		choiceInit();
		manageInit();
		fresh();
	}

	public void choiceInit(){
		findChoice.setItems(FXCollections.observableArrayList(FindInventoryBillType.ID.value,FindInventoryBillType.NAME.value,
				FindInventoryBillType.STATE.value,FindInventoryBillType.TYPE.value));
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
		tableState.setCellValueFactory(
                new PropertyValueFactory<InventoryBillVO,String>("stateString"));
		tableName.setCellValueFactory(
                new PropertyValueFactory<GiftVO,String>("name"));
		tableNumber.setCellValueFactory(
                new PropertyValueFactory<GiftVO,Integer>("number"));
		checkInit();
		submitInit();
		redoInit();
        deleteInit();
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

	public void submitInit(){

		tableSubmit.setCellFactory((col) -> {
            TableCell<InventoryBillVO, String> cell = new TableCell<InventoryBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
              for(int i=0;i< this.getTableView().getItems().size();i++){
                   BillState clickedState = this.getTableView().getItems().get(i).getState();
                    if (!empty&&clickedState == BillState.DRAFT) {
                        Button delBtn = new Button("提交");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	InventoryBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                        	 ResultMessage message = service.submit(clickedItem);
                             if(message == ResultMessage.SUCCESS){
                            	 this.getTableView().getItems().get(this.getIndex()).setState(BillState.COMMITED);
                                 print(ResultMessage.COMMITED);
                             }
                             else
                          	   print(message);
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
            TableCell<InventoryBillVO, String> cell = new TableCell<InventoryBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    for(int i=0;i< this.getTableView().getItems().size();i++){
                   BillState clickedState = this.getTableView().getItems().get(i).getState();
                    if (!empty&&(clickedState == BillState.DRAFT||clickedState == BillState.FAIL)) {
                        Button delBtn = new Button("重做");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	InventoryBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            try {
								changeStage("ReceiveMakeBillUI",user,type,clickedItem);
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
            TableCell<InventoryBillVO, String> cell = new TableCell<InventoryBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    for(int i=0;i< this.getTableView().getItems().size();i++){
                    BillState clickedState = this.getTableView().getItems().get(i).getState();
                    if (!empty&&(clickedState == BillState.DRAFT||clickedState == BillState.FAIL)) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	InventoryBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
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

}
