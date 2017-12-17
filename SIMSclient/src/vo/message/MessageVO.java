package vo.message;

import java.time.LocalDate;
import java.time.LocalTime;


public class MessageVO {

     private LocalDate date;
     private LocalTime time;
     private String info; //格式 单据类："： 您的" + 单据编号 + 单据类型  + "审批" + 成功/失败
                          //   警告类: 商品名(编号)+"低于警戒值 当前数量："+当前数量+"警戒数量： "+警戒数量
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
