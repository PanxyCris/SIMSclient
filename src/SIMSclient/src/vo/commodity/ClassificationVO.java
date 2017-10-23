package SIMSclient.src.vo.commodity;

import java.util.ArrayList;

import SIMSclient.src.po.ClassificationPO;
import SIMSclient.src.po.CommodityPO;

public class ClassificationVO {

	String name;
	ArrayList<CommodityVO> vo;
	ClassificationVO father;
	ArrayList<ClassificationVO> children;

	public ClassificationVO(String n,ArrayList<CommodityVO> v,ClassificationVO f,ArrayList<ClassificationVO> c){
		name = n;
		vo = v;
		father = f;
		children = c;
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
