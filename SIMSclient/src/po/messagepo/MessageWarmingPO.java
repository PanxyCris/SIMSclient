package po.messagepo;

public class MessageWarmingPO extends MessagePO{

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	*/
	private static final long serialVersionUID = -3749787341425253367L;
	/**
	 *
	 */

	private String  name;  //商品名(商品ID)
	private Integer warmingNumber;
	private Integer currentNumber;


	public MessageWarmingPO(String name,int currentNumber,int warmingNumber){
		super(getFormatInfo(name,currentNumber,warmingNumber));
		this.name = name;
		this.warmingNumber = warmingNumber;
		this.currentNumber = currentNumber;
	}

    public static String getFormatInfo(String name,Integer currentNumber,Integer warmingNumber){
   	 return name+"低于警戒值 当前数量："+String.valueOf(currentNumber)+" 警戒数量： "+String.valueOf(warmingNumber);
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
