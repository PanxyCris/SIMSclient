package presentation.inventorymanagerui.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import bussinesslogic.commoditybl.CommodityController;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.commodityvo.CommodityCheckVO;
import vo.uservo.UserVO;

public class InventoryCheckController extends InventoryManagerController{

	CommodityBLService service = new CommodityController();
	ObservableList<CommodityCheckVO> list = FXCollections.observableArrayList();
	@FXML
	DatePicker startPicker;
	@FXML
	TextField startHour;
	@FXML
	TextField startMinute;
	@FXML
	DatePicker endPicker;
	@FXML
	TextField endHour;
	@FXML
	TextField endMinute;

	@FXML
	TableView<CommodityCheckVO> table;
	@FXML
	TableColumn<CommodityCheckVO,LocalDate> tableDate;
	@FXML
	TableColumn<CommodityCheckVO,LocalTime> tableTime;
	@FXML
	TableColumn<CommodityCheckVO,String> tableType;
	@FXML
	TableColumn<CommodityCheckVO,String> tableName;
	@FXML
	TableColumn<CommodityCheckVO,Integer> tableNumber;
	@FXML
	TableColumn<CommodityCheckVO,Double> tableMoney;

	@FXML
	Label sumLabel;

	@FXML
	public void confirm(){
		LocalTime startTime = LocalTime.of(Integer.parseInt(startHour.getText()), Integer.parseInt(startMinute.getText()));
		LocalDateTime start = LocalDateTime.of(startPicker.getValue(),startTime);
		LocalTime endTime = LocalTime.of(Integer.parseInt(endHour.getText()), Integer.parseInt(endMinute.getText()));
		LocalDateTime end = LocalDateTime.of(endPicker.getValue(),endTime);
         ArrayList<CommodityCheckVO> commodityList = service.check(start, end);
         list.addAll(commodityList);
         table.setItems(list);
    }

	public void initData(UserVO user) {
		this.user = user;
		manageInit();
		startHour.setText("00");
		startMinute.setText("00");
		endHour.setText("00");
		endMinute.setText("00");
	}

	public void manageInit(){
		tableDate.setCellValueFactory(
                new PropertyValueFactory<CommodityCheckVO,LocalDate>("date"));
		tableTime.setCellValueFactory(
                new PropertyValueFactory<CommodityCheckVO,LocalTime>("time"));
	    tableType.setCellValueFactory(
                new PropertyValueFactory<CommodityCheckVO,String>("typeString"));
        tableName.setCellValueFactory(
                new PropertyValueFactory<CommodityCheckVO,String>("name"));
        tableNumber.setCellValueFactory(
                new PropertyValueFactory<CommodityCheckVO,Integer>("number"));
        tableMoney.setCellValueFactory(
                new PropertyValueFactory<CommodityCheckVO,Double>("money"));

	}


}
