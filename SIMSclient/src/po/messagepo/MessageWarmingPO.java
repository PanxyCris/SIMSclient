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

	private String  name;  //��Ʒ��(��ƷID)
	private Integer warmingNumber;
	private Integer currentNumber;


	public MessageWarmingPO(String name,int currentNumber,int warmingNumber){
		super(getFormatInfo(name,currentNumber,warmingNumber));
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
