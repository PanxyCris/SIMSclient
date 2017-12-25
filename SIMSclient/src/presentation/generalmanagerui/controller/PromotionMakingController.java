package presentation.generalmanagerui.controller;

import java.net.URL;

import java.util.ResourceBundle;
import dataenum.PromotionType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class PromotionMakingController extends GeneralManagerController implements Initializable{

	@FXML
	ChoiceBox<String> promotionChoice;

	@FXML
	public void choosePromotion() throws Exception{
		PromotionType type = PromotionType.getType(promotionChoice.getValue());
		switch(type){
		case LEVEL_PROMOTION:changeStage("PromotionMemberUI",user,null);break;
		case PRICEPACKS:changeStage("PromotionSpecialUI",user,null);break;
		case SUM_PROMOTION:changeStage("PromotionSumUI",user,null);break;
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
				PromotionType.PRICEPACKS.value,PromotionType.SUM_PROMOTION.value));
	}


}
