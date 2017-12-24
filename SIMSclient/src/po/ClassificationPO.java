package po;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassificationPO implements Serializable{

	private static final long serialVersionUID = -1575927402071619530L;
	private String id;
	private String name;
	private Boolean b;//true表示该分类为classification,false表示该分类实际上是商品
	private String fatherName;
	private ArrayList<String> childrenName;

	public ClassificationPO(String id, String n,Boolean b,String f,ArrayList<String> c){
		this.id = id;
		this.name = n;
		this.b = b;
		this.fatherName = f;
		this.childrenName = c;
	}

	public void setName(String n){
		name = n;
	}

	public String getName(){
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getB() {
		return b;
	}

	public void setB(Boolean b) {
		this.b = b;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public ArrayList<String> getChildrenName() {
		return childrenName;
	}

	public void setChildrenName(ArrayList<String> childrenName) {
		this.childrenName = childrenName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
