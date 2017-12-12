package presentation.salestockstaffui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.commoditybl.CommodityController;
import bussinesslogic.purchasebl.PurchaseBL;
import bussinesslogic.purchasebl.PurchaseController;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.remindui.RemindExistUI;
import presentation.remindui.RemindPrintUI;
import vo.commodity.CommodityItemVO;
import vo.purchase.PurchaseVO;

public class PurchaseMakeBillUI extends MakeReceiptUI {

	PurchaseBLService service = new PurchaseController();
	ObservableList<CommodityItemVO> list = FXCollections.observableArrayList();
    BillType type;

    @FXML
    Label typeLabel;

	@FXML
	Label idLabel;
	@FXML
	ChoiceBox<String> memberChoice;
	@FXML
	ChoiceBox<String> warehouseChoice;
	@FXML
	Label sumLabel;
	@FXML
	Label operatorLabel;

	@FXML
	TableView<CommodityItemVO> table;
	@FXML
	TableColumn<CommodityItemVO,String> tableID;
	@FXML
	TableColumn<CommodityItemVO,String> tableName;
	@FXML
	TableColumn<CommodityItemVO,String> tableModel;
	@FXML
	TableColumn<CommodityItemVO,String> tableNumber;
	@FXML
	TableColumn<CommodityItemVO,String> tablePrice;
	@FXML
	TableColumn<CommodityItemVO,String> tableMoney;
	@FXML
	TableColumn<CommodityItemVO,String> tableNote;
	@FXML
	TableColumn<CommodityItemVO,String> tableDelete;

	@FXML
	Label commodityIDLabel;
	@FXML
	ChoiceBox<String> nameChoice;
	@FXML
	ChoiceBox<String> modelChoice;
	@FXML
	TextField numberField;
	@FXML
	TextField priceField;
	@FXML
	Label moneyLabel;
	@FXML
	TextField noteField;

	@FXML
	TextArea noteArea;

