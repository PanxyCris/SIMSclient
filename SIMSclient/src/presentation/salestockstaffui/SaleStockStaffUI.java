package presentation.salestockstaffui;

import presentation.common.StageController;
import presentation.salestockstaffui.controller.SaleStockStaffUIController;
import vo.UserVO;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class SaleStockStaffUI{

	public static final String mainID = "SaleStockStaffUI";
	public static final String pack = "../salestockstaffui/fxml/";
	public static final String mainFXML = pack+"SaleStockStaffUI.fxml";
    private StageController stageController;

	public void start(UserVO user) throws Exception {
		Stage primaryStage = new Stage();
		stageController = new StageController();

        //将主舞台交给控制器处理
        stageController.setPrimaryStage("primaryStage", primaryStage);


        stageController.loadStage(mainID, mainFXML);

        //显示MainView舞台
        stageController.setStage(mainID);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/SaleStockStaffUI.fxml"));
        SaleStockStaffUIController controller = loader.<SaleStockStaffUIController>getController();
	    controller.initData(user);

	}




}
