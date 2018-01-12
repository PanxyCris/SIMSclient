package po.messagepo;

import java.time.LocalDateTime;

public class MessageWarmingPO extends MessagePO{

	/**
	* <p>Title: </p>
	* <p>Description: </p>
	*/
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */

	private String  name;  //��Ʒ��(��ƷID)
	private Integer warmingNumber;
	private Integer currentNumber;


	public MessageWarmingPO(String messageID,String userID,LocalDateTime time,boolean hasRead,String name,int currentNumber,int warmingNumber){
		super(messageID,userID,getFormatInfo(name,currentNumber,warmingNumber),time,hasRead);
		this.name = name;
		this.warmingNumber = warmingNumber;
		this.currentNumber = currentNumber;
	}

    public static String getFormatInfo(String name,Integer currentNumber,Integer warmingNumber){
   	 return name+"���ھ���ֵ ��ǰ������"+String.valueOf(currentNumber)+" ���������� "+String.valueOf(warmingNumber);
    }

    public String getName(){
    	return name;
    }

    public Integer getCurrentNumber(){
    	return currentNumber;
    }

    public Integer getWarmingNumber(){
    	return warmingNumber;
    }
}
