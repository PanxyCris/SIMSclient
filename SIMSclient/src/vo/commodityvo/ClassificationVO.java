package vo.commodityvo;

import java.util.ArrayList;

public class ClassificationVO {

	private String id;
	private String name;
	private Boolean b;//true表示该分类为classification,false表示该分类实际上是商品
	private ClassificationVO father;
	private ArrayList<ClassificationVO> children;

	public ClassificationVO(String i,String n,ClassificationVO f){
		id = i;
		name = n;
		father = f;
	}

	public String getID(){
		return id;
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

	public void setFather(ClassificationVO f){
		father = f;
	}

	public ClassificationVO getFather(){
		return father;
	}

	public void setChildren(ArrayList<ClassificationVO> c){
		children = c;
	}

	public ArrayList<ClassificationVO> getChildren(){
		return children;
	}
}
