package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;

import java.time.LocalDate;
import java.util.ArrayList;

import bussiness_stub.CommodityBLService_Stub;
import bussiness_stub.promotion_stub.PromotionMemberBLService_Stub;
import bussiness_stub.promotion_stub.PromotionSpecialBLService_Stub;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.MemberLevel;
import dataenum.PromotionType;
import dataenum.Remind;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCellDate;
import presentation.common.EditingCellDouble;
import presentation.common.EditingCellInteger;
import presentation.remindui.RemindExistUI;
import presentation.remindui.RemindPrintUI;
import vo.uservo.UserVO;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;

public class PromotionSpecialController {
	PromotionBLService<PromotionPricePacksVO> service = new PromotionSpecialBLService_Stub();
	public static final Remind remind = Remind.PROMOTION;
    ObservableList<PromotionPricePacksVO> list = FXCollections.observableArrayList();
    ObservableList<GiftVO> commodityList = FXCollections.observableArrayList();
    ObservableList<String> commodityChoiceList = FXCollections.observableArrayList();
    UserVO user;
    PromotionPricePacksVO currentPromotion;
    PromotionType type = PromotionType.PRICEPACKS;

    @FXML
    ChoiceBox<String> findChoice;
    @FXML
    TextField findingField;

	@FXML
	TableView<PromotionPricePacksVO> table;
	@FXML
	TableColumn<PromotionPricePacksVO,String> tableID;
	@FXML
	TableColumn<PromotionPricePacksVO,Double> tableAllowance;

	@FXML
	TableColumn<PromotionPricePacksVO,LocalDate> tableStart;
	@FXML
	TableColumn<PromotionPricePacksVO,LocalDate> tableEnd;
	@FXML
	TableColumn<PromotionPricePacksVO,String> tableCheck;
	@FXML
	TableColumn<PromotionPricePacksVO,String> tableDelete;

	@FXML
	TableView<GiftVO> commodityTable;
	@FXML
	TableColumn<GiftVO,String> tableName;
	@FXML
	TableColumn<GiftVO,Integer> tableNumber;
	@FXML
	TableColumn<GiftVO,String> tableDeleteCommodity;

	@FXML
	Label idLabel;
	@FXML
	TextField allowanceField;
	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	ChoiceBox<String> commodityChoice;
	@FXML
	TextField numberField;

	@FXML
	public void find(){
		ArrayList<PromotionPricePacksVO> list = service.find(findingField.getText(),FindPromotionType.getType(findChoice.getValue()),type);
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
	public void insert(){
		ArrayList<GiftVO> gifts = new ArrayList<>();
		gifts = null;
		 PromotionPricePacksVO vo = new PromotionPricePacksVO(idLabel.getText(),startPicker.getValue(),endPicker.getValue(),
				 Double.parseDouble(allowanceField.getText()),gifts);
	        ResultMessage message = service.insert(vo,type);
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        case EXISTED:new RemindExistUI().start(remind,true);break;
	    	        case SUCCESS:list.add(vo);table.setItems(list);break;
	    	        default:break;
	    	        }
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
	}

	@FXML
	public void insertGift(){
		 GiftVO vo = new GiftVO(commodityChoice.getValue(),Integer.parseInt(numberField.getText()));
	     commodityList.add(vo);
	     commodityTable.setItems(commodityList);
	     updateGiftList();
	}

	@FXML
	public void fresh() throws RemoteException{
		idLabel.setText(service.getID());
		list.clear();
		list.addAll(service.getPromotionList(type));
		table.setItems(list);
		allowanceField.setText(null);
		startPicker.setValue(null);
		endPicker.setValue(null);
	}


