package presentation.financialstaffui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.tablebl.BusinessHistoryScheduleSalesBL;
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
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.uservo.UserVO;

public class CheckSalesBillController extends BussinessProcessTableController{

	BusinessHistoryScheduleBLService<SalesVO> service = new BusinessHistoryScheduleSalesBL();
	ObservableList<SalesVO> list = FXCollections.observableArrayList();
	ObservableList<CommodityItemVO> commodityList = FXCollections.observableArrayList();

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	TableView<SalesVO> table;
	@FXML
	TableColumn<SalesVO,String> tableID;
	@FXML
	TableColumn<SalesVO,String> tableType;
	@FXML
	TableColumn<SalesVO,String> tableMember;
	@FXML
	TableColumn<SalesVO,String> tableSaleMan;
	@FXML
	TableColumn<SalesVO,String> tableWarehouse;
	@FXML
	TableColumn<SalesVO,Double> tableBefore;
	@FXML
	TableColumn<SalesVO,Double> tableVoucher;
	@FXML
	TableColumn<SalesVO,Double> tableAllowance;
	@FXML
	TableColumn<SalesVO,Double> tableAfter;
	@FXML
	TableColumn<SalesVO,String> tableOperator;
	@FXML
	TableColumn<SalesVO,String> tableNote;
	@FXML
	TableColumn<SalesVO,String> tableList;
	@FXML
	TableColumn<SalesVO,CheckBox> tableRed;

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
		ArrayList<SalesVO> result = new ArrayList<>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getRed().isSelected())
				result.add(list.get(i));
		list.addAll(service.writeOff(result));
		table.setItems(list);
	}

	@FXML
	public void redCopy(){
		ArrayList<SalesVO> result = new ArrayList<>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getRed().isSelected())
				result.add(list.get(i));
		ArrayList<SalesVO> copy = service.writeOffAndCopy(result);
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
		ArrayList<SalesVO> result = new ArrayList<>();
		result.addAll(list);
		service.exportReport(result);
	}

	@FXML
	public void siftTime(){
		if(startPicker.getValue()==null||endPicker.getValue()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"������ʱ��");
			warning.showAndWait();
		}else{
		list.clear();
		ArrayList<SalesVO> siftList = service.siftTime(startPicker.getValue(), endPicker.getValue());
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
		ArrayList<SalesVO> list = service.sift(findingField.getText(),FindSaleScheduleType.getType(findChoice.getValue()));
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
		findChoice.setItems(FXCollections.observableArrayList(FindSaleScheduleType.NAME.value,
				FindSaleScheduleType.OPERATOR.value,FindSaleScheduleType.MEMBER.value,
				FindSaleScheduleType.WAREHOUSE.value));
		list.addAll(service.show());
		table.setItems(list);
		manageInit();
		listInit();
	}

	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("id"));
		tableType.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("typeString"));
		tableMember.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("retailer"));
		tableSaleMan.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("saleMan"));
		tableWarehouse.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("warehouseString"));
		tableBefore.setCellValueFactory(
                new PropertyValueFactory<SalesVO,Double>("beforePrice"));
		tableAllowance.setCellValueFactory(
                new PropertyValueFactory<SalesVO,Double>("allowance"));
		tableVoucher.setCellValueFactory(
                new PropertyValueFactory<SalesVO,Double>("voucher"));
		tableAfter.setCellValueFactory(
                new PropertyValueFactory<SalesVO,Double>("afterPrice"));
		tableOperator.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("operator"));
		tableNote.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("note"));
		tableRed.setCellValueFactory(
                new PropertyValueFactory<SalesVO,CheckBox>("red"));
		checkInit();
	}

	public void checkInit(){

		tableList.setCellFactory((col) -> {
            TableCell<SalesVO, String> cell = new TableCell<SalesVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("�鿴��Ʒ�б�");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	SalesVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            commodityList.clear();
                            commodityList.addAll(clickedItem.getCommodity());
                            commodity.setItems(commodityList);
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
