package presentation.financialstaffui.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import bussinesslogic.tablebl.SaleScheduleBL;
import bussinesslogicservice.checktableblservice.SaleScheduleBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.tablevo.SaleScheduleVO;
import vo.uservo.UserVO;

public class SaleDetailTableController extends ViewTableController{

	SaleScheduleBLService service = new SaleScheduleBL();
	ObservableList<SaleScheduleVO> list = FXCollections.observableArrayList();

	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	ChoiceBox<String> siftChoice;
	@FXML
	TextField siftField;


	@FXML
	TableView<SaleScheduleVO> table;
	@FXML
	TableColumn<SaleScheduleVO,LocalDate> tableTime;
	@FXML
	TableColumn<SaleScheduleVO,String> tableName;
	@FXML
	TableColumn<SaleScheduleVO,String> tableModel;
	@FXML
	TableColumn<SaleScheduleVO,Integer> tableNumber;
	@FXML
	TableColumn<SaleScheduleVO,Double> tablePrice;
	@FXML
	TableColumn<SaleScheduleVO,Double> tableSum;


	@FXML
	public void printout() throws Exception{
         service.exportReport();
	}

	@FXML
	public void sift(){

		ArrayList<SaleScheduleVO> list = service.sift(siftField.getText(),FindSaleScheduleType.getType(siftChoice.getValue()));
	       if(list==null){
	    	   Alert error = new Alert(Alert.AlertType.WARNING,ResultMessage.NOTFOUND.value);
               error.showAndWait();
	       }
	       else{
	    	   table.getItems().clear();
	    	   table.getItems().addAll(list);
	       }

	}

	@FXML
	public void siftTime(){

		ArrayList<SaleScheduleVO> list = service.siftTime(startPicker.getValue(),endPicker.getValue());
	       if(list==null){
	    	   Alert error = new Alert(Alert.AlertType.WARNING,ResultMessage.NOTFOUND.value);
               error.showAndWait();
	       }
	       else{
	    	   table.getItems().clear();
	    	   table.getItems().addAll(list);
	       }

	}



	public void initData(UserVO user) {
		this.user = user;
		list.addAll(service.show());
		table.setItems(list);
		manageInit();
		siftChoice.setItems(FXCollections.observableArrayList(FindSaleScheduleType.NAME.value,FindSaleScheduleType.MEMBER.value,
				FindSaleScheduleType.OPERATOR.value,FindSaleScheduleType.WAREHOUSE.value));
	}

	public void manageInit(){
		tableTime.setCellValueFactory(
                new PropertyValueFactory<SaleScheduleVO,LocalDate>("date"));
		tableName.setCellValueFactory(
                new PropertyValueFactory<SaleScheduleVO,String>("name"));
		tableNumber.setCellValueFactory(
                new PropertyValueFactory<SaleScheduleVO,Integer>("number"));
		tablePrice.setCellValueFactory(
                new PropertyValueFactory<SaleScheduleVO,Double>("price"));
		tableSum.setCellValueFactory(
                new PropertyValueFactory<SaleScheduleVO,Double>("sum"));
		tableModel.setCellValueFactory(
                new PropertyValueFactory<SaleScheduleVO,String>("model"));
	}


}
