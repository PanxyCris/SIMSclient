package presentation.generalmanagerui.controller;

import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussiness_stub.PromotionBLService_Stub;
import bussinesslogic.memberbl.MemberController;
import bussinesslogicservice.memberblservice.MemberBLService;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.MemberCategory;
import dataenum.MemberLevel;
import dataenum.PromotionType;
import dataenum.Remind;
import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.common.EditingCellChoice;
import presentation.remindui.RemindExistUI;
import presentation.remindui.RemindPrintUI;
import vo.UserVO;
import vo.commodity.CommodityVO;
import vo.commodity.GiftVO;
import vo.member.MemberVO;
import vo.promotion.PromotionMemberVO;

public class PromotionMemberController extends PromotionMakingController{

	PromotionBLService service = new PromotionBLService_Stub();
	public static final Remind remind = Remind.PROMOTION;
    ObservableList<PromotionMemberVO> list = FXCollections.observableArrayList();
    ObservableList<String> giftList = FXCollections.observableArrayList();
    ObservableList<String> levelList = FXCollections.observableArrayList(MemberLevel.LEVEL1.value,MemberLevel.LEVEL2.value,MemberLevel.LEVEL3.value,MemberLevel.LEVEL4.value,MemberLevel.LEVEL5.value);
    UserVO user;

	@FXML
	TableView<PromotionMemberVO> table;
	@FXML
	TableColumn<PromotionMemberVO,String> tableLevel;
	@FXML
	TableColumn<PromotionMemberVO,Double> tableAllowance;
	@FXML
	TableColumn<PromotionMemberVO,Double> tableVoucher;
	@FXML
	TableColumn<PromotionMemberVO,String> tableStart;
	@FXML
	TableColumn<PromotionMemberVO,String> tableEnd;
	@FXML
	TableColumn<PromotionMemberVO,String> tableCheck;
	@FXML
	TableColumn<PromotionMemberVO,String> tableDelete;

