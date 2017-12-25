package dataservice.messagedataservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import po.UserPO;
import po.messagepo.MessagePO;

public interface MessageDataService {

	public ResultMessage save(MessagePO message,UserPO user);

	public ArrayList<MessagePO> getMessage(UserPO user);

}
