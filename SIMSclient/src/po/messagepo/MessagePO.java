package po.messagepo;

import java.time.LocalDateTime;

public class MessagePO {

     private LocalDateTime time;
     private String info; //��ʽ �����ࣺ"�� ����" + ���ݱ�� + ��������  + "����" + �ɹ�/ʧ��
                          //   ������: ��Ʒ��(���)+"���ھ���ֵ ��ǰ������"+��ǰ����+"���������� "+��������
     public MessagePO(String info){
    	 this.time = LocalDateTime.now();
    	 this.info = info;
     }


     public LocalDateTime getTime(){
    	 return time;
     }


     public String getInfo(){
    	 return info;
     }

}
