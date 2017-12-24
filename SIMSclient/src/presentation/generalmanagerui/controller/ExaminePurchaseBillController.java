package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogic.examinebl.ExaminePurchaseBL;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindPurchaseType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.remindui.RemindPrintUI;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;
import vo.uservo.UserVO;

public class ExaminePurchaseBillController extends ExamineBillController{

	ExamineBLService<PurchaseVO> service = new ExaminePurchaseBL();
	ObservableList<PurchaseVO> list = FXCollections.observableArrayList();
	ObservableList<CommodityItemVO> commodityList = FXCollections.observableArrayList();
    PurchaseVO bill;

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;


	@FXML
	TableView<PurchaseVO> table;
	@FXML
	TableColumn<PurchaseVO,String> tableID;
	@FXML
	TableColumn<PurchaseVO,String> tableType;
	@FXML
	TableColumn<PurchaseVO,String> tableMember;
	@FXML
	TableColumn<PurchaseVO,String> tableWarehouse;
	@FXML
	TableColumn<PurchaseVO,Double> tableSum;
	@FXML
	TableColumn<PurchaseVO,String> tableOperator;
	@FXML
	TableColumn<PurchaseVO,String> tableNote;
	@FXML
	TableColumn<PurchaseVO,String> tableList;
	@FXML
	TableColumn<PurchaseVO,CheckBox> tablePass;

	@FXML
	TableView<CommodityItemVO> commodity;
	@FXML
	TableColumn<CommodityItemVO,String> commodityID;
	@FXML
	TableColumn<CommodityItemVO,String> commodityName;
	@FXML
	TableColumn<CommodityItemVO,String> commodityModel;
	@FXML
	TableColumn<CommodityItemVO,Integer> commodityNumber;
	@FXML
	TableColumn<CommodityItemVO,Double> commodityPrice;
	@FXML
	TableColumn<CommodityItemVO,Double> commodityMoney;
	@FXML
	TableColumn<CommodityItemVO,String> commodityNote;


	@FXML
	public void find() throws RemoteException{

		ArrayList<PurchaseVO> list = service.find(findingField.getText(),FindBillType.getType(findChoice.getValue()));
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
	public void success() throws RemoteException{
        ArrayList<PurchaseVO> choiceList = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        	if(list.get(i).getBox().isSelected()){
        		choiceList.add(list.get(i));
        		list.remove(i);
        		}
        service.passBills(choiceList);
	}

	@FXML
	public void fail() throws RemoteException{
		ArrayList<PurchaseVO> choiceList = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        	if(list.get(i).getBox().isSelected()){
        		choiceList.add(list.get(i));
        		list.remove(i);
        		}
        service.notPassBills(choiceList);
	}

	public void initData(UserVO user,BillType type) throws RemoteException {
		this.user = user;
		this.billType = type;
		receiptChoice.setValue(type.value);
	    list.addAll(service.getCommitedBills());
		table.setItems(list);
		edit();
		manageInit();
		listInit();
		findChoice.setItems(FXCollections.observableArrayList(FindPurchaseType.ID.value,FindPurchaseType.MEMBER.value,
				FindPurchaseType.OPERATOR.value,FindPurchaseType.TOTAL.value));
	}

	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("id"));
		tableType.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("typeString"));
		tableMember.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("supplier"));
		tableWarehouse.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("warehouseString"));
		tableSum.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,Double>("sum"));
		tableOperator.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("operator"));
		tableNote.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,String>("note"));
		tablePass.setCellValueFactory(
                new PropertyValueFactory<PurchaseVO,CheckBox>("box"));
		checkInit();
	}

	public void checkInit(){

		tableList.setCellFactory((col) -> {
            TableCell<PurchaseVO, String> cell = new TableCell<PurchaseVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("查看商品列表");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PurchaseVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            commodityList.clear();
                            commodityList.addAll(clickedItem.getCommodities());
                            commodity.setItems(commodityList);
                            bill = clickedItem;

                        });
                    }
                }

            };
            return cell;
        });

	}

	public void edit() throws RemoteException{

		Callback<TableColumn<PurchaseVO, String>,
            TableCell<PurchaseVO, String>> cellFactory
                = (TableColumn<PurchaseVO, String> p) -> new EditingCell<PurchaseVO>();

        tableNote.setCellFactory(cellFactory);
        tableNote.setOnEditCommit(
            (CellEditEvent<PurchaseVO, String> t) -> {
            	  String tmp = t.getOldValue();
                  ((PurchaseVO) t.getTableView().getItems().get(
                           t.getTablePosition().getRow())
                           ).setNote(t.getNewValue());
                  PurchaseVO newVO = ((PurchaseVO) t.getTableView().getItems().get(
                           t.getTablePosition().getRow()));
                  try {
					if(!update(newVO)){
					      ((PurchaseVO)t.getTableView().getItems().get(
					                 t.getTablePosition().getRow())
					                 ).setNote(tmp);
					  }
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        });


	}

    public boolean update(PurchaseVO vo) throws RemoteException{
        ResultMessage message = service.updateBill(vo);
        Boolean result = message == ResultMessage.SUCCESS?true:false;
           Platform.runLater(new Runnable() {
               public void run() {
                   try {
                   switch(message){
                   case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
                   case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
                   case SUCCESS:break;
                   default:break;
                   }
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           });
        return result;
   }



	public void listInit(){
		commodityID.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("id"));
		commodityName.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("name"));
		commodityModel.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("model"));
		commodityNumber.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,Integer>("number"));
		commodityPrice.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,Double>("price"));
		commodityMoney.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,Double>("total"));
		commodityNote.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("remark"));
	}
}
