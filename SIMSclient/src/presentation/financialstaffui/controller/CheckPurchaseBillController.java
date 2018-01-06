package presentation.financialstaffui.controller;

import java.rmi.RemoteException;

import java.util.ArrayList;

import bussinesslogic.tablebl.BussinessHistorySchedulePurchaseBL;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.financialstaffui.controller.BussinessProcessTableController;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;
import vo.uservo.UserVO;

public class CheckPurchaseBillController extends BussinessProcessTableController{

	BusinessHistoryScheduleBLService<PurchaseVO> service = new BussinessHistorySchedulePurchaseBL();
	ObservableList<PurchaseVO> list = FXCollections.observableArrayList();
	ObservableList<CommodityItemVO> commodityList = FXCollections.observableArrayList();
    PurchaseVO bill;

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;


	@FXML
	TableView<PurchaseVO> table;
	@FXML
	TableColumn<PurchaseVO,String> tableID;
	@FXML
	TableColumn<PurchaseVO,String> tableType;
	@FXML
	TableColumn<PurchaseVO,String> tableMember;
	@FXML
	TableColumn<PurchaseVO,String> tableWarehouse;
	@FXML
	TableColumn<PurchaseVO,Double> tableSum;
	@FXML
	TableColumn<PurchaseVO,String> tableOperator;
	@FXML
	TableColumn<PurchaseVO,String> tableNote;
	@FXML
	TableColumn<PurchaseVO,String> tableList;
	@FXML
	TableColumn<PurchaseVO,CheckBox> tableRed;

	@FXML
	TableView<CommodityItemVO> commodity;
	@FXML
	TableColumn<CommodityItemVO,String> commodityID;
	@FXML
	TableColumn<CommodityItemVO,String> commodityName;
	@FXML
	TableColumn<CommodityItemVO,String> commodityModel;
	@FXML
	TableColumn<CommodityItemVO,Integer> commodityNumber;
	@FXML
	TableColumn<CommodityItemVO,Double> commodityPrice;
	@FXML
	TableColumn<CommodityItemVO,Double> commodityMoney;
	@FXML
	TableColumn<CommodityItemVO,String> commodityNote;

	@FXML
	public void red(){
		ArrayList<PurchaseVO> result = new ArrayList<>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getRed().isSelected())
				result.add(list.get(i));
		list.addAll(service.writeOff(result));
	}

	@FXML
	public void redCopy(){
		ArrayList<PurchaseVO> result = new ArrayList<>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<PurchaseVO> copy = service.writeOffAndCopy(result);
        list.clear();
		list.addAll(copy);
		table.setItems(list);
		table.setEditable(true);
		commodityList.clear();
		commodity.setItems(commodityList);
		commodity.setEditable(true);
	}


	@FXML
	public void printout(){
		ArrayList<PurchaseVO> result = new ArrayList<>();
		result.addAll(list);
		service.exportReport(result);
	}

	@FXML
	public void siftTime(){
		if(startPicker.getValue()==null||endPicker.getValue()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"����д�ò�ѯ��Ϣ");
			warning.showAndWait();
		}else{
		list.clear();
		ArrayList<PurchaseVO> siftList = service.siftTime(startPicker.getValue(), endPicker.getValue());
		list.addAll(siftList);
		table.setItems(list);
		}
	}

	@FXML
	public void find(){
		if(findingField.getText()==null||findChoice.getValue()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"����д�ò�ѯ��Ϣ");
			warning.showAndWait();
		}else{
		ArrayList<PurchaseVO> list = service.sift(findingField.getText(),FindSaleScheduleType.getType(findChoice.getValue()));
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

	public void initData(UserVO user) throws RemoteException {
		this.user = user;
	    list.addAll(service.show());
		table.setItems(list);
		manageInit();
		listInit();
		findChoice.setItems(FXCollections.observableArrayList(FindSaleScheduleType.NAME.value,FindSaleScheduleType.MEMBER.value,
				FindSaleScheduleType.OPERATOR.value,FindSaleScheduleType.WAREHOUSE.value));
	}

	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("id"));
		tableType.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("typeString"));
		tableMember.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("supplier"));
		tableWarehouse.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("warehouseString"));
		tableSum.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,Double>("sum"));
		tableOperator.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("operator"));
		tableNote.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("note"));
		tableRed.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,CheckBox>("red"));
		checkInit();
	}

	public void checkInit(){

		tableList.setCellFactory((col) -> {
            TableCell<PurchaseVO, String> cell = new TableCell<PurchaseVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("�鿴��Ʒ�б�");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PurchaseVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            commodityList.clear();
                            commodityList.addAll(clickedItem.getCommodities());
                            commodity.setItems(commodityList);
                            bill = clickedItem;

                        });
                    }
                }

            };
            return cell;
        });

	}


	public void listInit(){
		commodityID.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("id"));
		commodityName.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("name"));
		commodityModel.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("model"));
		commodityNumber.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,Integer>("number"));
		commodityPrice.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,Double>("price"));
		commodityMoney.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,Double>("total"));
		commodityNote.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("remark"));
	}
}
