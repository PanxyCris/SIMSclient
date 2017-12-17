package vo.commodity;

public class GiftVO {

	private String name;
	private Integer number;

	public GiftVO(String name,Integer number){
		this.name = name;
		this.number = number;
	}

	public String getName(){
		return name;
	}

	public Integer getNumber(){
		return number;
	}
	public void setNumber(Integer number){
		this.number = number;
	}

}
