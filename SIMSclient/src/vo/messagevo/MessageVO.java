package vo.messagevo;

import java.time.LocalDateTime;

public class MessageVO {

     private LocalDateTime time;
     private String info; //��ʽ �����ࣺ"�� ����" + ���ݱ�� + ��������  + "����" + �ɹ�/ʧ��
                          //   ������: ��Ʒ��(���)+"���ھ���ֵ ��ǰ������"+��ǰ����+"���������� "+��������
     public MessageVO(String info){
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
