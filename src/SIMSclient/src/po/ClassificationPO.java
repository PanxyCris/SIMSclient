package SIMSclient.src.po;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassificationPO implements Serializable{

	String name;
	ArrayList<CommodityPO> po;
	ClassificationPO father;
	ArrayList<ClassificationPO> children;

	public ClassificationPO(String n,ArrayList<CommodityPO> p,ClassificationPO f,ArrayList<ClassificationPO> c){
		name = n;
		po = p;
		father = f;
		children = c;
	}

	public void setName(String n){
		name = n;
	}

	public String getName(){
		return name;
	}

	public void setCommodityPOArray(ArrayList<CommodityPO> p){
		po = p;
	}

	public ArrayList<CommodityPO> getCommodityPOArray(){
		return po;
	}

	public void setFather(ClassificationPO f){
		father = f;
	}

	public ClassificationPO getFather(){
		return father;
	}

	public void setChildren(ArrayList<ClassificationPO> c){
		children = c;
	}

	public ArrayList<ClassificationPO> getChildren(){
		return children;
	}
}
