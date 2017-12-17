package vo.message;

import java.time.LocalDate;
import java.time.LocalTime;


public class MessageVO {

     private LocalDate date;
     private LocalTime time;
     private String info; //��ʽ �����ࣺ"�� ����" + ���ݱ�� + ��������  + "����" + �ɹ�/ʧ��
                          //   ������: ��Ʒ��(���)+"���ھ���ֵ ��ǰ������"+��ǰ����+"���������� "+��������
     public MessageVO(String info){
    	 this.date = LocalDate.now();
    	 this.time = LocalTime.now();
    	 this.info = info;
     }


     public LocalDate getDate(){
    	 return date;
     }

     public LocalTime getTime(){
    	 return time;
     }

     public String getInfo(){
    	 return info;
     }

}
