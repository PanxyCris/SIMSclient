package presentation.inventorymanagerui.controller;

import bussinesslogic.commoditybl.CommodityController;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.commodityvo.CommodityStockVO;
import vo.uservo.UserVO;

public class InventoryStockController extends InventoryManagerController{

	CommodityBLService service = new CommodityController();
    ObservableList<CommodityStockVO> list = FXCollections.observableArrayList();

	@FXML
	protected TableView<CommodityStockVO> table;
	@FXML
	protected TableColumn<CommodityStockVO,Integer> tableLine;
	@FXML
	protected TableColumn<CommodityStockVO,String> tableID;
	@FXML
	protected TableColumn<CommodityStockVO,String> tableName;
	@FXML
	protected TableColumn<CommodityStockVO,String> tableModel;

	@FXML
	protected TableColumn<CommodityStockVO,Integer> tableNumber;
	@FXML
	protected TableColumn<CommodityStockVO,Double> tablePurPrice;
	@FXML
	protected TableColumn<CommodityStockVO,Double> tableRetailedPrice;

    @FXML
    public void stock() throws Exception{
    	service.stock();
    }



	@FXML
	public void fresh() throws Exception{
		list.clear();
		list.addAll(service.stock());
		table.setItems(list);
	}


	public void initData(UserVO user) throws Exception {
		this.user = user;
	    fresh();
		manageInit();
	}

	public void manageInit(){
		tableLine.setCellValueFactory(
	                new PropertyValueFactory<CommodityStockVO,Integer>("line"));
		tableID.setCellValueFactory(
                new PropertyValueFactory<CommodityStockVO,String>("id"));
        tableName.setCellValueFactory(
                new PropertyValueFactory<CommodityStockVO,String>("name"));
        tableModel.setCellValueFactory(
                new PropertyValueFactory<CommodityStockVO,String>("model"));
        tableNumber.setCellValueFactory(
                new PropertyValueFactory<CommodityStockVO,Integer>("number"));
        tablePurPrice.setCellValueFactory(
                new PropertyValueFactory<CommodityStockVO,Double>("avgRetailedPrice"));
        tableRetailedPrice.setCellValueFactory(
                new PropertyValueFactory<CommodityStockVO,Double>("avgPurPrice"));
	}

}
