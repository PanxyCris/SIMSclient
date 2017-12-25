package data.messagedata;

import dataenum.ResultMessage;
import dataservice.messagedataservice.MessageDataService;
import po.messagepo.MessagePO;

public class MessageDataServiceImpl implements MessageDataService{

	@Override
	public ResultMessage save(MessagePO message) {
		String sql = "" + "insert into message";
		return null;
	}

}
