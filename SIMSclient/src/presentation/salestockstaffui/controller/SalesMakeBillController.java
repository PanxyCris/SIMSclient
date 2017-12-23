package presentation.salestockstaffui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.commoditybl.CommodityBL;
import bussinesslogic.memberbl.MemberController;
import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.memberblservice.MemberBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindCommodityType;
import dataenum.findtype.FindMemberType;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import presentation.common.EditingCellDouble;
import presentation.common.EditingCellInteger;
import presentation.remindui.RemindExistUI;
import presentation.remindui.RemindPrintUI;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.promotionvo.PromotionVO;
import vo.uservo.UserVO;

public class SalesMakeBillController extends MakeReceiptController{


	SalesBLService service = new SalesController();//׮
	ObservableList<CommodityItemVO> list = FXCollections.observableArrayList();
	ObservableList<PromotionVO> promotionlist = FXCollections.observableArrayList();

    @FXML
    Label typeLabel;

	@FXML
	Label idLabel;
	@FXML
	ChoiceBox<String> memberChoice;
	@FXML
	Label saleManLabel;
	@FXML
	ChoiceBox<String> warehouseChoice;
	@FXML
	Label beforeLabel;
    @FXML
	Label operatorLabel;
    @FXML
   	Label voucherLabel;
    @FXML
   	Label allowanceLabel;
    @FXML
   	TextField allowanceField;
    @FXML
   	Label afterLabel;

	@FXML
	TableView<CommodityItemVO> table;
	@FXML
	TableColumn<CommodityItemVO,String> tableID;
	@FXML
	TableColumn<CommodityItemVO,String> tableName;
	@FXML
	TableColumn<CommodityItemVO,String> tableModel;
	@FXML
	TableColumn<CommodityItemVO,Integer> tableNumber;
	@FXML
	TableColumn<CommodityItemVO,Double> tablePrice;
	@FXML
	TableColumn<CommodityItemVO,Double> tableMoney;
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
	TextArea remarkArea;

	@FXML
	TextArea noteArea;


	@FXML
	public void returnLast() throws Exception{
        startUI(previous,user,type,purchase,sale);
        if(!stack.isEmpty()){
        stack.pop();
        current = previous;
        }
        if(stack.size()>1)
            previous = stack.lastElement();
	}

	@FXML
	public void mainPage() throws Exception{
		changeStage(mainID,user,type,purchase,sale);

    }

    @FXML
	public void memberManage() throws Exception{
         changeStage("MemberManageUI",user,type,null,null);
	}

	@FXML
	public void makeReceipt() throws Exception{
		 changeStage("MakeReceiptUI",user,type,null,null);
	}


	@FXML
	public void insert(){
		 CommodityItemVO vo = new CommodityItemVO(commodityIDLabel.getText(),nameChoice.getValue(),modelChoice.getValue(),
				 Integer.parseInt(numberField.getText()),Double.parseDouble(priceField.getText()), remarkArea.getText());
	        ResultMessage message = service.isLegal(vo);
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        case EXISTED:new RemindExistUI().start(remind,true);break;
	    	        case SUCCESS:list.add(vo);table.setItems(list);
	    	                     double result = Double.parseDouble(moneyLabel.getText())+Double.parseDouble(beforeLabel.getText());
	    	                     beforeLabel.setText(String.valueOf(result));
	    	                     freshAfter();
	    	                    break;
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
         SalesVO vo = new SalesVO(idLabel.getText(),memberChoice.getValue(),saleManLabel.getText(),operatorLabel.getText(),
        		 Warehouse.getWarehouse(warehouseChoice.getValue()),commodityList,Double.parseDouble(beforeLabel.getText()),
        		 Double.parseDouble(allowanceLabel.getText()),Double.parseDouble(voucherLabel.getText()),
        		 Double.parseDouble(afterLabel.getText()),noteArea.getText(),BillState.DRAFT,type);
         service.save(vo);
	}

	@FXML
	public void submit(){
		ArrayList<CommodityItemVO> commodityList = new ArrayList<>();
		commodityList.addAll(list);
		SalesVO vo = new SalesVO(idLabel.getText(),memberChoice.getValue(),saleManLabel.getText(),operatorLabel.getText(),
       		 Warehouse.getWarehouse(warehouseChoice.getValue()),commodityList,Double.parseDouble(beforeLabel.getText()),
       		 Double.parseDouble(allowanceLabel.getText()),Double.parseDouble(voucherLabel.getText()),
       		 Double.parseDouble(afterLabel.getText()),noteArea.getText(),BillState.COMMITED,type);
         service.submit(vo);
	}

	@FXML
	public void fresh(){

		 numberField.setText(null);
         priceField.setText(null);
         remarkArea.setText(null);
         allowanceField.setText(null);
         if(purchase == null)
         noteArea.setText(null);
         else
        	 noteArea.setText(purchase.getNote());

	}