	public void initData(UserVO user) throws Exception {
		this.user = user;
		try {
			fresh();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		findChoice.setItems(FXCollections.observableArrayList(FindPromotionType.ID.value,FindPromotionType.TIMEINTERVAL.value));
		edit();
		manageInit();
	}

	public void edit(){
		Callback<TableColumn<PromotionPricePacksVO, Double>,
	        TableCell<PromotionPricePacksVO, Double>> cellFactoryDouble
	            = (TableColumn<PromotionPricePacksVO, Double> p) -> new EditingCellDouble<PromotionPricePacksVO>();

	    Callback<TableColumn<GiftVO, Integer>,
		    TableCell<GiftVO, Integer>> cellFactoryInteger
		        = (TableColumn<GiftVO, Integer> p) -> new EditingCellInteger<GiftVO>();

        Callback<TableColumn<PromotionPricePacksVO, LocalDate>,
	        TableCell<PromotionPricePacksVO, LocalDate>> dateFactory
	            = (TableColumn<PromotionPricePacksVO, LocalDate> p) -> new EditingCellDate<PromotionPricePacksVO>();

	    tableAllowance.setCellFactory(cellFactoryDouble);
	    tableAllowance.setOnEditCommit(
	            (CellEditEvent<PromotionPricePacksVO, Double> t) -> {
	                ((PromotionPricePacksVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setDiscount(t.getNewValue());
	                service.update((PromotionPricePacksVO) t.getTableView().getItems().get(
					        t.getTablePosition().getRow())
					        ,type);

	        });
	    tableStart.setCellFactory(dateFactory);
	    tableStart.setOnEditCommit(
	            (CellEditEvent<PromotionPricePacksVO, LocalDate> t) -> {
	                ((PromotionPricePacksVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setBeginDate(t.getNewValue());
	                service.update((PromotionPricePacksVO) t.getTableView().getItems().get(
					        t.getTablePosition().getRow())
					        ,type);

	        });

	    tableEnd.setCellFactory(dateFactory);
	    tableEnd.setOnEditCommit(
	            (CellEditEvent<PromotionPricePacksVO, LocalDate> t) -> {
	                ((PromotionPricePacksVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setEndDate(t.getNewValue());
	                service.update((PromotionPricePacksVO) t.getTableView().getItems().get(
					        t.getTablePosition().getRow())
					        ,type);

	        });



	    tableNumber.setCellFactory(cellFactoryInteger);
	    tableNumber.setOnEditCommit(
	            (CellEditEvent<GiftVO, Integer> t) -> {
	                ((GiftVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNumber(t.getNewValue());
	            updateGiftList();

	        });

	}


	public void manageInit(){
		tableID.setCellValueFactory(
	                new PropertyValueFactory<PromotionPricePacksVO,String>("id"));

	    tableStart.setCellValueFactory(
                new PropertyValueFactory<PromotionPricePacksVO,LocalDate>("beginDate"));
        tableEnd.setCellValueFactory(
                new PropertyValueFactory<PromotionPricePacksVO,LocalDate>("endDate"));
        tableAllowance.setCellValueFactory(
                new PropertyValueFactory<PromotionPricePacksVO,Double>("discount"));

        tableName.setCellValueFactory(
                new PropertyValueFactory<GiftVO,String>("name"));
	    tableNumber.setCellValueFactory(
                new PropertyValueFactory<GiftVO,Integer>("number"));
	    checkInit();
        deleteInit();
        deleteGiftInit();
        CommodityBLService commodityservice = new CommodityBLService_Stub();
        commodityChoiceList.addAll(commodityservice.getIDandName());
        commodityChoice.setItems(commodityChoiceList);

	}

	public void checkInit(){

		tableCheck.setCellFactory((col) -> {
            TableCell<PromotionPricePacksVO, String> cell = new TableCell<PromotionPricePacksVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("查看商品列表");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PromotionPricePacksVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                        	currentPromotion = clickedItem;
                            commodityList.clear();
                            commodityList.addAll(clickedItem.getPricePacks());
                            commodityTable.setItems(commodityList);

                        });
                    }
                }

            };
            return cell;
        });

	}

	public void deleteInit(){
		tableDelete.setCellFactory((col) -> {
            TableCell<PromotionPricePacksVO, String> cell = new TableCell<PromotionPricePacksVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PromotionPricePacksVO clickedUser = this.getTableView().getItems().get(this.getIndex());
                            service.delete(clickedUser,type);
                            list.remove(clickedUser);
                            table.setItems(list);
                        });
                    }
                }

            };
            return cell;
        });



	}

    public void deleteGiftInit(){


		tableDeleteCommodity.setCellFactory((col) -> {
            TableCell<GiftVO, String> cell = new TableCell<GiftVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	GiftVO clickedUser = this.getTableView().getItems().get(this.getIndex());
                            commodityList.remove(clickedUser);
                            commodityTable.setItems(commodityList);
                            updateGiftList();
                        });
                    }
                }

            };
            return cell;
        });
	}

    public void updateGiftList(){
    	 PromotionPricePacksVO promotion = currentPromotion;
         ArrayList<GiftVO> gifts = new ArrayList<>();
    	 gifts.addAll(commodityList);
    	 promotion.setPricePacks(gifts);
    	 service.update(promotion,type);
    }

}
