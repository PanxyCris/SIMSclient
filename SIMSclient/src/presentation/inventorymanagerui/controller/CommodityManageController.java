package presentation.inventorymanagerui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;

import bussinesslogic.commoditybl.CommodityBL;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import dataenum.Remind;
import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import po.ClassificationVPO;
import presentation.common.EditingCell;
import presentation.common.EditingCellChoice;
import presentation.common.EditingCellDouble;
import presentation.common.EditingCellInteger;
import vo.commodityvo.CommodityVO;
import vo.uservo.UserVO;

public class CommodityManageController extends InventoryManagerController{

	CommodityBLService service = new CommodityBL();
	public static final Remind remind = Remind.COMMODITY;
    ObservableList<CommodityVO> list = FXCollections.observableArrayList();
	ObservableList<String> classList  = FXCollections.observableArrayList();

    @FXML
    protected ChoiceBox<String> findChoice;
    @FXML
    protected TextField findingField;
    @FXML
	protected Label idLabel;
    @FXML
    protected TextField nameField;
    @FXML
    protected TextField modelField;
    @FXML
    protected ComboBox<String> classChoice;
    @FXML
    protected TextField numberField;
    @FXML
    protected TextField purPriceField;
    @FXML
    protected TextField retailedPriceField;
    @FXML
    protected TextField warmingValueField;


	@FXML
	protected TableView<CommodityVO> table;
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
	protected TableColumn<CommodityVO,String> tableDelete;


