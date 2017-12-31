package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.commoditybl.CommodityController;
import bussinesslogic.promotionbl.PromotionSumBL;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.PromotionType;
import dataenum.Remind;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCellDate;
import presentation.common.EditingCellDouble;
import presentation.common.EditingCellInteger;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionTotalVO;
import vo.uservo.UserVO;


public class PromotionSumController extends PromotionMakingController{

	PromotionBLService<PromotionTotalVO> service = new PromotionSumBL();
	public static final Remind remind = Remind.PROMOTION;
	PromotionType type = PromotionType.SUM_PROMOTION;
    ObservableList<PromotionTotalVO> list = FXCollections.observableArrayList();
    ObservableList<GiftVO> giftList = FXCollections.observableArrayList();
    ObservableList<String> giftChoiceList = FXCollections.observableArrayList();
    UserVO user;
    PromotionTotalVO currentPromotion;

    @FXML
    ChoiceBox<String> findChoice;
    @FXML
    TextField findingField;

	@FXML
	TableView<PromotionTotalVO> table;
	@FXML
	TableColumn<PromotionTotalVO,String> tableID;
	@FXML
	TableColumn<PromotionTotalVO,Double> tableSum;
	@FXML
	TableColumn<PromotionTotalVO,Double> tableVoucher;
	@FXML
	TableColumn<PromotionTotalVO,LocalDate> tableStart;
	@FXML
	TableColumn<PromotionTotalVO,LocalDate> tableEnd;
	@FXML
	TableColumn<PromotionTotalVO,String> tableCheck;
	@FXML
	TableColumn<PromotionTotalVO,String> tableDelete;


	@FXML
	TableView<GiftVO> giftTable;
	@FXML
	TableColumn<GiftVO,String> tableName;
	@FXML
	TableColumn<GiftVO,Integer> tableNumber;
	@FXML
	TableColumn<GiftVO,String> tableDeleteGift;

	@FXML
	Label idLabel;
    @FXML
	TextField sumField;
	@FXML
	TextField voucherField;
	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker endPicker;

	@FXML
	ChoiceBox<String> giftChoice;
	@FXML
	TextField numberField;

	@FXML
	public void find() throws RemoteException{
		ArrayList<PromotionTotalVO> list = service.find(findingField.getText(),FindPromotionType.getType(findChoice.getValue()));
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



	@FXML
	public void insert() throws RemoteException{
		ArrayList<GiftVO> gifts = null;
		 PromotionTotalVO vo = new PromotionTotalVO(idLabel.getText(),startPicker.getValue(),endPicker.getValue(),
				 Double.parseDouble(sumField.getText()),Double.parseDouble(voucherField.getText()),gifts);
	        ResultMessage message = service.insert(vo);
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case EXISTED: Alert existed = new Alert(Alert.AlertType.WARNING,"该策略已存在");
	                              existed.showAndWait();break;
	    	        case SUCCESS:list.add(vo);table.setItems(list);
	    	                    initInsert();break;
	    	        default: Alert error = new Alert(Alert.AlertType.ERROR,message.value);
	                error.showAndWait();break;
	    	        }
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
	}

	@FXML
	public void insertGift() throws RemoteException{
		 GiftVO vo = new GiftVO(giftChoice.getValue(),Integer.parseInt(numberField.getText()));
	     giftList.add(vo);
	     giftTable.setItems(giftList);
	     updateGiftList();
	}


	public void initFind(){
		findingField.setText(null);
		findChoice.setValue(null);
	}

	public void initInsert() throws RemoteException{
		idLabel.setText(service.getID());
		voucherField.setText(null);
		startPicker.setValue(null);
		endPicker.setValue(null);
	}


	public void initData(UserVO user) throws Exception {
		this.user = user;
		list.clear();
		list.addAll(service.getPromotionList());
		table.setItems(list);
		initInsert();
		initFind();
		edit();
		manageInit();
		findChoice.setItems(FXCollections.observableArrayList(FindPromotionType.ID.value,FindPromotionType.TIMEINTERVAL.value));
	}

