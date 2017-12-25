package bussinesslogic.utilitybl;

import java.util.Date;

import bussinesslogic.userbl.UserController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillType;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import po.messagepo.MessagePO;
import rmi.RemoteHelper;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;

public class UtilityBL implements UtilityBLService{

	private static final int BILLIDNUMBERLENGTH=5;//单据编号中单据数目属性的字符串长度

	private static UtilityBL utilityBL = new UtilityBL();
	private MessageDataService messageService;
	UserController bl = new UserController();

	public UtilityBL(){
     	messageService = RemoteHelper.getInstance().getMessageDataService();
	}

	public static UtilityBL getInstance(){
		return utilityBL;
	}

	public UtilityBLService getUtilityBLService(){
		return (UtilityBLService)utilityBL;
	}

	@Override
	public boolean isPrintLegal(ArrayList<String> list) {
		return false;
	}

	@Override
	public String generateID(BillType billType) {//number为服务器上目前该类型单据的数目
		String id="";

		String type=billType.prefix;

		Date date=new Date();

		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");

		String now=simpleDateFormat.format(date);



		String num=Integer.toString(1);//how to get current bills number?



		int numLength=num.length();
		for (int i = 0; i < BILLIDNUMBERLENGTH-numLength; i++) {
			num="0"+num;
		}

		id=type+"-"+now+"-"+num;

		return id;
	}

	@Override
	public ArrayList<MessageVO> getMessage(UserVO user) {
        UserPO po = bl.voTopo(user);
		ArrayList<MessageVO> messages = new ArrayList<>();
		for(MessagePO message:messageService.getMessage(po))
			messages.add(poTovo(message));
		return messages;
	}

	@Override
	public boolean hasMessage(UserVO user) {
		for(MessagePO message:messageService.getMessage(bl.voTopo(user)))
			if(message.getHasRead() == false)
				return true;
		return false;
	}

	public MessagePO voTopo(MessageVO vo){
		MessagePO po = new MessagePO(vo.getInfo());
		po.setHasRead(vo.getHasRead());
		return po;
	}

	public MessageVO poTovo(MessagePO po){
		MessageVO vo = new MessageVO(po.getInfo());
		vo.setHasRead(po.getHasRead());
		return vo;
	}

}
