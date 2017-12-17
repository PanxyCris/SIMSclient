package presentation.generalmanagerui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import dataenum.BillType;
import dataenum.PromotionType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import vo.UserVO;

public class PromotionMakingController extends GeneralManagerController implements Initializable{

	UserVO user;
	@FXML
	ChoiceBox<String> promotionChoice;

	@FXML
	public void choosePromotion() throws Exception{
		BillType type = BillType.getType(receiptChoice.getValue());
		switch(type){
		case PURCHASEBILL:changeStage("PurchaseMakeBillUI",user,type,null,null);break;
		case PURCHASEBACKBILL:changeStage("PurchaseMakeBillUI",user,type,null,null);break;
		case SALESBILL:
		case SALESBACKBILL:
		default:break;
		}
	}

	public void initData(UserVO user) throws Exception {
           this.user = user;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceInit();
	}

	public void choiceInit(){
		promotionChoice.setItems(FXCollections.observableArrayList(PromotionType.LEVEL_PROMOTION.value,
				PromotionType.LEVEL_PROMOTION.value,PromotionType.SUM_PROMOTION.value));
	}


}
