package po;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassificationVPO implements Serializable{

	private static final long serialVersionUID = -1575927402071619530L;
	private String id;
	private String name;
	private Boolean b;//true表示该分类为classification,false表示该分类实际上是商品
	private ClassificationVPO father;
	private ArrayList<ClassificationVPO> children;

	public ClassificationVPO(String id, String n,Boolean b,ClassificationVPO f,ArrayList<ClassificationVPO> c){
		this.id = id;
		this.name = n;
		this.b = b;
		this.father= f;
		this.children = c;
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

	public ClassificationVPO getFather() {
		return father;
	}

	public void setFather(ClassificationVPO father) {
		this.father = father;
	}

	public ArrayList<ClassificationVPO> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<ClassificationVPO> children) {
		this.children = children;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
