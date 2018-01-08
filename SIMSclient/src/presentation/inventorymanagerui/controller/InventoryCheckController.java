package presentation.inventorymanagerui.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import bussinesslogic.commoditybl.CommodityBL;
import bussinesslogic.commoditybl.CommodityController;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import po.ClassificationVPO;
import vo.commodityvo.CommodityCheckVO;
import vo.uservo.UserVO;

public class InventoryCheckController extends InventoryManagerController{

	CommodityBLService service = new CommodityController();
	ObservableList<CommodityCheckVO> list = FXCollections.observableArrayList();
	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	TableView<CommodityCheckVO> table;
	@FXML
	TableColumn<CommodityCheckVO,LocalDate> tableDate;
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
		LocalDate start = startPicker.getValue();
		LocalDate end = endPicker.getValue();
         ArrayList<CommodityCheckVO> commodityList = service.check(start, end);
         list.clear();
         list.addAll(commodityList);
         table.setItems(list);
         int sum = 0;
         for(CommodityCheckVO commodity:commodityList){
        	 sum += commodity.getNumber();
         }
         sumLabel.setText(String.valueOf(sum));
    }

	public void initData(UserVO user) {
		this.user = user;
		manageInit();
	}

	public void manageInit(){
		tableDate.setCellValueFactory(
                new PropertyValueFactory<CommodityCheckVO,LocalDate>("date"));
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
