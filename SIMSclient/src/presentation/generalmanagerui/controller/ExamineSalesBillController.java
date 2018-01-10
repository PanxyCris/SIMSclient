package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogic.examinebl.ExamineSalesBL;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindSalesType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
import presentation.common.EditingCellDouble;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.uservo.UserVO;

public class ExamineSalesBillController extends ExamineBillController{

	ExamineBLService<SalesVO> service = new ExamineSalesBL();
	ObservableList<SalesVO> list = FXCollections.observableArrayList();
	ObservableList<CommodityItemVO> commodityList = FXCollections.observableArrayList();
    SalesVO bill;

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	TableView<SalesVO> table;
	@FXML
	TableColumn<SalesVO,String> tableID;
	@FXML
	TableColumn<SalesVO,String> tableType;
	@FXML
	TableColumn<SalesVO,String> tableMember;
	@FXML
	TableColumn<SalesVO,String> tableSaleMan;
	@FXML
	TableColumn<SalesVO,String> tableWarehouse;
	@FXML
	TableColumn<SalesVO,Double> tableBefore;
	@FXML
	TableColumn<SalesVO,Double> tableVoucher;
	@FXML
	TableColumn<SalesVO,Double> tableAllowance;
	@FXML
	TableColumn<SalesVO,Double> tableAfter;
	@FXML
	TableColumn<SalesVO,String> tableOperator;
	@FXML
	TableColumn<SalesVO,String> tableNote;
	@FXML
	TableColumn<SalesVO,String> tableList;
	@FXML
	TableColumn<SalesVO,CheckBox> tablePass;

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
		if(findingField.getText()==null||findChoice.getValue()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"请填写好查询信息");
			warning.showAndWait();
		}else{
		ArrayList<SalesVO> list = service.find(findingField.getText(),FindBillType.getType(findChoice.getValue()));
	       if(list==null){
	    	   Alert error = new Alert(Alert.AlertType.WARNING,ResultMessage.NOTFOUND.value);
               error.showAndWait();
	       }
	       else{
	    	   table.getItems().clear();
	    	   table.getItems().addAll(list);
	       }
		}
	}

	@FXML
	public void success() throws RemoteException{
        ArrayList<SalesVO> choiceList = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        	if(list.get(i).getBox().isSelected()){
        		choiceList.add(list.get(i));
        		list.remove(i);
        		}
        ResultMessage message = service.passBills(choiceList);
        if(message == ResultMessage.SUCCESS){
        	Alert info = new Alert(Alert.AlertType.INFORMATION,"已审批");
        	info.showAndWait();
        }
        else{
        	Alert warning = new Alert(Alert.AlertType.WARNING,message.value);
        	warning.showAndWait();
        }
	}

	@FXML
	public void fail() throws RemoteException{
		ArrayList<SalesVO> choiceList = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        	if(list.get(i).getBox().isSelected()){
        		choiceList.add(list.get(i));
        		list.remove(i);
        		}
        ResultMessage message = service.notPassBills(choiceList);
        if(message == ResultMessage.SUCCESS){
        	Alert info = new Alert(Alert.AlertType.INFORMATION,"已审批");
        	info.showAndWait();
        }
        else{
        	Alert warning = new Alert(Alert.AlertType.WARNING,message.value);
        	warning.showAndWait();
        }
	}


	public void initData(UserVO user) throws RemoteException {
		this.user = user;
		choiceInit();
		receiptChoice.setValue(BillType.SALESBILL.value);
		findChoice.setItems(FXCollections.observableArrayList(FindSalesType.ID.value,FindSalesType.MEMBER.value,
				FindSalesType.OPERATOR.value,FindSalesType.MEMBER.value,FindSalesType.SALEMAN.value,
				FindSalesType.TOTAL.value));
		list.addAll(service.getCommitedBills());
		table.setItems(list);
		edit();
		manageInit();
		listInit();
	}

	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("id"));
		tableType.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("typeString"));
		tableMember.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("retailer"));
		tableSaleMan.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("saleMan"));
		tableWarehouse.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("warehouseString"));
		tableBefore.setCellValueFactory(
                new PropertyValueFactory<SalesVO,Double>("beforePrice"));
		tableAllowance.setCellValueFactory(
                new PropertyValueFactory<SalesVO,Double>("allowance"));
		tableVoucher.setCellValueFactory(
                new PropertyValueFactory<SalesVO,Double>("voucher"));
		tableAfter.setCellValueFactory(
                new PropertyValueFactory<SalesVO,Double>("afterPrice"));
		tableOperator.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("operator"));
		tableNote.setCellValueFactory(
                new PropertyValueFactory<SalesVO,String>("note"));
		tablePass.setCellValueFactory(
                new PropertyValueFactory<SalesVO,CheckBox>("box"));
		checkInit();
	}

	public void checkInit(){

		tableList.setCellFactory((col) -> {
            TableCell<SalesVO, String> cell = new TableCell<SalesVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("查看商品列表");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	SalesVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            commodityList.clear();
                            commodityList.addAll(clickedItem.getCommodity());
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

		 Callback<TableColumn<SalesVO, String>,
         TableCell<SalesVO, String>> cellFactory
                 = (TableColumn<SalesVO, String> p) -> new EditingCell<SalesVO>();


        Callback<TableColumn<SalesVO, Double>,
            TableCell<SalesVO, Double>> cellFactoryDouble
                    = (TableColumn<SalesVO, Double> p) -> new EditingCellDouble<SalesVO>();

        tableVoucher.setCellFactory(cellFactoryDouble);
        tableVoucher.setOnEditCommit(
             (CellEditEvent<SalesVO, Double> t) -> {
            	   double tmp = t.getOldValue();
                   ((SalesVO) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setVoucher(t.getNewValue());
                   SalesVO newVO = ((SalesVO) t.getTableView().getItems().get(
                            t.getTablePosition().getRow()));
                   try {
					if(!update(newVO)){
					       ((SalesVO)t.getTableView().getItems().get(
					                  t.getTablePosition().getRow())
					                  ).setVoucher(tmp);
					   }
				} catch (RemoteException e) {
					e.printStackTrace();
				}
            });

        tableAllowance.setCellFactory(cellFactoryDouble);
        tableAllowance.setOnEditCommit(
             (CellEditEvent<SalesVO, Double> t) -> {
            	   double tmp = t.getOldValue();
                   ((SalesVO) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setAllowance(t.getNewValue());
                   SalesVO newVO = ((SalesVO) t.getTableView().getItems().get(
                            t.getTablePosition().getRow()));
                   try {
					if(!update(newVO)){
					       ((SalesVO)t.getTableView().getItems().get(
					                  t.getTablePosition().getRow())
					                  ).setAllowance(tmp);
					   }
				} catch (RemoteException e) {
					e.printStackTrace();
				}
            });

        tableNote.setCellFactory(cellFactory);
        tableNote.setOnEditCommit(
            (CellEditEvent<SalesVO, String> t) -> {
            	  String tmp = t.getOldValue();
                  ((SalesVO) t.getTableView().getItems().get(
                           t.getTablePosition().getRow())
                           ).setNote(t.getNewValue());
                  SalesVO newVO = ((SalesVO) t.getTableView().getItems().get(
                           t.getTablePosition().getRow()));
                  try {
					if(!update(newVO)){
					      ((SalesVO)t.getTableView().getItems().get(
					                 t.getTablePosition().getRow())
					                 ).setNote(tmp);
					  }
				} catch (RemoteException e) {
					e.printStackTrace();
				}
        });


	}

    public boolean update(SalesVO vo) throws RemoteException{
        ResultMessage message = service.updateBill(vo);
        Boolean result = message == ResultMessage.SUCCESS?true:false;
           Platform.runLater(new Runnable() {
               public void run() {
                   try {
                   switch(message){
                   case SUCCESS:break;
                   default: Alert error = new Alert(Alert.AlertType.ERROR,message.value);
                   error.showAndWait();break;
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
