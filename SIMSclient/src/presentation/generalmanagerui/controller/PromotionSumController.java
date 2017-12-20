package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import bussiness_stub.CommodityBLService_Stub;
import bussiness_stub.promotion_stub.PromotionTotalBLService_Stub;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.PromotionType;
import dataenum.Remind;
import dataenum.ResultMessage;
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
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionTotalVO;
import vo.uservo.UserVO;


public class PromotionSumController extends PromotionMakingController{

	PromotionBLService<PromotionTotalVO> service = new PromotionTotalBLService_Stub();
	public static final Remind remind = Remind.PROMOTION;
	PromotionType type = PromotionType.SUM_PROMOTION;
    ObservableList<PromotionTotalVO> list = FXCollections.observableArrayList();
    ObservableList<GiftVO> giftList = FXCollections.observableArrayList();
    ObservableList<String> giftChoiceList = FXCollections.observableArrayList();
    UserVO user;
    PromotionTotalVO currentPromotion;

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
	public void insert(){
		ArrayList<GiftVO> gifts = null;
		 PromotionTotalVO vo = new PromotionTotalVO(idLabel.getText(),startPicker.getValue(),endPicker.getValue(),
				 Double.parseDouble(sumField.getText()),Double.parseDouble(voucherField.getText()),gifts);
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
		 GiftVO vo = new GiftVO(giftChoice.getValue(),Integer.parseInt(numberField.getText()));
	     giftList.add(vo);
	     giftTable.setItems(giftList);
	     updateGiftList();
	}

	@FXML
	public void fresh() throws RemoteException{
		idLabel.setText(service.getID());
		list.clear();
		list.addAll(service.getPromotionList(type));
		table.setItems(list);
		voucherField.setText(null);
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
		edit();
		manageInit();
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
	                service.update((PromotionTotalVO) t.getTableView().getItems().get(
					        t.getTablePosition().getRow())
	                		,type);

	        });

	    tableStart.setCellFactory(dateFactory);
	    tableStart.setOnEditCommit(
	            (CellEditEvent<PromotionTotalVO, LocalDate> t) -> {
	                ((PromotionTotalVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setBeginDate(t.getNewValue());
	                service.update((PromotionTotalVO) t.getTableView().getItems().get(
					        t.getTablePosition().getRow())
	                		,type);

	        });

	    tableEnd.setCellFactory(dateFactory);
	    tableEnd.setOnEditCommit(
	            (CellEditEvent<PromotionTotalVO, LocalDate> t) -> {
	                ((PromotionTotalVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setEndDate(t.getNewValue());
	                service.update((PromotionTotalVO) t.getTableView().getItems().get(
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
        CommodityBLService commodityservice = new CommodityBLService_Stub();
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
                            updateGiftList();
                        });
                    }
                }

            };
            return cell;
        });
	}

    public void updateGiftList(){
    	 PromotionTotalVO promotion = currentPromotion;
         ArrayList<GiftVO> gifts = new ArrayList<>();
    	 gifts.addAll(giftList);
    	 promotion.setGifts(gifts);
    	 service.update(promotion,type);
    }

}