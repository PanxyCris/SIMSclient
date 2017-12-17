package vo.messagevo;

public class MessageWarmingVO extends MessageVO{

	private String  name;  //��Ʒ��(��ƷID)
	private Integer warmingNumber;
	private Integer currentNumber;


	public MessageWarmingVO(String name,Integer currentNumber,Integer warmingNumber){
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
