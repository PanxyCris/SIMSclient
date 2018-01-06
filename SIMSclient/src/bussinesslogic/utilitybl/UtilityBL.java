package bussinesslogic.utilitybl;

import java.util.Date;

import bussinesslogic.userbl.UserController;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bussinesslogicservice.utilityblservice.UtilityBLService;
import dataenum.BillType;
import dataenum.UserRole;
import dataenum.findtype.FindUserType;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import po.commodity.CommodityPO;
import po.messagepo.MessagePO;
import po.messagepo.MessageWarmingPO;
import rmi.RemoteHelper;
import vo.messagevo.MessageVO;
import vo.uservo.UserVO;

public class UtilityBL implements UtilityBLService{

	private static final int BILLIDNUMBERLENGTH=5;//���ݱ���е�����Ŀ���Ե��ַ�������

	private static UtilityBL utilityBL = new UtilityBL();
	private MessageDataService messageService;
	private UserDataService userService;
	UserController bl = new UserController();

	public UtilityBL(){
     	messageService = RemoteHelper.getInstance().getMessageDataService();
     	userService = RemoteHelper.getInstance().getUserDataService();
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

	@Override//���������ʱ�ϳ�������
	public String generateID(BillType billType) {//numberΪ��������Ŀǰ�����͵��ݵ���Ŀ
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
		try {
			ArrayList<MessagePO> messagesData = messageService.getMessage(po);
			if(messagesData==null)
				return null;
			else
			for(MessagePO message:messagesData)
				messages.add(poTovo(message));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return messages;
	}

	@Override
	public boolean hasMessage(UserVO user) {
		try {
			ArrayList<MessagePO> messages = messageService.getMessage(bl.voTopo(user));
			if(messages!=null)
			for(MessagePO message:messages)
				if(message.getHasRead() == false)
					return true;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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

	@Override
	public void warningMessage(CommodityPO po) throws RemoteException{
        if(po.getNumber()<=po.getWarmingValue()){
      	  MessageWarmingPO message = new MessageWarmingPO(po.getName()+"("+po.getID()+")",po.getNumber(),po.getWarmingValue());
      	  ArrayList<UserPO> inventorymanagers = userService.findUser(UserRole.INVENTORY_MANAGER.value, FindUserType.USERROLE);
      	  for(UserPO user:inventorymanagers)
      		  messageService.save(message, user);
        }
	}
	
	public String getMessageID(){
		
	}

}