	@FXML
	public void insert(){
		 CommodityItemVO vo = new CommodityItemVO(commodityIDLabel.getText(),nameChoice.getValue(),modelChoice.getValue(),
				 numberField.getText(),priceField.getText(),moneyLabel.getText(), noteField.getText());
	        ResultMessage message = service.isLegal(vo);
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        case EXISTED:new RemindExistUI().start(remind,true);break;
	    	        case SUCCESS:list.add(vo);table.setItems(list);
	    	                     double result = Double.parseDouble(moneyLabel.getText())+Double.parseDouble(priceField.getText());
	    	                     moneyLabel.setText(String.valueOf(result));
	    	                     double tmp = Double.parseDouble(sumLabel.getText());
	    	                     sumLabel.setText(String.valueOf(tmp+result));break;
	    	        default:break;
	    	        }
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
	}

	@FXML
	public void save(){
		ArrayList<CommodityItemVO> commodityList = new ArrayList<>();
		commodityList.addAll(list);
         PurchaseVO vo = new PurchaseVO(idLabel.getText(),memberChoice.getValue(),Warehouse.getWarehouse(warehouseChoice.getValue()),
        		 operatorLabel.getText(),commodityList,sumLabel.getText(),noteArea.getText(),BillType.PURCHASEBILL,BillState.DRAFT);
         service.save(vo);
	}

	@FXML
	public void submit(){
		ArrayList<CommodityItemVO> commodityList = new ArrayList<>();
		commodityList.addAll(list);
         PurchaseVO vo = new PurchaseVO(idLabel.getText(),memberChoice.getValue(),Warehouse.getWarehouse(warehouseChoice.getValue()),
        		 operatorLabel.getText(),commodityList,sumLabel.getText(),noteArea.getText(),BillType.PURCHASEBILL,BillState.DRAFT);
         service.submit(vo);
	}

	@FXML
	public void fresh(){
		 numberField.setText(null);
         priceField.setText(null);
         noteField.setText(null);
         noteArea.setText(null);
	}

	@FXML
	public void checkBefore() throws Exception{
          //  new PurchaseCheckBillUI().start();
	}

	public void start(BillType type) throws Exception {
		   changeStage("PurchaseMakeBillUI","PurchaseMakeBillUI.fxml");
		   this.type = type;
		   System.out.println(type.value);
		   typeLabel.setText(type.value);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idLabel.setText(service.getPurchaseID());
		sumLabel.setText("0");
		fresh();
        operatorLabel.setText(readUserName());
	}

	public void edit(){
		Callback<TableColumn<CommodityItemVO, String>,
            TableCell<CommodityItemVO, String>> cellFactory
                = (TableColumn<CommodityItemVO, String> p) -> new EditingCell<CommodityItemVO>();

        tableNumber.setCellFactory(cellFactory);
        tableNumber.setOnEditCommit(
            (CellEditEvent<CommodityItemVO, String> t) -> {
            	String tmp = t.getOldValue();
            	String tmpTotal = ((CommodityItemVO) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).getTotal();
	               ((CommodityItemVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNumber(t.getNewValue());
	               CommodityItemVO newVO = ((CommodityItemVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow()));
	               if(!update(newVO))
	                	  (t.getTableView().getItems().get(
	  	                        t.getTablePosition().getRow())
	  	                        ).setNumber(tmp);
	               else{
	            	   String newTmp = newVO.getNumber();
	            	   double result = Double.parseDouble(sumLabel.getText())-(Integer.parseInt(tmp)-Integer.parseInt(newTmp))*Double.parseDouble(newVO.getPrice());
	            	   ((CommodityItemVO) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setTotal(String.valueOf(result));
	            	   sumLabel.setText(String.valueOf(Double.parseDouble(sumLabel.getText())-Double.parseDouble(tmpTotal)+result));
	               }
        });

        tableMoney.setCellFactory(cellFactory);
        tableMoney.setOnEditCommit(
            (CellEditEvent<CommodityItemVO, String> t) -> {
            	String tmp = t.getOldValue();
            	String tmpTotal = ((CommodityItemVO) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).getTotal();
	               ((CommodityItemVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setPrice(t.getNewValue());
	               CommodityItemVO newVO = ((CommodityItemVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow()));
	               if(!update(newVO))
	                	  (t.getTableView().getItems().get(
	  	                        t.getTablePosition().getRow())
	  	                        ).setPrice(tmp);
	               else{
	            	   String newTmp = newVO.getNumber();
	            	   double result = Double.parseDouble(sumLabel.getText())-(Double.parseDouble(tmp)-Double.parseDouble(newTmp))*Integer.parseInt(newVO.getNumber());
	            	   ((CommodityItemVO) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setTotal(String.valueOf(result));
	            	   sumLabel.setText(String.valueOf(Double.parseDouble(sumLabel.getText())-Double.parseDouble(tmpTotal)+result));
	               }
        });

        tableNote.setCellFactory(cellFactory);
        tableNote.setOnEditCommit(
            (CellEditEvent<CommodityItemVO, String> t) -> {

	               ((CommodityItemVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setRemark(t.getNewValue());
        });
	}

	public boolean update(CommodityItemVO vo){
		 ResultMessage message = service.isLegal(vo);
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

	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("id"));
		tableName.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("name"));
		tableModel.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("model"));
		tableNumber.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("numder"));
		tablePrice.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("price"));
		tableMoney.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("total"));
		tableNote.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("remark"));

        deleteInit();
	}

	public void deleteInit(){
		tableDelete.setCellFactory((col) -> {
            TableCell<CommodityItemVO, String> cell = new TableCell<CommodityItemVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("É¾³ý");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	CommodityItemVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            list.remove(clickedItem);
                            table.setItems(list);
                            double tmp = Double.parseDouble(clickedItem.getTotal());
                            double result = Double.parseDouble(sumLabel.getText())-tmp;
                            sumLabel.setText(String.valueOf(result));
                        });
                    }
                }

            };
            return cell;
        });
	}


}
