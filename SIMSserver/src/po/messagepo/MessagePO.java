package po.messagepo;

import java.time.LocalDateTime;

public class MessagePO {

     private LocalDateTime time;
     private String info; //格式 单据类："： 您的" + 单据编号 + 单据类型  + "审批" + 成功/失败
                          //   警告类: 商品名(编号)+"低于警戒值 当前数量："+当前数量+"警戒数量： "+警戒数量
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
