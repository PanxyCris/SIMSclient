package vo.accountbookvo;

import java.util.ArrayList;

import vo.accountvo.AccountVO;
import vo.commodityvo.CommodityVO;
import vo.membervo.MemberVO;

public class AccountBookVO {
	private String id;
	private String date;
	private String clerkID;//����ԱID
	private ArrayList<CommodityVO> commodityVOs;//��Ʒ�б�
	private ArrayList<MemberVO> memberVOs;//�ͻ��б�
	private ArrayList<AccountVO> accountVOs;//�˻��б�

	public AccountBookVO(String id,String data, String clerkID,ArrayList<CommodityVO> commodityVOs,ArrayList<MemberVO> memberVOs
			,ArrayList<AccountVO> accountVOs) {
		this.id=id;
		this.date=data;
		this.clerkID=clerkID;
		this.commodityVOs=commodityVOs;
		this.memberVOs=memberVOs;
		this.accountVOs=accountVOs;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClerkID() {
		return clerkID;
	}

	public void setClerkID(String clerkID) {
		this.clerkID = clerkID;
	}

	public ArrayList<CommodityVO> getCommodityVOs() {
		return commodityVOs;
	}

	public void setCommodityVOs(ArrayList<CommodityVO> commodityVOs) {
		this.commodityVOs = commodityVOs;
	}

	public ArrayList<MemberVO> getMemeberVOs() {
		return memberVOs;
	}

	public void setMemeberVOs(ArrayList<MemberVO> memberVOs) {
		this.memberVOs = memberVOs;
	}

	public ArrayList<AccountVO> getAccountVOs() {
		return accountVOs;
	}

	public void setAccountVOs(ArrayList<AccountVO> accountVOs) {
		this.accountVOs = accountVOs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