	@FXML
	TableView<CommodityVO> giftTable;
	@FXML
	TableColumn<CommodityVO,String> tableName;
	@FXML
	TableColumn<CommodityVO,Integer> tableNumber;
	@FXML
	TableColumn<CommodityVO,String> tableDeleteGift;

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
	public void insert(){
		ArrayList<GiftVO> gifts = new ArrayList<>();
		gifts.addAll(gifts);
		 PromotionMemberVO vo = new PromotionMemberVO(startPicker.getValue(),endPicker.getValue(),MemberLevel.getLevel(levelChoice.getValue()),
				 Double.parseDouble(allowanceField.getText()), Double.parseDouble(voucherField.getText()),gifts);
	        ResultMessage message = service.insert(vo);
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        case EXISTED:new RemindExistUI().start(remind,true);break;
	    	        case SUCCESS:fresh();break;
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
		 MemberVO vo = new MemberVO(idLabel.getText(),MemberCategory.getCategory(classChoice.getValue()),MemberLevel.getLevel(levelChoice.getValue()),
				 nameField.getText(), phoneField.getText(),addressField.getText(),zipcodeField.getText(),
				 emailField.getText(),amountField.getText(),receiveField.getText(),payField.getText(),
				 operatorField.getText());
	        ResultMessage message = service.insert(vo);
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        case EXISTED:new RemindExistUI().start(remind,true);break;
	    	        case SUCCESS:fresh();break;
	    	        default:break;
	    	        }
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
	}

	@FXML
	public void fresh() throws RemoteException{
		findingField.setText(null);
		list.clear();
		list.addAll(service.show());
		idLabel.setText(service.getId());
		classChoice.setValue(null);
		levelChoice.setValue(null);
		table.setItems(list);
		nameField.setText(null);
		phoneField.setText(null);
		addressField.setText(null);
		zipcodeField.setText(null);
		emailField.setText(null);
		amountField.setText(null);
		receiveField.setText(null);
		payField.setText(null);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			fresh();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		edit();
		manageInit();

	}

	public void edit(){
		Callback<TableColumn<MemberVO, String>,
	        TableCell<MemberVO, String>> cellFactory
	            = (TableColumn<MemberVO, String> p) -> new EditingCell<MemberVO>();

        Callback<TableColumn<MemberVO, String>,
	        TableCell<MemberVO, String>> choiceFactory
	            = (TableColumn<MemberVO, String> p) -> new EditingCellChoice<MemberVO>(levelList);

	    tablePhone.setCellFactory(cellFactory);
	    tablePhone.setOnEditCommit(
	            (CellEditEvent<MemberVO, String> t) -> {
	                ((MemberVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setCellNumber(t.getNewValue());
	                try {
						service.update((MemberVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

	    tableAddress.setCellFactory(cellFactory);
	    tableAddress.setOnEditCommit(
	            (CellEditEvent<MemberVO, String> t) -> {
	                ((MemberVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setAddress(t.getNewValue());
	                try {
						service.update((MemberVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

	    tableZipcode.setCellFactory(cellFactory);
	    tableZipcode.setOnEditCommit(
	            (CellEditEvent<MemberVO, String> t) -> {
	                ((MemberVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setPost(t.getNewValue());
	                try {
						service.update((MemberVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

	    tableEmail.setCellFactory(cellFactory);
	    tableEmail.setOnEditCommit(
	            (CellEditEvent<MemberVO, String> t) -> {
	                ((MemberVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setEmail(t.getNewValue());
	                try {
						service.update((MemberVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

	    tableOperator.setCellFactory(cellFactory);
	    tableOperator.setOnEditCommit(
	            (CellEditEvent<MemberVO, String> t) -> {
	                ((MemberVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setSaleMan(t.getNewValue());
	                try {
						service.update((MemberVO) t.getTableView().getItems().get(
						        t.getTablePosition().getRow())
						        );
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });

        tableLevel.setCellFactory(choiceFactory);
        tableLevel.setOnEditCommit(
            (CellEditEvent<MemberVO, String> t) -> {
                ((MemberVO) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setLevel(t.getNewValue());
                try {
					service.update((MemberVO) t.getTableView().getItems().get(
					        t.getTablePosition().getRow())
					        );
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

        });


	}


	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("ID"));
	    tableCategory.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("categoryStr"));
		tableLevel.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("levelString"));
        tableName.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("name"));
        tablePhone.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("cellNumber"));
        tableAddress.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("address"));
        tableZipcode.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("post"));
        tableEmail.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("email"));
        tableAmount.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("receivableLimit"));
        tableReceive.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("receivable"));
        tablePay.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("payable"));
        tableOperator.setCellValueFactory(
                new PropertyValueFactory<MemberVO,String>("saleMan"));
        deleteInit();
        classChoice.setItems(classList);
        levelChoice.setItems(levelList);
        findChoice.setItems(FXCollections.observableArrayList(FindMemberType.ID.value,FindMemberType.NAME.value,
        		FindMemberType.KIND.value,FindMemberType.ADDRESS.value,FindMemberType.EMAIL.value,FindMemberType.LEVEL.value,
        		FindMemberType.PHONE.value,FindMemberType.POST.value,FindMemberType.PAYABLE.value,FindMemberType.RECEIVABLE.value,
        		FindMemberType.RECEIVABLELIMIT.value,FindMemberType.SALESMAN.value));
	}

	public void deleteInit(){
		tableDelete.setCellFactory((col) -> {
            TableCell<MemberVO, String> cell = new TableCell<MemberVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("É¾³ý");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	MemberVO clickedUser = this.getTableView().getItems().get(this.getIndex());
                            try {
								service.delete(clickedUser.getID());
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

	public void initData(UserVO user) throws Exception {
		operatorField.setText(user.getName());
	}


}
