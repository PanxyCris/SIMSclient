package po.messagepo;

import java.time.LocalDateTime;

public class MessagePO {

     private LocalDateTime time;
     private String info; //��ʽ �����ࣺ"�� ����" + ���ݱ�� + ��������  + "����" + �ɹ�/ʧ��
                          //   ������: ��Ʒ��(���)+"���ھ���ֵ ��ǰ������"+��ǰ����+"���������� "+��������
     private boolean hasRead;
     public MessagePO(String info){
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
}
