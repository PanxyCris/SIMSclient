package presentation.inventorymanagerui.controller;

import java.util.ArrayList;

import bussiness_stub.ClassificationBLService_Stub;
import bussinesslogic.classificationbl.ClassificationBL;
import bussinesslogicservice.commodityblservice.ClassificationBLService;
import dataenum.Remind;
import dataenum.ResultMessage;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.util.Callback;
import po.ClassificationVPO;
import presentation.common.EditingCellTree;
import presentation.remindui.RemindExistUI;
import presentation.remindui.RemindPrintUI;
import vo.uservo.UserVO;

public class ClassManageController extends InventoryManagerController{

	ClassificationBLService service = new ClassificationBL();
	public static final Remind remind = Remind.CLASSIFICATION;
	ObservableList<String> classList  = FXCollections.observableArrayList();

	@FXML
	TreeTableView<ClassificationVPO> tree;
	@FXML
	TreeTableColumn<ClassificationVPO,String> treeName;
	@FXML
	TreeTableColumn<ClassificationVPO,String> treeID;
	@FXML
	TreeTableColumn<ClassificationVPO,String> treeType;
	@FXML
	TreeTableColumn<ClassificationVPO,String> treeDelete;

	TreeItem<ClassificationVPO> root;

	@FXML
	TextField nameField;
	@FXML
	Label idLabel;
	@FXML
	ComboBox<String> classChoice;


	@FXML
	public void insert(){
		ClassificationVPO vo = new ClassificationVPO(idLabel.getText(),nameField.getText(),true,
				  service.getClass(classChoice.getValue()),null);
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

	public void initInsert(){
		idLabel.setText(service.getID());
		classChoice.setValue(null);
		nameField.setText(null);
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
        root = new TreeItem<>(service.getRoot());

        addAllChildren(root);
        tree.setRoot(root);
		classList.addAll(service.showName());
		classChoice.setItems(classList);
		initInsert();

		edit();
		manageInit();
	}
	/**
	 * 加入所有子节点
	 * @param item
	 */
	public void addAllChildren(TreeItem<ClassificationVPO> item){
		ArrayList<ClassificationVPO> tmpList = item.getValue().getChildren();
		  if(tmpList!=null){
		     ObservableList<TreeItem<ClassificationVPO>> list = FXCollections.observableArrayList();
		     for(int i=0;i<tmpList.size();i++){
			    TreeItem<ClassificationVPO> tmpItem = new TreeItem<>(tmpList.get(i));
			    list.add(tmpItem);
		     }
		     item.getChildren().addAll(list);

		     for(int i=0;i<item.getChildren().size();i++){
			      addAllChildren(item.getChildren().get(i));
		     }
		 }

	}



	public void edit(){
		Callback<TreeTableColumn<ClassificationVPO, String>,
	        TreeTableCell<ClassificationVPO, String>> cellFactory
	            = (TreeTableColumn<ClassificationVPO, String> p) -> new EditingCellTree<ClassificationVPO>();

	    treeName.setCellFactory(cellFactory);
	    treeName.setOnEditCommit(
	            (CellEditEvent<ClassificationVPO, String> t) -> {
	                ((TreeItem<ClassificationVPO>) t.getTreeTableView().getTreeItem(
	                        t.getTreeTablePosition().getRow())
	                        ).getValue().setName(t.getNewValue());
	                try {
						service.update (((TreeItem<ClassificationVPO>) t.getTreeTableView().getTreeItem(
		                        t.getTreeTablePosition().getRow())
		                        ).getValue());
					} catch ( Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });


	}


	public void manageInit(){
		treeID.setCellValueFactory(
			    (TreeTableColumn.CellDataFeatures<ClassificationVPO, String> param) ->
			    new ReadOnlyStringWrapper(param.getValue().getValue().getId())
			);
	    treeName.setCellValueFactory(
			    (TreeTableColumn.CellDataFeatures<ClassificationVPO, String> param) ->
			    new ReadOnlyStringWrapper(param.getValue().getValue().getName())
			);
	    treeType.setCellValueFactory(
			    (TreeTableColumn.CellDataFeatures<ClassificationVPO, String> param) ->
			    new ReadOnlyStringWrapper(param.getValue().getValue().getName())
			);

        deleteInit();

	}

	public void deleteInit(){
		treeDelete.setCellFactory((col) -> {
            TreeTableCell<ClassificationVPO, String> cell = new TreeTableCell<ClassificationVPO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	ClassificationVPO clickedUser = this.getTreeTableView().getTreeItem(this.getIndex()).getValue();
                            try {
                            	if(clickedUser.getB()==true){
								service.delete(clickedUser);
								fresh();
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
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
