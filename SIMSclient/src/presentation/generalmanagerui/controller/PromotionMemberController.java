package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;

import java.time.LocalDate;
import java.util.ArrayList;
import bussiness_stub.CommodityBLService_Stub;
import bussiness_stub.promotion_stub.PromotionMemberBLService_Stub;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.MemberLevel;
import dataenum.PromotionType;
import dataenum.Remind;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import dataenum.findtype.FindSalesType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.GiftVO;
import vo.promotionvo.PromotionMemberVO;
import vo.uservo.UserVO;


public class PromotionMemberController extends PromotionMakingController{

	PromotionBLService<PromotionMemberVO> service = new PromotionMemberBLService_Stub();
	public static final Remind remind = Remind.PROMOTION;
	PromotionType type = PromotionType.LEVEL_PROMOTION;
    ObservableList<PromotionMemberVO> list = FXCollections.observableArrayList();
    ObservableList<GiftVO> giftList = FXCollections.observableArrayList();
    ObservableList<String> giftChoiceList = FXCollections.observableArrayList();
    ObservableList<String> levelList = FXCollections.observableArrayList(MemberLevel.LEVEL1.value,MemberLevel.LEVEL2.value,MemberLevel.LEVEL3.value,MemberLevel.LEVEL4.value,MemberLevel.LEVEL5.value);
    UserVO user;
    PromotionMemberVO currentPromotion;

    @FXML
    ChoiceBox<String> findChoice;
    @FXML
    TextField findingField;

	@FXML
	TableView<PromotionMemberVO> table;
	@FXML
	TableColumn<PromotionMemberVO,String> tableID;
	@FXML
	TableColumn<PromotionMemberVO,String> tableLevel;
	@FXML
	TableColumn<PromotionMemberVO,Double> tableAllowance;
	@FXML
	TableColumn<PromotionMemberVO,Double> tableVoucher;
	@FXML
	TableColumn<PromotionMemberVO,LocalDate> tableStart;
	@FXML
	TableColumn<PromotionMemberVO,LocalDate> tableEnd;
	@FXML
	TableColumn<PromotionMemberVO,String> tableCheck;
	@FXML
	TableColumn<PromotionMemberVO,String> tableDelete;

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
	ChoiceBox<String> levelChoice;
	@FXML
	TextField allowanceField;
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
	public void find(){
		ArrayList<PromotionMemberVO> list = service.find(findingField.getText(),FindPromotionType.getType(findChoice.getValue()));
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
	    	   initFind();
	       }
	}

	@FXML
	public void insert(){
		ArrayList<GiftVO> gifts = null;
		 PromotionMemberVO vo = new PromotionMemberVO(idLabel.getText(),startPicker.getValue(),endPicker.getValue(),MemberLevel.getLevel(levelChoice.getValue()),
				 Double.parseDouble(allowanceField.getText()), Double.parseDouble(voucherField.getText()),gifts);
	        ResultMessage message = service.insert(vo);
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        case EXISTED:new RemindExistUI().start(remind,true);break;
	    	        case SUCCESS:list.add(vo);table.setItems(list);
	    	                     initInsert();break;
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


	public void initFind(){
		findingField.setText(null);
		findChoice.setValue(null);
	}

	public void initInsert(){
        idLabel.setText(service.getID());
		levelChoice.setValue(null);
		allowanceField.setText(null);
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
		findChoice.setItems(FXCollections.observableArrayList(FindPromotionType.ID.value,
				FindPromotionType.TIMEINTERVAL.value));
	}

	public void edit(){
		Callback<TableColumn<PromotionMemberVO, Double>,
	        TableCell<PromotionMemberVO, Double>> cellFactoryDouble
	            = (TableColumn<PromotionMemberVO, Double> p) -> new EditingCellDouble<PromotionMemberVO>();

	    Callback<TableColumn<GiftVO, Integer>,
		    TableCell<GiftVO, Integer>> cellFactoryInteger
		        = (TableColumn<GiftVO, Integer> p) -> new EditingCellInteger<GiftVO>();

        Callback<TableColumn<PromotionMemberVO, LocalDate>,
	        TableCell<PromotionMemberVO, LocalDate>> dateFactory
	            = (TableColumn<PromotionMemberVO, LocalDate> p) -> new EditingCellDate<PromotionMemberVO>();

	    tableAllowance.setCellFactory(cellFactoryDouble);
	    tableAllowance.setOnEditCommit(
	            (CellEditEvent<PromotionMemberVO, Double> t) -> {
	                ((PromotionMemberVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setAllowance(t.getNewValue());
	                service.update((PromotionMemberVO) t.getTableView().getItems().get(
					        t.getTablePosition().getRow())
	                		);

	        });

	    tableVoucher.setCellFactory(cellFactoryDouble);
	    tableVoucher.setOnEditCommit(
	            (CellEditEvent<PromotionMemberVO, Double> t) -> {
	                ((PromotionMemberVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setVoucher(t.getNewValue());
	                service.update((PromotionMemberVO) t.getTableView().getItems().get(
					        t.getTablePosition().getRow())
	                		);

	        });

	    tableStart.setCellFactory(dateFactory);
	    tableStart.setOnEditCommit(
	            (CellEditEvent<PromotionMemberVO, LocalDate> t) -> {
	                ((PromotionMemberVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setBeginDate(t.getNewValue());
	                service.update((PromotionMemberVO) t.getTableView().getItems().get(
					        t.getTablePosition().getRow())
	                		);

	        });

	    tableEnd.setCellFactory(dateFactory);
	    tableEnd.setOnEditCommit(
	            (CellEditEvent<PromotionMemberVO, LocalDate> t) -> {
	                ((PromotionMemberVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setEndDate(t.getNewValue());
	                service.update((PromotionMemberVO) t.getTableView().getItems().get(
					        t.getTablePosition().getRow())
	                		);

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


	public void manageInit() throws Exception{
		tableID.setCellValueFactory(
                new PropertyValueFactory<PromotionMemberVO,String>("id"));
		tableLevel.setCellValueFactory(
                new PropertyValueFactory<PromotionMemberVO,String>("levelString"));
	    tableStart.setCellValueFactory(
                new PropertyValueFactory<PromotionMemberVO,LocalDate>("beginDate"));
        tableEnd.setCellValueFactory(
                new PropertyValueFactory<PromotionMemberVO,LocalDate>("endDate"));
        tableAllowance.setCellValueFactory(
                new PropertyValueFactory<PromotionMemberVO,Double>("allowance"));
        tableVoucher.setCellValueFactory(
                new PropertyValueFactory<PromotionMemberVO,Double>("voucher"));

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
        levelChoice.setItems(levelList);

	}

	public void checkInit(){

		tableCheck.setCellFactory((col) -> {
            TableCell<PromotionMemberVO, String> cell = new TableCell<PromotionMemberVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("查看赠品列表");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PromotionMemberVO clickedItem = this.getTableView().getItems().get(this.getIndex());
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
            TableCell<PromotionMemberVO, String> cell = new TableCell<PromotionMemberVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PromotionMemberVO clickedUser = this.getTableView().getItems().get(this.getIndex());
                            service.delete(clickedUser);
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
    	 PromotionMemberVO promotion = currentPromotion;
         ArrayList<GiftVO> gifts = new ArrayList<>();
    	 gifts.addAll(giftList);
    	 promotion.setGifts(gifts);
    	 service.update(promotion);
    }

}