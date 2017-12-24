package po;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassificationVPO implements Serializable{

	private static final long serialVersionUID = -1575927402071619530L;
	private String id;
	private String name;
	private Boolean b;//true表示该分类为classification,false表示该分类实际上是商品
	private ClassificationVPO fatherName;
	private ArrayList<ClassificationVPO> childrenName;

	public ClassificationVPO(String id, String n,Boolean b,ClassificationVPO f,ArrayList<ClassificationVPO> c){
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

	public ClassificationVPO getFatherName() {
		return fatherName;
	}

	public void setFatherName(ClassificationVPO fatherName) {
		this.fatherName = fatherName;
	}

	public ArrayList<ClassificationVPO> getChildrenName() {
		return childrenName;
	}

	public void setChildrenName(ArrayList<ClassificationVPO> childrenName) {
		this.childrenName = childrenName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
