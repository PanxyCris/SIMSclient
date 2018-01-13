package vo.messagevo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageVO implements Serializable{

	 private static final long serialVersionUID = 1L;
	 private String messageID;
	 private String userID;
     private LocalDateTime time;
     private String info; //��ʽ �����ࣺ"�� ����" + ���ݱ�� + ��������  + "����" + �ɹ�/ʧ��
                          //   ������: ��Ʒ��(���)+"���ھ���ֵ ��ǰ������"+��ǰ����+"���������� "+��������
     private boolean hasRead;
     public MessageVO(String messageID,String userID,String info,LocalDateTime time,boolean hasRead){
    	 this.setMessageID(messageID);
    	 this.setUserID(userID);
    	 this.time = time;
    	 this.info = info;
    	 this.hasRead = hasRead;
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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}