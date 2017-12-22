package vo.commodityvo;

import java.util.ArrayList;

public class ClassificationVO {

	String id;
	String name;
	ArrayList<CommodityVO> vo; //每一个class其要么只有子分类要么只能有子商品
	ClassificationVO father;
	ArrayList<ClassificationVO> children;

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

	public void setCommodityVOArray(ArrayList<CommodityVO> v){
		vo = v;
	}

	public ArrayList<CommodityVO> getCommodityVOArray(){
		return vo;
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
