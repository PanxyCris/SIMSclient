package presentation.inventorymanagerui.controller;

import java.util.ArrayList;

import bussiness_stub.ClassificationBLService_Stub;
import bussinesslogic.commoditybl.ClassificationBL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.util.Callback;
import presentation.common.EditingCellTree;
import presentation.remindui.RemindExistUI;
import presentation.remindui.RemindPrintUI;
import vo.commodityvo.ClassificationVO;
import vo.uservo.UserVO;

public class ClassManageController extends InventoryManagerController{

	ClassificationBLService service = new ClassificationBLService_Stub();
	public static final Remind remind = Remind.CLASSIFICATION;
	ObservableList<String> classList  = FXCollections.observableArrayList();

	@FXML
	TreeTableView<ClassificationVO> tree;
	@FXML
	TreeTableColumn<ClassificationVO,String> treeName;
	@FXML
	TreeTableColumn<ClassificationVO,String> treeID;
	@FXML
	TreeTableColumn<ClassificationVO,String> treeDelete;

	TreeItem<ClassificationVO> root;

	@FXML
	TextField nameField;
	@FXML
	Label idLabel;
	@FXML
	ChoiceBox<String> classChoice;


	@FXML
	public void insert(){
		ClassificationVO vo = new ClassificationVO(idLabel.getText(),nameField.getText(),
				  service.getClass(classChoice.getValue()));
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


	public void initData(UserVO user) throws Exception {
		this.user = user;
        root = new TreeItem<>(service.getRoot());

        addAllChildren(root);
        tree.setRoot(root);
		classList.addAll(service.getAllChildrenClass());
		classChoice.setItems(classList);

		idLabel.setText(service.getID());
		classChoice.setValue(null);
		nameField.setText(null);

		edit();
		manageInit();
	}
	/**
	 * 加入所有子节点
	 * @param item
	 */
	public void addAllChildren(TreeItem<ClassificationVO> item){
		ArrayList<ClassificationVO> tmpList = item.getValue().getChildren();
	//	ArrayList<CommodityVO> commodityList = item.getValue().getCommodityVOArray();
		  if(tmpList!=null){
		     ObservableList<TreeItem<ClassificationVO>> list = FXCollections.observableArrayList();
		     for(int i=0;i<tmpList.size();i++){
			    TreeItem<ClassificationVO> tmpItem = new TreeItem<>(tmpList.get(i));
			    list.add(tmpItem);
		     }
		     item.getChildren().addAll(list);

		     for(int i=0;i<item.getChildren().size();i++){
			      addAllChildren(item.getChildren().get(i));
		     }
		 }

	}



	public void edit(){
		Callback<TreeTableColumn<ClassificationVO, String>,
	        TreeTableCell<ClassificationVO, String>> cellFactory
	            = (TreeTableColumn<ClassificationVO, String> p) -> new EditingCellTree<ClassificationVO>();

	    treeName.setCellFactory(cellFactory);
	    treeName.setOnEditCommit(
	            (CellEditEvent<ClassificationVO, String> t) -> {
	                ((TreeItem<ClassificationVO>) t.getTreeTableView().getTreeItem(
	                        t.getTreeTablePosition().getRow())
	                        ).getValue().setName(t.getNewValue());
	                try {
						service.update (((TreeItem<ClassificationVO>) t.getTreeTableView().getTreeItem(
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
			    (TreeTableColumn.CellDataFeatures<ClassificationVO, String> param) ->
			    new ReadOnlyStringWrapper(param.getValue().getValue().getID())
			);
	    treeName.setCellValueFactory(
			    (TreeTableColumn.CellDataFeatures<ClassificationVO, String> param) ->
			    new ReadOnlyStringWrapper(param.getValue().getValue().getName())
			);

        deleteInit();

	}

	public void deleteInit(){
		treeDelete.setCellFactory((col) -> {
            TreeTableCell<ClassificationVO, String> cell = new TreeTableCell<ClassificationVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	ClassificationVO clickedUser = this.getTreeTableView().getTreeItem(this.getIndex()).getValue();
                            try {
								service.delete(clickedUser);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                            try {
								fresh();
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
