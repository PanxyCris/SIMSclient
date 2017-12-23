package presentation.inventorymanagerui.controller;

import bussinesslogic.commoditybl.CommodityBL;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.commodityvo.CommodityVO;
import vo.uservo.UserVO;

public class InventoryStockController extends InventoryManagerController{

	CommodityBLService service = new CommodityBL();
    ObservableList<CommodityVO> list = FXCollections.observableArrayList();

	@FXML
	protected TableView<CommodityVO> table;
	@FXML
	protected TableColumn<CommodityVO,Integer> tableLine;
	@FXML
	protected TableColumn<CommodityVO,String> tableID;
	@FXML
	protected TableColumn<CommodityVO,String> tableName;
	@FXML
	protected TableColumn<CommodityVO,String> tableModel;
	@FXML
	protected TableColumn<CommodityVO,String> tableClass;

	@FXML
	protected TableColumn<CommodityVO,Integer> tableNumber;
	@FXML
	protected TableColumn<CommodityVO,Double> tablePurPrice;
	@FXML
	protected TableColumn<CommodityVO,Double> tableRetailedPrice;
	@FXML
	protected TableColumn<CommodityVO,Integer> tableWarmingValue;
	@FXML
	protected TableColumn<CommodityVO,Double> tableRecPurPrice;
	@FXML
	protected TableColumn<CommodityVO,Double> tableRecRetailedPrice;

    @FXML
    public void stock() throws Exception{
    	service.stock();
    }



	@FXML
	public void fresh() throws Exception{
		list.clear();
		list.addAll(service.show());
		table.setItems(list);
	}


	public void initData(UserVO user) throws Exception {
		this.user = user;
	    fresh();
		manageInit();
	}

	public void manageInit(){
		tableLine.setCellValueFactory(
	                new PropertyValueFactory<CommodityVO,Integer>("line"));
		tableID.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,String>("ID"));
        tableName.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,String>("name"));
        tableModel.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,String>("model"));
        tableClass.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,String>("classficationString"));
        tableNumber.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,Integer>("number"));
        tableWarmingValue.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,Integer>("warmingValue"));
        tablePurPrice.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,Double>("purPrice"));
        tableRetailedPrice.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,Double>("retailedPrice"));
        tableRecPurPrice.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,Double>("recentPurPrice"));
        tableRecRetailedPrice.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,Double>("recentRetailedPrice"));


	}

}
