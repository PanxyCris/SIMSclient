package po.messagepo;

import dataenum.BillType;
import dataenum.ResultMessage;

public class MessageBillPO extends MessagePO{

	private static final long serialVersionUID = -930864991300439700L;
	
	     private String name; //��ʽ ����(ID)
	     private String id;   //���ݱ��
	     private BillType type;
	     private ResultMessage result;  //ֻ�гɹ�����ʧ��
	     private String info; //��ʽ �����ࣺʱ��+"�� ����" + ���ݱ�� + ��������  + "����" + �ɹ�/ʧ��

	     public MessageBillPO(String name,String id,BillType type,ResultMessage result){
	    	 super(getFormatInfo(name,id,type,result));
	    	 this.name = name;
	    	 this.id = id;
	    	 this.type = type;
	    	 this.result = result;
	     }

	     public static String getFormatInfo(String name,String id,BillType type,ResultMessage result){
	    	 return "����" + id + type.value + "����" + result.value;
	     }

	     public String getName(){
	    	 return name;
	     }

	     public String getID(){
	    	 return id;
	     }

	     public BillType getType(){
	    	 return type;
	     }

	     public ResultMessage getResult(){
	    	 return result;
	     }

	     public String getInfo(){
	    	 return info;
	     }


}
