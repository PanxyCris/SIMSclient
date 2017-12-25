package dataservice.messagedataservice;

import dataenum.ResultMessage;
import po.messagepo.MessagePO;

public interface MessageDataService {

	public ResultMessage save(MessagePO message);

}
