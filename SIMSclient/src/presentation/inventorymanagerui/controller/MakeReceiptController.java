package presentation.inventorymanagerui.controller;

import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogic.commoditybl.CommodityController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import bussinesslogicservice.commodityblservice.CommodityBLService;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.remindui.RemindPrintUI;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.uservo.UserVO;

public class MakeReceiptController extends InventoryManagerController{

    InventoryBillBLService service = new InventoryBillController();
    ObservableList<InventoryBillVO> list = FXCollections.observableArrayList();
	public static final Remind remind = Remind.BILL;
	@FXML
	ChoiceBox<String> receiptChoice;
	@FXML
	Label idLabel;
	@FXML
	ChoiceBox<String> nameChoice;
	@FXML
	TextField numberField;
	@FXML
	TextArea noteArea;

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
	TableColumn<InventoryBillVO,String> tableName;
	@FXML
	TableColumn<InventoryBillVO,Integer> tableNumber;
	@FXML
	TableColumn<InventoryBillVO,String> tableNote;
	@FXML
	TableColumn<InventoryBillVO,String> tableState;
	@FXML
	TableColumn<InventoryBillVO,String> tableSubmit;
	@FXML
	TableColumn<InventoryBillVO,String> tableRedo;
	@FXML
	TableColumn<InventoryBillVO,String> tableDelete;

	@FXML
	public void save(){
       InventoryBillVO vo = new InventoryBillVO(idLabel.getText(),nameChoice.getValue(),Integer.parseInt(numberField.getText()),
    		   BillType.getType(receiptChoice.getValue()),BillState.DRAFT,noteArea.getText());
       service.save(vo);
	}

	@FXML
	public void submit(){
		InventoryBillVO vo = new InventoryBillVO(idLabel.getText(),nameChoice.getValue(),Integer.parseInt(numberField.getText()),
	    		   BillType.getType(receiptChoice.getValue()),BillState.COMMITED,noteArea.getText());
	       service.submit(vo);
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
		idLabel.setText(service.getId());
		numberField.setText(null);
		receiptChoice.setValue(null);
		nameChoice.setValue(null);
		noteArea.setText(null);
	}

	public void initData(UserVO user){
		this.user = user;
		choiceInit();
		manageInit();
		fresh();
	}

	public void choiceInit(){
		receiptChoice.setItems(FXCollections.observableArrayList(BillType.INVENTORYGIFTBILL.value,BillType.INVENTORYLOSSBILL.value,
				BillType.INVENTORYREVENUEBILL.value,BillType.INVENTORYWARNINGBILL.value));
		findChoice.setItems(FXCollections.observableArrayList(FindInventoryBillType.ID.value,FindInventoryBillType.NAME.value,
				FindInventoryBillType.STATE.value,FindInventoryBillType.TYPE.value));
		CommodityBLService commodityService = new CommodityController();
		nameChoice.setItems(FXCollections.observableArrayList(commodityService.getIDandName()));
	}


	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<InventoryBillVO,String>("id"));
		tableName.setCellValueFactory(
                new PropertyValueFactory<InventoryBillVO,String>("name"));
		tableType.setCellValueFactory(
                new PropertyValueFactory<InventoryBillVO,String>("typeString"));
		tableNumber.setCellValueFactory(
                new PropertyValueFactory<InventoryBillVO,Integer>("number"));
		tableNote.setCellValueFactory(
                new PropertyValueFactory<InventoryBillVO,String>("note"));
		tableState.setCellValueFactory(
                new PropertyValueFactory<InventoryBillVO,String>("stateString"));
		submitInit();
		redoInit();
        deleteInit();
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
                            service.submit(clickedItem);
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
								idLabel.setText(clickedItem.getId());
								receiptChoice.setValue(clickedItem.getTypeString());
								nameChoice.setValue(clickedItem.getName());
								numberField.setText(String.valueOf(clickedItem.getNumber()));
								noteArea.setText(clickedItem.getNote());

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
