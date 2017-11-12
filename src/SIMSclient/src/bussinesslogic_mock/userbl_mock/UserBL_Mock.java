package SIMSclient.src.bussinesslogic_mock.userbl_mock;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.bussinesslogic.userbl.UserBL;
import SIMSclient.src.po.UserPO;
import SIMSclient.src.vo.UserVO;

public class UserBL_Mock extends UserBL{

	UserVO vo;
	UserPO po;

    public UserBL_Mock(){

    }

    public ResultMessage getAuthority(){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage getRole(){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage insert(UserVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage delete(UserVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage update(UserVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage find(UserVO vo){
    	return ResultMessage.SUCCESS;
    }


}