	public void edit(){
		Callback<TableColumn<PromotionTotalVO, Double>,
	        TableCell<PromotionTotalVO, Double>> cellFactoryDouble
	            = (TableColumn<PromotionTotalVO, Double> p) -> new EditingCellDouble<PromotionTotalVO>();

	    Callback<TableColumn<GiftVO, Integer>,
		    TableCell<GiftVO, Integer>> cellFactoryInteger
		        = (TableColumn<GiftVO, Integer> p) -> new EditingCellInteger<GiftVO>();

        Callback<TableColumn<PromotionTotalVO, LocalDate>,
	        TableCell<PromotionTotalVO, LocalDate>> dateFactory
	            = (TableColumn<PromotionTotalVO, LocalDate> p) -> new EditingCellDate<PromotionTotalVO>();

	    tableVoucher.setCellFactory(cellFactoryDouble);
	    tableVoucher.setOnEditCommit(
	            (CellEditEvent<PromotionTotalVO, Double> t) -> {
	                ((PromotionTotalVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setVoucher(t.getNewValue());
	                try {
						service.update((PromotionTotalVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
								);
					} catch (RemoteException e) {
						e.printStackTrace();
					}

	        });

	    tableStart.setCellFactory(dateFactory);
	    tableStart.setOnEditCommit(
	            (CellEditEvent<PromotionTotalVO, LocalDate> t) -> {
	                ((PromotionTotalVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setBeginDate(t.getNewValue());
	                try {
						service.update((PromotionTotalVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
								);
					} catch (RemoteException e) {
						e.printStackTrace();
					}

	        });

	    tableEnd.setCellFactory(dateFactory);
	    tableEnd.setOnEditCommit(
	            (CellEditEvent<PromotionTotalVO, LocalDate> t) -> {
	                ((PromotionTotalVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setEndDate(t.getNewValue());
	                try {
						service.update((PromotionTotalVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
								);
					} catch (RemoteException e) {
						e.printStackTrace();
					}

	        });



	    tableNumber.setCellFactory(cellFactoryInteger);
	    tableNumber.setOnEditCommit(
	            (CellEditEvent<GiftVO, Integer> t) -> {
	                ((GiftVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNumber(t.getNewValue());
	            try {
					updateGiftList();
				} catch (RemoteException e) {
					e.printStackTrace();
				}

	        });

	}


	public void manageInit() throws Exception{
		tableID.setCellValueFactory(
                new PropertyValueFactory<PromotionTotalVO,String>("id"));
		tableSum.setCellValueFactory(
	                new PropertyValueFactory<PromotionTotalVO,Double>("total"));
	    tableStart.setCellValueFactory(
                new PropertyValueFactory<PromotionTotalVO,LocalDate>("beginDate"));
        tableEnd.setCellValueFactory(
                new PropertyValueFactory<PromotionTotalVO,LocalDate>("endDate"));
        tableVoucher.setCellValueFactory(
                new PropertyValueFactory<PromotionTotalVO,Double>("voucher"));

        tableName.setCellValueFactory(
                new PropertyValueFactory<GiftVO,String>("name"));
	    tableNumber.setCellValueFactory(
                new PropertyValueFactory<GiftVO,Integer>("number"));
	    checkInit();
        deleteInit();
        deleteGiftInit();
        CommodityBLService commodityservice = new CommodityController();
        giftChoiceList.addAll(commodityservice.getIDandName());
        giftChoice.setItems(giftChoiceList);

	}

	public void checkInit(){

		tableCheck.setCellFactory((col) -> {
            TableCell<PromotionTotalVO, String> cell = new TableCell<PromotionTotalVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("查看赠品列表");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PromotionTotalVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                        	currentPromotion = clickedItem;
                            giftList.clear();
                            if(clickedItem.getGifts()!=null)
                            giftList.addAll(clickedItem.getGifts());
                            giftTable.setItems(giftList);

                        });
                    }
                }

            };
            return cell;
        });

	}

	public void deleteInit(){
		tableDelete.setCellFactory((col) -> {
            TableCell<PromotionTotalVO, String> cell = new TableCell<PromotionTotalVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PromotionTotalVO clickedUser = this.getTableView().getItems().get(this.getIndex());
                            try {
								service.delete(clickedUser);
							} catch (RemoteException e) {
								e.printStackTrace();
							}
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


		tableDeleteGift.setCellFactory((col) -> {
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
                            giftList.remove(clickedUser);
                            giftTable.setItems(giftList);
                            try {
								updateGiftList();
							} catch (RemoteException e) {
								e.printStackTrace();
							}
                        });
                    }
                }

            };
            return cell;
        });
	}

    public void updateGiftList() throws RemoteException{
    	 PromotionTotalVO promotion = currentPromotion;
         ArrayList<GiftVO> gifts = new ArrayList<>();
    	 gifts.addAll(giftList);
    	 promotion.setGifts(gifts);
    	 service.update(promotion);
    }

}