	@FXML
	public void checkBefore() throws Exception{
         changeStage("SalesCheckBillUI",user,type,null,null);
	}

	@FXML
	public void checkPromotion() throws Exception{
         changeStage("PromotionCheckUI",user,type,null,sale);
	}


	public void initData(UserVO user, BillType type, SalesVO sale) throws Exception {
		 this.type = type;
		   this.user = user;
		   this.sale = sale;
		   typeLabel.setText(type.value);

			if(sale == null){
				if(type == BillType.SALESBILL)
				    idLabel.setText(service.getSaleID());
				else
					idLabel.setText(service.getBackSaleID());
			    beforeLabel.setText("0");
			    afterLabel.setText("0");
			    allowanceLabel.setText("0");
			    voucherLabel.setText("0");
				operatorLabel.setText(user.getName());
				}
				else{
					idLabel.setText(sale.getId());
					beforeLabel.setText(String.valueOf(sale.getBeforePrice()));
					afterLabel.setText(String.valueOf(sale.getAfterPrice()));
					allowanceLabel.setText(String.valueOf(sale.getAllowance()));
					voucherLabel.setText(String.valueOf(sale.getVoucher()));
					list.addAll(sale.getCommodity());
					table.setItems(list);
					operatorLabel.setText(sale.getOperator());

				}
				fresh();
				edit();
				manageInit();
	}



