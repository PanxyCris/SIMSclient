package po.commodity;

public class GiftPO {

	private String name;
	private Integer number;

	public GiftPO(String name,Integer number){
		this.name = name;
		this.number = number;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber(){
		return number;
	}
	public void setNumber(Integer number){
		this.number = number;
	}

}