	@FXML
	public void insert() throws NumberFormatException, Exception{
		if(nameField.getText()==null||modelField.getText()==null||classChoice.getValue()==null||
				numberField.getText()==null||purPriceField.getText()==null||retailedPriceField.getText()==null||
				warmingValueField.getText()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"请填写好所有信息");
			warning.showAndWait();
		}
		else{
		CommodityVO vo = new CommodityVO(idLabel.getText(),nameField.getText(),modelField.getText(),
				  classChoice.getValue(),Integer.parseInt(numberField.getText()),Double.parseDouble(purPriceField.getText()),
				  Double.parseDouble(retailedPriceField.getText()),Integer.parseInt(warmingValueField.getText()));
	        ResultMessage message = service.insert(vo);
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case EXISTED:Alert existed = new Alert(Alert.AlertType.WARNING,"该商品已存在");
                                existed.showAndWait();break;
	    	        case SUCCESS:list.add(vo);table.setItems(list);initInsert();break;
	    	        default:Alert error = new Alert(Alert.AlertType.ERROR,message.value);
                    error.showAndWait();break;
	    	        }
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
	    }
	}


	@FXML
	public void find() throws Exception{
		if(findingField.getText()==null||findChoice.getValue()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"请填写好查询信息");
			warning.showAndWait();
		}
		else{
		ArrayList<CommodityVO> list = service.find(findingField.getText(),FindCommodityType.getType(findChoice.getValue()));
	       if(list==null){
	    	   Alert error = new Alert(Alert.AlertType.WARNING,ResultMessage.NOTFOUND.value);
               error.showAndWait();
	       }
	       else{
	    	   table.getItems().clear();
	    	   table.getItems().addAll(list);
	    	   initFind();
	       }
		}
	}

	public void initFind(){
		findingField.setText(null);
		findChoice.setValue(null);
	}

	public void initInsert() throws Exception{
		if(service.getID()!=null)
		idLabel.setText(service.getID());
		else
			idLabel.setText("000001");
		classChoice.setValue(null);
		nameField.setText(null);
		modelField.setText(null);
		numberField.setText(null);
		purPriceField.setText(null);
		retailedPriceField.setText(null);
		warmingValueField.setText(null);
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
		if(service.getAllChildrenClass()!=null){
		classList.addAll(service.getAllChildrenClass());
		classChoice.setItems(classList);
		}
		list.clear();
		list.addAll(service.show());
		table.setItems(list);
		initInsert();
		initFind();
		edit();
		manageInit();
	}



	public void edit(){
		Callback<TableColumn<CommodityVO, String>,
	        TableCell<CommodityVO, String>> cellFactory
	            = (TableColumn<CommodityVO, String> p) -> new EditingCell<CommodityVO>();
	    Callback<TableColumn<CommodityVO, Integer>,
		    TableCell<CommodityVO, Integer>> cellFactoryInteger
		        = (TableColumn<CommodityVO, Integer> p) -> new EditingCellInteger<CommodityVO>();

		Callback<TableColumn<CommodityVO, Double>,
			TableCell<CommodityVO, Double>> cellFactoryDouble
			    = (TableColumn<CommodityVO,Double> p) -> new EditingCellDouble<CommodityVO>();


        Callback<TableColumn<CommodityVO, String>,
	        TableCell<CommodityVO, String>> choiceFactory
	            = (TableColumn<CommodityVO, String> p) -> new EditingCellChoice<CommodityVO>(classList);

	    tableName.setCellFactory(cellFactory);
	    tableName.setOnEditCommit(
	            (CellEditEvent<CommodityVO, String> t) -> {
	                ((CommodityVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setName(t.getNewValue());
	                try {
						service.update((CommodityVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch ( Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

	    tableModel.setCellFactory(cellFactory);
	    tableModel.setOnEditCommit(
	            (CellEditEvent<CommodityVO, String> t) -> {
	                ((CommodityVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setModel(t.getNewValue());
	                try {
						service.update((CommodityVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch ( Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

	    tableClass.setCellFactory(choiceFactory);
	    tableClass.setOnEditCommit(
	            (CellEditEvent<CommodityVO, String> t) -> {
	            	try {
	                ((CommodityVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setClassification(t.getNewValue());
						service.update((CommodityVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

	    tableNumber.setCellFactory(cellFactoryInteger);
	    tableNumber.setOnEditCommit(
	            (CellEditEvent<CommodityVO, Integer> t) -> {
	                ((CommodityVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNumber(t.getNewValue());
	                try {
						service.update((CommodityVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

	    tableWarmingValue.setCellFactory(cellFactoryInteger);
	    tableWarmingValue.setOnEditCommit(
	            (CellEditEvent<CommodityVO, Integer> t) -> {
	                ((CommodityVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setWarmingValue(t.getNewValue());
	                try {
						service.update((CommodityVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

	    tableRecPurPrice.setCellFactory(cellFactoryDouble);
	    tableRecPurPrice.setOnEditCommit(
	            (CellEditEvent<CommodityVO, Double> t) -> {
	                ((CommodityVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setRecentPurPrice(t.getNewValue());
	                try {
						service.update((CommodityVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

	    tableRecRetailedPrice.setCellFactory(cellFactoryDouble);
	    tableRecRetailedPrice.setOnEditCommit(
	            (CellEditEvent<CommodityVO, Double> t) -> {
	                ((CommodityVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setRecentRetailedPrice(t.getNewValue());

						try {
							service.update((CommodityVO) t.getTableView().getItems().get(
							        t.getTablePosition().getRow())
							        );
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}


	        });

	}


	public void manageInit(){
		tableID.setCellValueFactory(
			    (TableColumn.CellDataFeatures<CommodityVO, String> param) ->
			    new ReadOnlyStringWrapper(param.getValue().getID())
			);
        tableName.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,String>("name"));
        tableModel.setCellValueFactory(
                new PropertyValueFactory<CommodityVO,String>("model"));
        tableClass.setCellValueFactory(
			    (TableColumn.CellDataFeatures<CommodityVO, String> param) ->
			    new ReadOnlyStringWrapper(param.getValue().getClassification())
			);
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

        deleteInit();
        findChoice.setItems(FXCollections.observableArrayList(FindCommodityType.ID.value,FindCommodityType.NAME.value,
        		FindCommodityType.NUMBER.value,FindCommodityType.CLASSIFICATION.value,FindCommodityType.MODEL.value,
        		FindCommodityType.PURPRICE.value,FindCommodityType.RETAILEDPRICE.value,FindCommodityType.RECENTPURPRICE.value,
        		FindCommodityType.RECENTRETAILEDPRICE.value,FindCommodityType.WARMINGVALUE.value));
	}

	public void deleteInit(){
		tableDelete.setCellFactory((col) -> {
            TableCell<CommodityVO, String> cell = new TableCell<CommodityVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	CommodityVO clickedUser = this.getTableView().getItems().get(this.getIndex());
                        	 try {
	                            	Alert alert = new Alert(AlertType.CONFIRMATION);
	                            	alert.setContentText("确认删除？");
	                            	Optional<ButtonType> result = alert.showAndWait();
	                            	if (result.get() == ButtonType.OK){
	                            		service.delete(clickedUser);
	                            		  list.remove(clickedUser);
	      	                              table.setItems(list);
	                            	}
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


}
