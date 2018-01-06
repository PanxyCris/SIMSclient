package vo.messagevo;

import java.time.LocalDateTime;

public class MessageVO {

	 private String messageID;
     private LocalDateTime time;
     private String info; //格式 单据类："： 您的" + 单据编号 + 单据类型  + "审批" + 成功/失败
                          //   警告类: 商品名(编号)+"低于警戒值 当前数量："+当前数量+"警戒数量： "+警戒数量
     private boolean hasRead;
     public MessageVO(String id,String info){
    	 this.setMessageID(id);
    	 this.time = LocalDateTime.now();
    	 this.info = info;
    	 hasRead = false;
     }

     public LocalDateTime getTime(){
    	 return time;
     }

     public String getInfo(){
    	 return info;
     }

     public boolean getHasRead(){
    	 return hasRead;
     }

     public void setHasRead(boolean hasRead){
    	 this.hasRead = hasRead;
     }

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}


}