	public void edit(){
		Callback<TableColumn<CommodityItemVO, String>,
            TableCell<CommodityItemVO, String>> cellFactory
                = (TableColumn<CommodityItemVO, String> p) -> new EditingCell<CommodityItemVO>();
        Callback<TableColumn<CommodityItemVO, Integer>,
            TableCell<CommodityItemVO, Integer>> cellFactoryInteger
                = (TableColumn<CommodityItemVO, Integer> p) -> new EditingCellInteger<CommodityItemVO>();
        Callback<TableColumn<CommodityItemVO,Double>,
            TableCell<CommodityItemVO, Double>> cellFactoryDouble
                = (TableColumn<CommodityItemVO, Double> p) -> new EditingCellDouble<CommodityItemVO>();

        tableNumber.setCellFactory(cellFactoryInteger);
        tableNumber.setOnEditCommit(
            (CellEditEvent<CommodityItemVO, Integer> t) -> {
            	Integer tmp = t.getOldValue();
            	Double tmpTotal = ((CommodityItemVO) t.getTableView().getItems().get(
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
	            	   Integer newTmp = newVO.getNumber();
	            	   double result = Double.parseDouble(beforeLabel.getText())-(tmp-newTmp*newVO.getPrice());
	            	   ((CommodityItemVO) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setTotal(result);
	            	   beforeLabel.setText(String.valueOf(Double.parseDouble(beforeLabel.getText())-tmpTotal+result));
	            	   freshAfter();
	               }
        });

        tableMoney.setCellFactory(cellFactoryDouble);
        tableMoney.setOnEditCommit(
            (CellEditEvent<CommodityItemVO, Double> t) -> {
            	Double tmp = t.getOldValue();
            	Double tmpTotal = ((CommodityItemVO) t.getTableView().getItems().get(
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
	            	   Integer newTmp = newVO.getNumber();
	            	   double result = Double.parseDouble(beforeLabel.getText())-(tmp-newTmp)*newVO.getNumber();
	            	   ((CommodityItemVO) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setTotal(result);
	            	   beforeLabel.setText(String.valueOf(Double.parseDouble(beforeLabel.getText())-tmpTotal+result));
	            	   freshAfter();
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

	public void manageInit() throws Exception{
		tableID.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("id"));
		tableName.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("name"));
		tableModel.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("model"));
		tableNumber.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,Integer>("number"));
		tablePrice.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,Double>("price"));
		tableMoney.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,Double>("total"));
		tableNote.setCellValueFactory(
                new PropertyValueFactory<CommodityItemVO,String>("remark"));
		choiceInit();
        textFieldInit();
        deleteInit();
	}

	public void choiceInit() throws Exception{
        ObservableList<String> memberList = FXCollections.observableArrayList();
        MemberBLService memberService = new MemberController();//׮
        memberList.addAll(memberService.getIDandName());
        memberChoice.setItems(memberList);
        memberChoice.getSelectionModel().selectedItemProperty().addListener(
        		(ObservableValue<? extends String> cl,String oldValue,String newValue)->{
        			MemberBLService memberservice = new MemberController();
        			String s = "";
        			for(int i=0;i<newValue.length();i++)
        				if(newValue.charAt(i)=='(') {
        					s = newValue.substring(i+1, newValue.length()-1);
        			        break;
        				}
        try {
			saleManLabel.setText(memberservice.find(s, FindMemberType.ID).get(0).getSaleMan());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        		});

        warehouseChoice.setItems(FXCollections.observableArrayList(Warehouse.WAREHOUSE1.value,Warehouse.WAREHOUSE2.value));

        ObservableList<String> commodityList = FXCollections.observableArrayList();
        CommodityBLService commodityService = new CommodityBL();//׮

    	commodityList.addAll(commodityService.getIDandName());

        nameChoice.setItems(commodityList);
        nameChoice.getSelectionModel().selectedItemProperty().addListener(
        		(ObservableValue<? extends String> cl,String oldValue,String newValue)->{
        			ObservableList<String> modelList = FXCollections.observableArrayList();
        			modelList.clear();
        			String s = "";
        			for(int i=0;i<newValue.length();i++)
        				if(newValue.charAt(i)=='(') {
        					s = newValue.substring(i+1, newValue.length()-1);
        			        break;
        				}
        			commodityIDLabel.setText(s);
        			try {
						for(int i=0;i<commodityService.find(s, FindCommodityType.ID).size();i++)
						modelList.add(commodityService.find(s, FindCommodityType.ID).get(i).getModel());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			modelChoice.setItems(modelList);
        		});


        if(sale!=null){
        	memberChoice.setValue(sale.getRetailer());
        	warehouseChoice.setValue(sale.getWarehouse().value);
        }

	}

	public void textFieldInit(){
		numberField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	boolean numberLegal = true,priceLegal = true;
            	for(int i=0;i<numberField.getText().length();i++)
            		if(numberField.getText().charAt(i)<='9'&&numberField.getText().charAt(i)>='0')
            			continue;
            		else{
            			numberLegal = false;
            			break;
            		}
            	if(numberField.getText()==null||priceField.getText()==null)
            		moneyLabel.setText("0");
            	else{
            	for(int i=0;i<priceField.getText().length();i++)
            		if((priceField.getText().charAt(i)<='9'&&priceField.getText().charAt(i)>='0')||priceField.getText().charAt(i)=='.')
            			continue;
            		else{
            			priceLegal = false;
            			break;
            		}


            	if(!priceLegal||!numberLegal)
            		moneyLabel.setText("0");
            	else
                moneyLabel.setText(String.valueOf(Integer.parseInt(numberField.getText())*Double.parseDouble(priceField.getText())));
            }
            	}
        });

		priceField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	boolean numberLegal = true,priceLegal = true;
            	if(numberField.getText()==null||priceField.getText()==null)
            		moneyLabel.setText("0");
            	else{
            	for(int i=0;i<numberField.getText().length();i++)
            		if(numberField.getText().charAt(i)<='9'&&numberField.getText().charAt(i)>='0')
            			continue;
            		else{
            			numberLegal = false;
            			break;
            		}
            	for(int i=0;i<priceField.getText().length();i++)
            		if((priceField.getText().charAt(i)<='9'&&priceField.getText().charAt(i)>='0')||priceField.getText().charAt(i)=='.')
            			continue;
            		else{
            			priceLegal = false;
            			break;
            		}


            	if(!priceLegal||!numberLegal)
            		moneyLabel.setText("0");
            	else
                moneyLabel.setText(String.valueOf(Integer.parseInt(numberField.getText())*Double.parseDouble(priceField.getText())));
            }
            	}
        });

		allowanceField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	boolean allowanceLegal = true;

            	for(int i=0;i<allowanceField.getText().length();i++)
            		if((allowanceField.getText().charAt(i)<='9'&&allowanceField.getText().charAt(i)>='0')||allowanceField.getText().charAt(i)=='.')
            			continue;
            		else{
            			allowanceLegal = false;
            			break;
            		}
            	if(allowanceLegal)
                afterLabel.setText(String.valueOf(Double.parseDouble(afterLabel.getText())-Double.parseDouble(allowanceField.getText())));
            }

        });
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
                        Button delBtn = new Button("ɾ��");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	CommodityItemVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            list.remove(clickedItem);
                            table.setItems(list);
                            double tmp = clickedItem.getTotal();
                            double result = Double.parseDouble(beforeLabel.getText())-tmp;
                            beforeLabel.setText(String.valueOf(result));
                            freshAfter();
                        });
                    }
                }

            };
            return cell;
        });
	}

	public void freshAfter(){
		double tmp = 0;
		boolean allowanceLegal = true;
    	for(int i=0;i<allowanceField.getText().length();i++)
    		if((allowanceField.getText().charAt(i)<='9'&&allowanceField.getText().charAt(i)>='0')||allowanceField.getText().charAt(i)=='.')
    			continue;
    		else{
    			allowanceLegal = false;
    			break;
    		}
		if(allowanceField.getText()!=null&&allowanceLegal)
			tmp = Double.parseDouble(allowanceField.getText());
		double before = Double.parseDouble(beforeLabel.getText());
		 afterLabel.setText(String.valueOf(before-tmp-
				 Double.parseDouble(voucherLabel.getText())-Double.parseDouble(allowanceLabel.getText())));
	}



}
