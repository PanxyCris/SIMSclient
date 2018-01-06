package presentation.inventorymanagerui.controller;

import java.util.ArrayList;
import java.util.Optional;

import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;
import vo.uservo.UserVO;

public class CheckReceiptController extends InventoryManagerController{

    InventoryBillBLService service = new InventoryBillController();
    ObservableList<InventoryBillVO> list = FXCollections.observableArrayList();
    ObservableList<GiftVO> giftList = FXCollections.observableArrayList();

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
	@FXML
	TableColumn<GiftVO,Integer> tableNumber;

	@FXML
	public void makeInventoryReceipt() throws Exception{
		changeStage("MakeReceiptUI",user,type,inv);
	}

	@FXML
	public void find(){
		if(findingField.getText()==null||findChoice.getValue()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"����д�ò�ѯ��Ϣ");
			warning.showAndWait();
		}
		else{
		ArrayList<InventoryBillVO> list = service.find(findingField.getText(),FindInventoryBillType.getType(findChoice.getValue()));
	       if(list==null){
	    	   Alert error = new Alert(Alert.AlertType.WARNING,ResultMessage.NOTFOUND.value);
               error.showAndWait();
	       }
	       else{
	    	   table.getItems().clear();
	    	   table.getItems().addAll(list);
	       }
        }
	}

	public void initData(UserVO user,BillType type){
		this.user = user;
		this.type = type;
		choiceInit();
		manageInit();
		list.addAll(service.show());
		table.setItems(list);
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
                        Button delBtn = new Button("�鿴��Ʒ�б�");
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
                    if (!empty&&this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT) {
                        Button delBtn = new Button("�ύ");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	InventoryBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                        	clickedItem.setState(BillState.COMMITED);
                        	 ResultMessage message = service.submit(clickedItem);
                             if(message == ResultMessage.SUCCESS){
                            	 this.getTableView().getItems().get(this.getIndex()).setState(BillState.COMMITED);
                            	 submitInit();
                                 deleteInit();
                                 redoInit();
                             }
                             else
                          	   printWrong(message);
                        });
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
                    if (!empty&&(this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT||
                    		this.getTableView().getItems().get(this.getIndex()).getState() == BillState.FAIL)) {
                        Button delBtn = new Button("����");
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
                    if (!empty&&(this.getTableView().getItems().get(this.getIndex()).getState() == BillState.DRAFT||
                    		this.getTableView().getItems().get(this.getIndex()).getState() == BillState.FAIL)) {
                        Button delBtn = new Button("ɾ��");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	InventoryBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                        	Alert alert = new Alert(AlertType.CONFIRMATION);
                        	alert.setContentText("ȷ��ɾ����");
                        	Optional<ButtonType> result = alert.showAndWait();
                        	if (result.get() == ButtonType.OK){
                        		service.delete(clickedItem);
                        		  list.remove(clickedItem);
  	                              table.setItems(list);
                        	}
                        });
                    }
              }
            };
            return cell;
        });
	}

}
